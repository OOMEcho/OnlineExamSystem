package com.xihua.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xihua.dao.JudgmentQuestionsDao;
import com.xihua.entity.model.JudgmentQuestions;
import com.xihua.service.JudgmentQuestionsService;
import com.xihua.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:   lxs
 * Date:     2021/12/6 15:03
 * Description: 判断题业务实现层
 */
@Service
public class JudgmentQuestionsServiceImpl implements JudgmentQuestionsService {

    @Autowired
    private JudgmentQuestionsDao judgmentQuestionsDao;

    @Transactional
    @Override
    public JsonResult addJudgment(JudgmentQuestions questions) {
        if (BeanUtil.isEmpty(questions)) {
            return JsonResult.error("新增的数据为空");
        }
        int insert = judgmentQuestionsDao.insert(questions);
        if (insert == 0) {
            return JsonResult.error("添加失败");
        }
        return JsonResult.success("添加成功");
    }

    @Transactional
    @Override
    public JsonResult deleteJudgment(Integer id) {
        if (ObjectUtil.isNull(id)) {
            return JsonResult.error("未指定删除数据");
        }
        int delete = judgmentQuestionsDao.deleteByPrimaryKey(id);
        if (delete == 0) {
            return JsonResult.error("删除失败");
        }
        return JsonResult.success("删除成功");
    }

    @Override
    public JsonResult queryJudgment(Integer id) {
        if (ObjectUtil.isNull(id)) {
            return JsonResult.error("未指定查询数据");
        }
        JudgmentQuestions judgmentQuestions = judgmentQuestionsDao.selectByPrimaryKey(id);
        if (BeanUtil.isEmpty(judgmentQuestions)) {
            return JsonResult.error("未查询到数据");
        }
        return JsonResult.success("查询成功", judgmentQuestions);
    }

    @Transactional
    @Override
    public JsonResult updateJudgment(JudgmentQuestions questions) {
        if (ObjectUtil.isNull(questions.getId())) {
            return JsonResult.error("未指定更新数据");
        }
        int update = judgmentQuestionsDao.updateByPrimaryKeySelective(questions);
        if (update == 0) {
            return JsonResult.error("修改失败");
        }
        return JsonResult.success("修改成功");
    }

    @Override
    public JsonResult queryAllJudgment(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<JudgmentQuestions> judgmentQuestions = judgmentQuestionsDao.queryAllJudgment();
        if (ObjectUtil.isEmpty(judgmentQuestions)) {
            return JsonResult.error("未查询到数据");
        }
        PageInfo<JudgmentQuestions> judgmentQuestionsPageInfo = new PageInfo<>(judgmentQuestions);
        return JsonResult.success("查询成功", judgmentQuestionsPageInfo);
    }

}
