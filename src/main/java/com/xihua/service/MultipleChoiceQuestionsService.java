package com.xihua.service;

import com.xihua.entity.model.MultipleChoiceQuestions;
import com.xihua.utils.JsonResult;

/**
 * Author:   lxs
 * Date:     2021/12/6 15:01
 * Description: 多选题业务层
 */
public interface MultipleChoiceQuestionsService {

    /**
     * 添加多选题
     *
     * @param questions 增加数据
     */
    JsonResult addMultipleChoice(MultipleChoiceQuestions questions);

    /**
     * 删除多选题
     *
     * @param id 主键id
     */
    JsonResult deleteMultipleChoice(Integer id);

    /**
     * 查询多选题
     *
     * @param id 主键id
     */
    JsonResult queryMultipleChoice(Integer id);

    /**
     * 修改多选题
     *
     * @param questions 修改数据
     */
    JsonResult updateMultipleChoice(MultipleChoiceQuestions questions);

    /**
     * 查询所有多选题集合
     */
    JsonResult queryAllMultipleChoice();
}
