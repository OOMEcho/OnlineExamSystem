package com.xihua.dao;

import com.xihua.entity.model.SysRole;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}