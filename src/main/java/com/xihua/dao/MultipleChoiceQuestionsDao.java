package com.xihua.dao;

import com.xihua.entity.model.MultipleChoiceQuestions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author:   lxs
 * Date:     2021/12/6 14:55
 * Description: 多选题数据持久层
 */
@Repository
public interface MultipleChoiceQuestionsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MultipleChoiceQuestions record);

    int insertSelective(MultipleChoiceQuestions record);

    MultipleChoiceQuestions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MultipleChoiceQuestions record);

    int updateByPrimaryKey(MultipleChoiceQuestions record);

    List<MultipleChoiceQuestions> queryAllMultipleChoice();
}