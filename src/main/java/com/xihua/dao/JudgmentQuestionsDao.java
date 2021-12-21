package com.xihua.dao;

import com.xihua.entity.model.JudgmentQuestions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author:   lxs
 * Date:     2021/12/6 14:55
 * Description: 判断题数据持久层
 */
@Repository
public interface JudgmentQuestionsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(JudgmentQuestions record);

    int insertSelective(JudgmentQuestions record);

    JudgmentQuestions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JudgmentQuestions record);

    int updateByPrimaryKey(JudgmentQuestions record);

    List<JudgmentQuestions> queryAllJudgment();
}