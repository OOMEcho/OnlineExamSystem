package com.xihua.service;

import com.xihua.entity.dto.ExamPaperDTO;
import com.xihua.entity.dto.ExamUserDTO;
import com.xihua.utils.JsonResult;

import java.util.List;

/**
 * Author:   lxs
 * Date:     2021/12/22 10:54
 * Description: 公共业务层
 */
public interface CommonService {

    JsonResult addExamPaper(List<ExamPaperDTO> examPaperDTO);

    JsonResult findUserExamInfo(Integer userId);

    JsonResult queryExamPaperInfo(Integer examId);

    JsonResult addUserExamRecord(ExamUserDTO examUserDTO);
}
