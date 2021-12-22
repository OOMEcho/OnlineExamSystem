package com.xihua.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.xihua.dao.CommonDao;
import com.xihua.dao.ExamManageDao;
import com.xihua.entity.dto.ExamPaperDTO;
import com.xihua.entity.model.ExamManage;
import com.xihua.service.ExamManageService;
import com.xihua.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:   lxs
 * Date:     2021/12/21 19:15
 * Description: 考试管理业务实现层
 */
@Service
public class ExamMangeServiceImpl implements ExamManageService {

    @Autowired
    private ExamManageDao examManageDao;
    @Autowired
    private CommonDao commonDao;

    @Transactional
    @Override
    public JsonResult addExamInfo(ExamManage examManage) {
        examManageDao.insert(examManage);
        return JsonResult.success("添加成功", examManage.getExamId());
    }

    @Override
    public JsonResult queryAllExam() {
        List<ExamManage> examManages = examManageDao.queryAllExam();
        if (ObjectUtil.isEmpty(examManages)) {
            return JsonResult.error("未查询到数据");
        }
        return JsonResult.success("查询成功", examManages);
    }

    @Transactional
    @Override
    public JsonResult updateExam(ExamManage examManage) {
        if (ObjectUtil.isEmpty(examManage.getExamId())) {
            return JsonResult.error("未指定更新数据");
        }
        int update = examManageDao.updateByPrimaryKeySelective(examManage);
        if (update == 0) {
            return JsonResult.error("修改失败");
        }
        return JsonResult.success("修改成功");
    }

    @Transactional
    @Override
    public JsonResult deleteExam(Integer examId) {
        if (ObjectUtil.isEmpty(examId)) {
            return JsonResult.error("未指定删除数据");
        }
        int delete = examManageDao.deleteByPrimaryKey(examId);
        if (delete != 0) {
            List<ExamPaperDTO> examPaper = commonDao.findExamPaper(examId);
            if (ObjectUtil.isNotEmpty(examPaper)) {
                int i = commonDao.deleteExamPaper(examId);
            }
            return JsonResult.success("删除成功");
        }
        return JsonResult.error("删除失败");
    }
}
