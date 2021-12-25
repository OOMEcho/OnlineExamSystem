package com.xihua.dao;

import com.xihua.entity.model.ExamManage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamManageDao {
    int deleteByPrimaryKey(Integer examId);

    int insert(ExamManage record);

    int insertSelective(ExamManage record);

    ExamManage selectByPrimaryKey(Integer examId);

    int updateByPrimaryKeySelective(ExamManage record);

    int updateByPrimaryKey(ExamManage record);

    List<ExamManage> queryAllExam();

    ExamManage findExamById(Integer examId);
}