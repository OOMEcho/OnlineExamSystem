package com.xihua.service;

import com.xihua.entity.model.JudgmentQuestions;
import com.xihua.utils.JsonResult;

/**
 * Author:   lxs
 * Date:     2021/12/6 15:01
 * Description: 判断题业务层
 */
public interface JudgmentQuestionsService {

    /**
     * 添加判断题
     *
     * @param questions 增加数据
     */
    JsonResult addJudgment(JudgmentQuestions questions);

    /**
     * 删除判断题
     *
     * @param id 主键id
     */
    JsonResult deleteJudgment(Integer id);

    /**
     * 查询判断题
     *
     * @param id 主键id
     */
    JsonResult queryJudgment(Integer id);

    /**
     * 修改判断题
     *
     * @param questions 修改数据
     */
    JsonResult updateJudgment(JudgmentQuestions questions);

    /**
     * 查询所有判断题集合
     */
    JsonResult queryAllJudgment();
}
