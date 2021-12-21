package com.xihua.service;

import com.xihua.entity.model.SysPermission;

import java.util.List;

/**
 * Author:   lxs
 * Date:     2021/11/27 21:38
 * Description: 用户业务层
 */
public interface SysPermissionService {

    /**
     * 查询用户的权限列表
     *
     * @param userId 用户id
     */
    List<SysPermission> selectListByUser(Integer userId);

    /**
     * 根据url查询权限集合
     *
     * @param requestUrl url
     */
    List<SysPermission> selectListByPath(String requestUrl);
}
