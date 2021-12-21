package com.xihua;

import com.xihua.entity.model.SysPermission;
import com.xihua.entity.model.SysUser;
import com.xihua.service.SingleChoiceQuestionsService;
import com.xihua.service.SysPermissionService;
import com.xihua.service.SysUserService;
import com.xihua.utils.JsonResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OnlineExamSystemApplicationTests {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysPermissionService sysPermissionService;
    @Autowired
    private SingleChoiceQuestionsService singleChoiceQuestionsService;

    @Test
    void contextLoads() {
        SysUser user2 = sysUserService.selectByName("student");
        List<SysPermission> sysPermissions = sysPermissionService.selectListByUser(user2.getId());
        System.out.println(sysPermissions);
    }

    @Test
    public void testSingleChoice() {
        JsonResult result = singleChoiceQuestionsService.queryAllSingleChoice();
        System.out.println(result);
    }
}
