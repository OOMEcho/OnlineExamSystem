package com.xihua.config.security;

import cn.hutool.core.util.ObjectUtil;
import com.xihua.entity.model.SysPermission;
import com.xihua.entity.model.SysUser;
import com.xihua.service.SysPermissionService;
import com.xihua.service.SysUserService;
import com.xihua.utils.BeanContextUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:   lxs
 * Date:     2021/11/27 20:55
 * Description: 用户认证
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || "".equals(username)) {
            throw new RuntimeException("用户不能为空");
        }
        SysUserService sysUserService = BeanContextUtils.getBean(SysUserService.class);
        //根据用户名查询用户
        SysUser sysUser = sysUserService.selectByName(username);
        if (sysUser == null) {
            throw new RuntimeException("用户不存在");
        }
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(sysUser)) {
            SysPermissionService sysPermissionService = BeanContextUtils.getBean(SysPermissionService.class);
            //获取该用户所拥有的权限
            List<SysPermission> sysPermissions = sysPermissionService.selectListByUser(sysUser.getId());
            //声明用户授权
            sysPermissions.forEach(sysPermission -> {
                SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(sysPermission.getPermissionCode());
                grantedAuthorities.add(grantedAuthority);
            });
        }
        return new User(sysUser.getAccount(), sysUser.getPassword(), sysUser.getEnabled(), sysUser.getAccountNonExpired(), sysUser.getCredentialsNonExpired(), sysUser.getAccountNonLocked(), grantedAuthorities);
    }
}
