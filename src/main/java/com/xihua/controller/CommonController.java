package com.xihua.controller;

import com.xihua.entity.dto.ExamPaperDTO;
import com.xihua.entity.dto.ExamUserDTO;
import com.xihua.service.CommonService;
import com.xihua.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author:   lxs
 * Date:     2021/12/22 8:51
 * Description: 公共接口层
 */
@Api("公共接口层")
@RestController
public class CommonController {

    @Autowired
    private CommonService commonService;

    /**
     * 新增考试试卷
     *
     * @param examPaperDTOS 试卷数据
     */
    @ApiOperation("新增考试试卷")
    @PostMapping(value = "addExamPaper", produces = "application/json;charset=UTF-8")
    public JsonResult addExamPaper(@RequestBody List<ExamPaperDTO> examPaperDTOS) {
        return commonService.addExamPaper(examPaperDTOS);
    }

    /**
     * 考试记录
     *
     * @param userId 用户id
     */
    @ApiOperation("考试记录")
    @ApiImplicitParam(name = "userId", value = "用户主键Id", required = true)
    @GetMapping(value = "findUserExamInfo/{userId}", produces = "application/json;charset=UTF-8")
    public JsonResult findUserExamInfo(@PathVariable Integer userId) {
        return commonService.findUserExamInfo(userId);
    }

    /**
     * 查看考试试卷(参加考试)
     */
    @ApiOperation("查看考试试卷(参加考试)")
    @ApiImplicitParam(name = "examId", value = "考试编号", required = true)
    @GetMapping(value = "queryExamPaper/{examId}", produces = "application/json;charset=UTF-8")
    public JsonResult queryExamPaper(@PathVariable Integer examId) {
        return commonService.queryExamPaperInfo(examId);
    }

    /**
     * 新增用户考试记录
     *
     * @param examUserDTO 用户考试记录
     */
    @ApiOperation("新增用户考试记录")
    @PostMapping(value = "addUserExamRecord", produces = "application/json;charset=UTF-8")
    public JsonResult addUserExamRecord(ExamUserDTO examUserDTO) {
        return commonService.addUserExamRecord(examUserDTO);
    }
}
