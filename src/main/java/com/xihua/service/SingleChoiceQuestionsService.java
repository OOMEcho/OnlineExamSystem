package com.xihua.service;

import com.xihua.entity.model.SingleChoiceQuestions;
import com.xihua.utils.JsonResult;

/**
 * Author:   lxs
 * Date:     2021/12/6 14:55
 * Description: 单选题业务层
 */
public interface SingleChoiceQuestionsService {

    /**
     * 添加单选题
     *
     * @param questions 增加数据
     */
    JsonResult addSingleChoice(SingleChoiceQuestions questions);

    /**
     * 删除单选题
     *
     * @param id 主键id
     */
    JsonResult deleteSingleChoice(Integer id);

    /**
     * 查询单选题
     *
     * @param id 主键id
     */
    JsonResult querySingleChoice(Integer id);

    /**
     * 修改单选题
     *
     * @param questions 修改数据
     */
    JsonResult updateSingleChoice(SingleChoiceQuestions questions);

    /**
     * 查询所有单选题集合
     *
     * @param pageNum  页数
     * @param pageSize 每页数据个数
     */
    JsonResult queryAllSingleChoice(Integer pageNum, Integer pageSize);
}
