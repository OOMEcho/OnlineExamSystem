package com.xihua.dao;

import com.xihua.entity.model.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByName(String userName);
}