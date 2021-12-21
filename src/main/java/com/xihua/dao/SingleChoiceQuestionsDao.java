package com.xihua.dao;

import com.xihua.entity.model.SingleChoiceQuestions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author:   lxs
 * Date:     2021/12/6 14:55
 * Description: 单选题数据持久层
 */
@Repository
public interface SingleChoiceQuestionsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SingleChoiceQuestions record);

    int insertSelective(SingleChoiceQuestions record);

    SingleChoiceQuestions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SingleChoiceQuestions record);

    int updateByPrimaryKey(SingleChoiceQuestions record);

    List<SingleChoiceQuestions> queryAllSingleChoice();
}