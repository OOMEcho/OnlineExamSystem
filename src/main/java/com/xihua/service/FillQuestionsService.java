package com.xihua.service;

import com.xihua.entity.model.FillQuestions;
import com.xihua.utils.JsonResult;

/**
 * Author:   lxs
 * Date:     2021/12/6 15:02
 * Description: 填空题业务层
 */
public interface FillQuestionsService {

    /**
     * 添加填空题
     *
     * @param questions 增加数据
     */
    JsonResult addFill(FillQuestions questions);

    /**
     * 删除填空题
     *
     * @param id 主键id
     */
    JsonResult deleteFill(Integer id);

    /**
     * 查询填空题
     *
     * @param id 主键id
     */
    JsonResult queryFill(Integer id);

    /**
     * 修改填空题
     *
     * @param questions 修改数据
     */
    JsonResult updateFill(FillQuestions questions);

    /**
     * 查询所有填空题集合
     *
     * @param pageNum  页数
     * @param pageSize 每页数据个数
     */
    JsonResult queryAllFill(Integer pageNum, Integer pageSize);
}
