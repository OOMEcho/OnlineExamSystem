package com.xihua.config.security;

import com.xihua.config.security.customize.CustomizeAbstractSecurityInterceptor;
import com.xihua.config.security.customize.CustomizeAccessDecisionManager;
import com.xihua.config.security.customize.CustomizeFilterInvocationSecurityMetadataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * Author:   lxs
 * Date:     2021/11/27 20:52
 * Description: Security配置类
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //访问决策管理器
    @Autowired
    CustomizeAccessDecisionManager accessDecisionManager;

    //实现权限拦截
    @Autowired
    CustomizeFilterInvocationSecurityMetadataSource securityMetadataSource;

    @Autowired
    private CustomizeAbstractSecurityInterceptor securityInterceptor;

    /**
     * 认证
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceBean());
    }

    /**
     * http相关配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();//禁用csrf
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(accessDecisionManager);//决策管理器
                        o.setSecurityMetadataSource(securityMetadataSource);//安全元数据源
                        return o;
                    }
                })
                //异常处理(权限拒绝、登录失效等)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new MyAuthenticationHandler())//匿名用户访问无权限资源时的异常处理
                .accessDeniedHandler(new MyAuthenticationHandler())//权限拒绝处理逻辑
                .and()
                //登入
                .formLogin()//开启表单登录
                .permitAll()//允许所有用户
                .successHandler(new MyAuthenticationHandler())//登录成功处理逻辑
                .failureHandler(new MyAuthenticationHandler())//登录失败处理逻辑
                .and()
                //登出
                .logout()
                .permitAll()//允许所有用户
                .logoutSuccessHandler(new MyAuthenticationHandler())//登出成功处理逻辑
                .deleteCookies("JSESSIONID")//登出之后删除Cookie
                //会话管理
                .and()
                .sessionManagement()
                .maximumSessions(1)//同一账号同时登录最大用户数
                .expiredSessionStrategy(new MyAuthenticationHandler());//会话信息过期策略(账号被挤下线)
        http.addFilterBefore(securityInterceptor, FilterSecurityInterceptor.class);
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
