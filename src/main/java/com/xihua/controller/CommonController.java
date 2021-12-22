package com.xihua.controller;

import com.xihua.entity.dto.ExamPaperDTO;
import com.xihua.service.CommonService;
import com.xihua.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
