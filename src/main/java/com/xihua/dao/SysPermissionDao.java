package com.xihua.dao;

import com.xihua.entity.model.SysPermission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysPermissionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

    List<SysPermission> selectListByUser(Integer userId);

    List<SysPermission> selectListByPath(String path);
}