package com.xihua.dao;

import com.xihua.entity.dto.ExamInfoDTO;
import com.xihua.entity.dto.ExamPaperDTO;
import com.xihua.entity.dto.ExamUserDTO;
import com.xihua.entity.model.FillQuestions;
import com.xihua.entity.model.JudgmentQuestions;
import com.xihua.entity.model.MultipleChoiceQuestions;
import com.xihua.entity.model.SingleChoiceQuestions;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author:   lxs
 * Date:     2021/12/22 8:47
 * Description: 公共数据持久层
 */
@Repository
public interface CommonDao {

    int addExamPaper(@Param("list") List<ExamPaperDTO> examPaperDTOS);

    int deleteExamPaper(Integer examId);

    List<ExamPaperDTO> findExamPaper(Integer examId);

    List<ExamInfoDTO> findUserExam(Integer userId);

    List<SingleChoiceQuestions> findExamBySingle(Integer examId);

    List<MultipleChoiceQuestions> findExamByMultiple(Integer examId);

    List<JudgmentQuestions> findExamByJudge(Integer examId);

    List<FillQuestions> findExamByFill(Integer examId);

    int addUserExamRecord(ExamUserDTO examUserDTO);
}
