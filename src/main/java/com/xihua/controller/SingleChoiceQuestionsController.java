package com.xihua.controller;

import com.xihua.entity.model.SingleChoiceQuestions;
import com.xihua.service.SingleChoiceQuestionsService;
import com.xihua.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author:   lxs
 * Date:     2021/12/6 15:05
 * Description: 单选题控制层
 */
@Api("单选题控制层")
@RestController
public class SingleChoiceQuestionsController {

    @Autowired
    private SingleChoiceQuestionsService singleChoiceQuestionsService;

    /**
     * 新增单选题
     */
    @ApiOperation("新增单选题")
    @PostMapping(value = "addSingle", produces = "application/json;charset=UTF-8")
    public JsonResult addSingle(SingleChoiceQuestions questions) {
        return singleChoiceQuestionsService.addSingleChoice(questions);
    }

    /**
     * 根据主键id删除单选题
     */
    @ApiOperation("根据主键id删除单选题")
    @ApiImplicitParam(name = "id", value = "主键Id", required = true)
    @DeleteMapping(value = "deleteSingle/{id}", produces = "application/json;charset=UTF-8")
    public JsonResult deleteSingle(@PathVariable Integer id) {
        return singleChoiceQuestionsService.deleteSingleChoice(id);
    }

    /**
     * 根据主键id查询单选题
     */
    @ApiOperation("根据主键id查询单选题")
    @ApiImplicitParam(name = "id", value = "主键Id", required = true)
    @GetMapping(value = "querySingle/{id}", produces = "application/json;charset=UTF-8")
    public JsonResult querySingle(@PathVariable Integer id) {
        return singleChoiceQuestionsService.querySingleChoice(id);
    }

    /**
     * 修改单选题内容
     */
    @ApiOperation("修改单选题内容")
    @PutMapping(value = "updateSingle", produces = "application/json;charset=UTF-8")
    public JsonResult updateSingle(SingleChoiceQuestions questions) {
        return singleChoiceQuestionsService.updateSingleChoice(questions);
    }

    /**
     * 查询所有单选题集合
     */
    @ApiOperation("查询所有单选题集合")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数"),
            @ApiImplicitParam(name = "pageSize", value = "每页个数")
    })
    @GetMapping(value = "queryAllSingle")
    public JsonResult queryAllSingle(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return singleChoiceQuestionsService.queryAllSingleChoice(pageNum, pageSize);
    }
}
