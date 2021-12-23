package com.xihua.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xihua.dao.MultipleChoiceQuestionsDao;
import com.xihua.entity.model.MultipleChoiceQuestions;
import com.xihua.service.MultipleChoiceQuestionsService;
import com.xihua.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:   lxs
 * Date:     2021/12/6 15:03
 * Description: 多选题业务实现层
 */
@Service
public class MultipleChoiceQuestionsServiceImpl implements MultipleChoiceQuestionsService {

    @Autowired
    private MultipleChoiceQuestionsDao multipleChoiceQuestionsDao;

    @Transactional
    @Override
    public JsonResult addMultipleChoice(MultipleChoiceQuestions questions) {
        if (BeanUtil.isEmpty(questions)) {
            return JsonResult.error("新增的数据为空");
        }
        int insert = multipleChoiceQuestionsDao.insert(questions);
        if (insert == 0) {
            return JsonResult.error("添加失败");
        }
        return JsonResult.success("添加成功");
    }

    @Transactional
    @Override
    public JsonResult deleteMultipleChoice(Integer id) {
        if (ObjectUtil.isNull(id)) {
            return JsonResult.error("未指定删除数据");
        }
        int delete = multipleChoiceQuestionsDao.deleteByPrimaryKey(id);
        if (delete == 0) {
            return JsonResult.error("删除失败");
        }
        return JsonResult.success("删除成功");
    }

    @Override
    public JsonResult queryMultipleChoice(Integer id) {
        if (ObjectUtil.isNull(id)) {
            return JsonResult.error("未指定查询数据");
        }
        MultipleChoiceQuestions multipleChoiceQuestions = multipleChoiceQuestionsDao.selectByPrimaryKey(id);
        if (BeanUtil.isEmpty(multipleChoiceQuestions)) {
            return JsonResult.error("未查询到数据");
        }
        return JsonResult.success("查询成功", multipleChoiceQuestions);
    }

    @Transactional
    @Override
    public JsonResult updateMultipleChoice(MultipleChoiceQuestions questions) {
        if (ObjectUtil.isNull(questions.getId())) {
            return JsonResult.error("未指定更新数据");
        }
        int update = multipleChoiceQuestionsDao.updateByPrimaryKeySelective(questions);
        if (update == 0) {
            return JsonResult.error("修改失败");
        }
        return JsonResult.success("修改成功");
    }

    @Override
    public JsonResult queryAllMultipleChoice(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<MultipleChoiceQuestions> multipleChoiceQuestions = multipleChoiceQuestionsDao.queryAllMultipleChoice();
        if (ObjectUtil.isEmpty(multipleChoiceQuestions)) {
            return JsonResult.error("未查询到数据");
        }
        PageInfo<MultipleChoiceQuestions> multipleChoiceQuestionsPageInfo = new PageInfo<>(multipleChoiceQuestions);
        return JsonResult.success("查询成功", multipleChoiceQuestionsPageInfo);
    }

}
