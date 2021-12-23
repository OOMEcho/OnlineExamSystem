package com.xihua.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.xihua.dao.FillQuestionsDao;
import com.xihua.entity.model.FillQuestions;
import com.xihua.service.FillQuestionsService;
import com.xihua.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:   lxs
 * Date:     2021/12/6 15:02
 * Description: 填空题业务实现层
 */
@Service
public class FillQuestionsServiceImpl implements FillQuestionsService {

    @Autowired
    private FillQuestionsDao fillQuestionsDao;

    @Transactional
    @Override
    public JsonResult addFill(FillQuestions questions) {
        if (BeanUtil.isEmpty(questions)) {
            return JsonResult.error("添加的数据为空");
        }
        int insert = fillQuestionsDao.insert(questions);
        if (insert == 0) {
            return JsonResult.error("添加失败");
        }
        return JsonResult.success("添加成功");
    }

    @Transactional
    @Override
    public JsonResult deleteFill(Integer id) {
        if (ObjectUtil.isNull(id)) {
            return JsonResult.error("未指定删除数据");
        }
        int delete = fillQuestionsDao.deleteByPrimaryKey(id);
        if (delete == 0) {
            return JsonResult.error("删除失败");
        }
        return JsonResult.success("删除成功");
    }

    @Override
    public JsonResult queryFill(Integer id) {
        if (ObjectUtil.isNull(id)) {
            return JsonResult.error("未指定查询数据");
        }
        FillQuestions fillQuestions = fillQuestionsDao.selectByPrimaryKey(id);
        if (BeanUtil.isEmpty(fillQuestions)) {
            return JsonResult.error("未查询到数据");
        }
        return JsonResult.success("查询成功", fillQuestions);
    }

    @Transactional
    @Override
    public JsonResult updateFill(FillQuestions questions) {
        if (ObjectUtil.isNull(questions.getId())) {
            return JsonResult.error("未指定更新数据");
        }
        int update = fillQuestionsDao.updateByPrimaryKeySelective(questions);
        if (update == 0) {
            return JsonResult.error("修改失败");
        }
        return JsonResult.success("修改成功");
    }

    @Override
    public JsonResult queryAllFill() {
        List<FillQuestions> fillQuestions = fillQuestionsDao.queryAllFill();
        if (ObjectUtil.isEmpty(fillQuestions)) {
            return JsonResult.error("未查询到数据");
        }
        return JsonResult.success("查询成功", fillQuestions);
    }

}
