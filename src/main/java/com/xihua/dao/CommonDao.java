package com.xihua.dao;

import com.xihua.entity.dto.ExamPaperDTO;
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
}
