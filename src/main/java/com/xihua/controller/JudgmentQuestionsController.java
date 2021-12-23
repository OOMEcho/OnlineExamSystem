package com.xihua.controller;

import com.xihua.entity.model.JudgmentQuestions;
import com.xihua.service.JudgmentQuestionsService;
import com.xihua.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author:   lxs
 * Date:     2021/12/6 15:08
 * Description: 判断题控制层
 */
@Api("判断题控制层")
@RestController
public class JudgmentQuestionsController {

    @Autowired
    private JudgmentQuestionsService judgmentQuestionsService;

    /**
     * 新增判断题
     */
    @ApiOperation("新增判断题")
    @PostMapping(value = "addJudgment", produces = "application/json;charset=UTF-8")
    public JsonResult addJudgment(JudgmentQuestions questions) {
        return judgmentQuestionsService.addJudgment(questions);
    }

    /**
     * 根据主键id删除判断题
     */
    @ApiOperation("根据主键id删除判断题")
    @ApiImplicitParam(name = "id", value = "主键Id", required = true)
    @DeleteMapping(value = "deleteJudgment/{id}", produces = "application/json;charset=UTF-8")
    public JsonResult deleteJudgment(@PathVariable Integer id) {
        return judgmentQuestionsService.deleteJudgment(id);
    }

    /**
     * 根据主键id查询判断题
     */
    @ApiOperation("根据主键id查询判断题")
    @ApiImplicitParam(name = "id", value = "主键Id", required = true)
    @GetMapping(value = "queryJudgment/{id}", produces = "application/json;charset=UTF-8")
    public JsonResult queryJudgment(@PathVariable Integer id) {
        return judgmentQuestionsService.queryJudgment(id);
    }

    /**
     * 修改判断题内容
     */
    @ApiOperation("修改判断题内容")
    @PutMapping(value = "updateJudgment", produces = "application/json;charset=UTF-8")
    public JsonResult updateJudgment(JudgmentQuestions questions) {
        return judgmentQuestionsService.updateJudgment(questions);
    }

    /**
     * 查询所有判断题集合
     */
    @ApiOperation("查询所有判断题集合")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数"),
            @ApiImplicitParam(name = "pageSize", value = "每页个数")
    })
    @GetMapping(value = "queryAllJudgment", produces = "application/json;charset=UTF-8")
    public JsonResult queryAllJudgment(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return judgmentQuestionsService.queryAllJudgment(pageNum, pageSize);
    }
}
