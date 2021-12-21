package com.xihua.dao;

import com.xihua.entity.model.FillQuestions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author:   lxs
 * Date:     2021/12/6 14:55
 * Description: 填空题数据持久层
 */
@Repository
public interface FillQuestionsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(FillQuestions record);

    int insertSelective(FillQuestions record);

    FillQuestions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FillQuestions record);

    int updateByPrimaryKey(FillQuestions record);

    List<FillQuestions> queryAllFill();
}