package com.xihua.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.xihua.dao.SingleChoiceQuestionsDao;
import com.xihua.entity.model.SingleChoiceQuestions;
import com.xihua.service.SingleChoiceQuestionsService;
import com.xihua.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:   lxs
 * Date:     2021/12/6 15:00
 * Description: 单选题业务实现层
 */
@Service
public class SingleChoiceQuestionsServiceImpl implements SingleChoiceQuestionsService {

    @Autowired
    private SingleChoiceQuestionsDao singleChoiceQuestionsDao;

    @Transactional
    @Override
    public JsonResult addSingleChoice(SingleChoiceQuestions questions) {
        int insert = singleChoiceQuestionsDao.insert(questions);
        if (insert == 0) {
            return JsonResult.error("添加失败");
        }
        return JsonResult.success("添加成功");
    }

    @Transactional
    @Override
    public JsonResult deleteSingleChoice(Integer id) {
        if (ObjectUtil.isEmpty(id)) {
            return JsonResult.error("未指定删除数据");
        }
        int delete = singleChoiceQuestionsDao.deleteByPrimaryKey(id);
        if (delete == 0) {
            return JsonResult.error("删除失败");
        }
        return JsonResult.success("删除成功");
    }

    @Override
    public JsonResult querySingleChoice(Integer id) {
        if (ObjectUtil.isEmpty(id)) {
            return JsonResult.error("未指定查询数据");
        }
        SingleChoiceQuestions singleChoiceQuestions = singleChoiceQuestionsDao.selectByPrimaryKey(id);
        if (ObjectUtil.isEmpty(singleChoiceQuestions)) {
            return JsonResult.error("未查询到数据");
        }
        return JsonResult.success("查询成功", singleChoiceQuestions);
    }

    @Transactional
    @Override
    public JsonResult updateSingleChoice(SingleChoiceQuestions questions) {
        if (ObjectUtil.isEmpty(questions.getId())) {
            return JsonResult.error("未指定更新数据");
        }
        int update = singleChoiceQuestionsDao.updateByPrimaryKeySelective(questions);
        if (update == 0) {
            return JsonResult.error("修改失败");
        }
        return JsonResult.success("修改成功");
    }

    @Override
    public JsonResult queryAllSingleChoice() {
        List<SingleChoiceQuestions> singleChoiceQuestions = singleChoiceQuestionsDao.queryAllSingleChoice();
        if (ObjectUtil.isEmpty(singleChoiceQuestions)) {
            return JsonResult.error("未查询到数据");
        }
        return JsonResult.success("查询成功", singleChoiceQuestions);
    }
}
