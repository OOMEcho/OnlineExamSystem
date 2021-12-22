package com.xihua.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.xihua.dao.CommonDao;
import com.xihua.entity.dto.ExamInfoDTO;
import com.xihua.entity.dto.ExamPaperDTO;
import com.xihua.entity.model.FillQuestions;
import com.xihua.entity.model.JudgmentQuestions;
import com.xihua.entity.model.MultipleChoiceQuestions;
import com.xihua.entity.model.SingleChoiceQuestions;
import com.xihua.service.CommonService;
import com.xihua.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:   lxs
 * Date:     2021/12/22 10:56
 * Description: 公共业务实现层
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonDao commonDao;

    @Transactional
    @Override
    public JsonResult addExamPaper(List<ExamPaperDTO> examPaperDTO) {
        int insert = commonDao.addExamPaper(examPaperDTO);
        if (insert == 0) {
            return JsonResult.error("添加失败");
        }
        return JsonResult.success("添加成功");
    }

    @Override
    public JsonResult findUserExamInfo(Integer userId) {
        if (ObjectUtil.isNull(userId)) {
            return JsonResult.error("未指定查询用户");
        }
        List<ExamInfoDTO> userExam = commonDao.findUserExam(userId);
        if (ObjectUtil.isEmpty(userExam)) {
            return JsonResult.error("未查询到数据");
        }
        return JsonResult.success("查询成功", userExam);
    }

    @Override
    public JsonResult queryExamPaperInfo(Integer examId) {
        Map<String, Object> map = new HashMap<>();
        List<SingleChoiceQuestions> examBySingle = commonDao.findExamBySingle(examId);
        if (ObjectUtil.isNotEmpty(examBySingle)) {
            map.put("single", examBySingle);
        }
        List<JudgmentQuestions> examByJudge = commonDao.findExamByJudge(examId);
        if (ObjectUtil.isNotEmpty(examByJudge)) {
            map.put("judge", examByJudge);
        }
        List<MultipleChoiceQuestions> examByMultiple = commonDao.findExamByMultiple(examId);
        if (ObjectUtil.isNotEmpty(examByMultiple)) {
            map.put("multiple", examByMultiple);
        }
        List<FillQuestions> examByFill = commonDao.findExamByFill(examId);
        if (ObjectUtil.isNotEmpty(examByFill)) {
            map.put("fill", examByFill);
        }
        return JsonResult.success("查询成功", map);
    }
}
