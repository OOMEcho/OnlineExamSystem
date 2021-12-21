package com.xihua.service;

import com.xihua.entity.model.SysUser;

/**
 * Author:   lxs
 * Date:     2021/11/27 21:30
 * Description: 用户业务层
 */
public interface SysUserService {

    /**
     * 根据用户名查询用户
     *
     * @param userName 用户名
     */
    SysUser selectByName(String userName);

    /**
     * 根据所给条件动态更新
     *
     * @param user 用户信息
     */
    int dynamicUpdateUser(SysUser user);
}
