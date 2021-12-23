package com.xihua.controller;

import com.xihua.entity.model.MultipleChoiceQuestions;
import com.xihua.service.MultipleChoiceQuestionsService;
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
 * Description: 多选题控制层
 */
@Api("多选题控制层")
@RestController
public class MultipleChoiceQuestionsController {

    @Autowired
    private MultipleChoiceQuestionsService multipleChoiceQuestionsService;

    /**
     * 新增多选题
     */
    @ApiOperation("新增多选题")
    @PostMapping(value = "addMultiple", produces = "application/json;charset=UTF-8")
    public JsonResult addMultiple(MultipleChoiceQuestions questions) {
        return multipleChoiceQuestionsService.addMultipleChoice(questions);
    }

    /**
     * 根据主键id删除多选题
     */
    @ApiOperation("根据主键id删除多选题")
    @ApiImplicitParam(name = "id", value = "主键Id", required = true)
    @DeleteMapping(value = "deleteMultiple/{id}", produces = "application/json;charset=UTF-8")
    public JsonResult deleteMultiple(@PathVariable Integer id) {
        return multipleChoiceQuestionsService.deleteMultipleChoice(id);
    }

    /**
     * 根据主键id查询多选题
     */
    @ApiOperation("根据主键id查询多选题")
    @ApiImplicitParam(name = "id", value = "主键Id", required = true)
    @GetMapping(value = "queryMultiple/{id}", produces = "application/json;charset=UTF-8")
    public JsonResult queryMultiple(@PathVariable Integer id) {
        return multipleChoiceQuestionsService.queryMultipleChoice(id);
    }

    /**
     * 修改多选题内容
     */
    @ApiOperation("修改多选题内容")
    @PutMapping(value = "updateMultiple", produces = "application/json;charset=UTF-8")
    public JsonResult updateMultiple(MultipleChoiceQuestions questions) {
        return multipleChoiceQuestionsService.updateMultipleChoice(questions);
    }

    /**
     * 查询所有多选题集合
     */
    @ApiOperation("查询所有多选题集合")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数"),
            @ApiImplicitParam(name = "pageSize", value = "每页个数")
    })
    @GetMapping(value = "queryAllMultiple", produces = "application/json;charset=UTF-8")
    public JsonResult queryAllMultiple(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return multipleChoiceQuestionsService.queryAllMultipleChoice(pageNum, pageSize);
    }
}
