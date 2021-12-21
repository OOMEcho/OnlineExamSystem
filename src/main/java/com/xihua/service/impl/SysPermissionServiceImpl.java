package com.xihua.service.impl;

import com.xihua.dao.SysPermissionDao;
import com.xihua.entity.model.SysPermission;
import com.xihua.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:   lxs
 * Date:     2021/11/27 21:40
 * Description: 用户权限业务实现层
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionDao permissionDao;

    @Override
    public List<SysPermission> selectListByUser(Integer userId) {
        return permissionDao.selectListByUser(userId);
    }

    @Override
    public List<SysPermission> selectListByPath(String requestUrl) {
        return permissionDao.selectListByPath(requestUrl);
    }
}
