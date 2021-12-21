package com.xihua.service.impl;

import com.xihua.dao.SysUserDao;
import com.xihua.entity.model.SysUser;
import com.xihua.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author:   lxs
 * Date:     2021/11/27 21:41
 * Description: 用户业务实现层
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser selectByName(String userName) {
        return sysUserDao.selectByName(userName);
    }

    @Transactional
    @Override
    public int dynamicUpdateUser(SysUser user) {
        return sysUserDao.updateByPrimaryKeySelective(user);
    }
}
