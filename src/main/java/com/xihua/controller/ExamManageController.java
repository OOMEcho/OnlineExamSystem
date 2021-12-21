package com.xihua.controller;

import com.xihua.entity.model.ExamManage;
import com.xihua.service.ExamManageService;
import com.xihua.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author:   lxs
 * Date:     2021/12/21 19:52
 * Description: 考试管理接口层
 */
@Api("考试管理接口层")
@RestController
public class ExamManageController {

    @Autowired
    private ExamManageService examManageService;

    /**
     * 新增考试信息
     */
    @ApiOperation("新增考试信息")
    @PostMapping(value = "addExamInfo", produces = "application/json;charset=UTF-8")
    public JsonResult addExamInfo(ExamManage examManage) {
        return examManageService.addExamInfo(examManage);
    }

    /**
     * 查询考试列表
     */
    @ApiOperation("查询考试列表")
    @GetMapping(value = "queryAllExam", produces = "application/json;charset=UTF-8")
    public JsonResult queryAllExam() {
        return examManageService.queryAllExam();
    }

    /**
     * 修改考试内容
     */
    @ApiOperation("修改考试内容")
    @PutMapping(value = "updateExam", produces = "application/json;charset=UTF-8")
    public JsonResult updateExam(ExamManage examManage) {
        return examManageService.updateExam(examManage);
    }

    /**
     * 根据考试编号删除考试
     */
    @ApiOperation("根据考试编号删除考试")
    @ApiImplicitParam(name = "examId", value = "考试编号", required = true)
    @DeleteMapping(value = "deleteExam/{examId}", produces = "application/json;charset=UTF-8")
    public JsonResult deleteExam(@PathVariable Integer examId) {
        return examManageService.deleteExam(examId);
    }
}
