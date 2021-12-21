package com.xihua.controller;

import com.xihua.entity.model.FillQuestions;
import com.xihua.service.FillQuestionsService;
import com.xihua.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author:   lxs
 * Date:     2021/12/6 15:09
 * Description: 填空题控制层
 */
@Api("填空题控制层")
@RestController
public class FillQuestionsController {

    @Autowired
    private FillQuestionsService fillQuestionsService;

    /**
     * 新增填空题
     */
    @ApiOperation("新增填空题")
    @PostMapping(value = "addFill", produces = "application/json;charset=UTF-8")
    public JsonResult addFill(FillQuestions questions) {
        return fillQuestionsService.addFill(questions);
    }

    /**
     * 根据主键id删除填空题
     */
    @ApiOperation("根据主键id删除填空题")
    @ApiImplicitParam(name = "id", value = "主键Id", required = true)
    @DeleteMapping(value = "deleteFill/{id}", produces = "application/json;charset=UTF-8")
    public JsonResult deleteFill(@PathVariable Integer id) {
        return fillQuestionsService.deleteFill(id);
    }

    /**
     * 根据主键id查询填空题
     */
    @ApiOperation("根据主键id查询填空题")
    @ApiImplicitParam(name = "id", value = "主键Id", required = true)
    @GetMapping(value = "queryFill/{id}", produces = "application/json;charset=UTF-8")
    public JsonResult queryFill(@PathVariable Integer id) {
        return fillQuestionsService.queryFill(id);
    }

    /**
     * 修改填空题内容
     */
    @ApiOperation("修改填空题内容")
    @PutMapping(value = "updateFill", produces = "application/json;charset=UTF-8")
    public JsonResult updateFill(FillQuestions questions) {
        return fillQuestionsService.updateFill(questions);
    }

    /**
     * 查询所有填空题集合
     */
    @ApiOperation("查询所有填空题集合")
    @GetMapping(value = "queryAllFill", produces = "application/json;charset=UTF-8")
    public JsonResult queryAllFill() {
        return fillQuestionsService.queryAllFill();
    }
}
