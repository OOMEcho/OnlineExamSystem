package com.xihua.config.security;

import com.alibaba.fastjson.JSON;
import com.xihua.entity.model.SysUser;
import com.xihua.service.SysUserService;
import com.xihua.utils.BeanContextUtils;
import com.xihua.utils.JsonResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:   lxs
 * Date:     2021/11/27 22:49
 * Description:自定义返回信息
 */
public class MyAuthenticationHandler implements AuthenticationEntryPoint, AuthenticationSuccessHandler, AuthenticationFailureHandler, LogoutSuccessHandler, SessionInformationExpiredStrategy, AccessDeniedHandler {

    /**
     * 匿名用户访问无权限资源时（即未登录，或者登录状态过期失效）的处理逻辑
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        JsonResult result = JsonResult.build(403, "用户未登录", e.getMessage());
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
    }

    /**
     * 登录成功处理逻辑
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Map<String, Object> map = new HashMap<>();
        User userDetail = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SysUserService userService = BeanContextUtils.getBean(SysUserService.class);
        SysUser sysUser = userService.selectByName(userDetail.getUsername());
        sysUser.setLastLoginTime(new Date());
        userService.dynamicUpdateUser(sysUser);
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        map.put("authorities", authorities);
        map.put("info", sysUser);
        JsonResult result = JsonResult.success("登录成功", map);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));

    }

    /**
     * 登录失败处理逻辑
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        JsonResult result = null;
        if (e instanceof AccountExpiredException) {
            result = JsonResult.error("账号过期", e.getMessage());
        } else if (e instanceof BadCredentialsException) {
            result = JsonResult.error("密码错误", e.getMessage());
        } else if (e instanceof CredentialsExpiredException) {
            result = JsonResult.error("密码过期", e.getMessage());
        } else if (e instanceof DisabledException) {
            result = JsonResult.error("账号不可用", e.getMessage());
        } else if (e instanceof LockedException) {
            result = JsonResult.error("账号锁定", e.getMessage());
        } else if (e instanceof InternalAuthenticationServiceException) {
            result = JsonResult.error("用户不存在", e.getMessage());
        } else {
            result = JsonResult.error("未知错误，请联系管理员", e.getMessage());
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
    }

    /**
     * 注销登录处理逻辑
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        JsonResult result = JsonResult.success("注销成功");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
    }

    /**
     * 会话信息过期策略
     */
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
        JsonResult result = JsonResult.build(401, "您的账号在异地登录，可能由于密码泄露，建议修改密码", null);
        HttpServletResponse response = sessionInformationExpiredEvent.getResponse();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
    }

    /**
     * 权限拒绝处理逻辑
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        JsonResult result = JsonResult.build(403, "权限不足", e.getMessage());
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
    }
}
