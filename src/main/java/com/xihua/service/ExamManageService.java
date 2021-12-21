package com.xihua.service;

import com.xihua.entity.model.ExamManage;
import com.xihua.utils.JsonResult;

/**
 * Author:   lxs
 * Date:     2021/12/21 19:08
 * Description: 考试管理业务层
 */
public interface ExamManageService {

    /**
     * 新增考试
     *
     * @param examManage 考试数据
     */
    JsonResult addExamInfo(ExamManage examManage);

    /**
     * 查询考试列表
     */
    JsonResult queryAllExam();

    /**
     * 修改考试内容
     *
     * @param examManage 修改数据
     */
    JsonResult updateExam(ExamManage examManage);

    /**
     * 根据考试编号删除考试
     *
     * @param examId 考试编号
     */
    JsonResult deleteExam(Integer examId);
}
