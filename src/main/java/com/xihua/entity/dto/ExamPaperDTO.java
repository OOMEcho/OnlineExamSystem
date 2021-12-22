package com.xihua.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:   lxs
 * Date:     2021/12/22 9:21
 * Description: 考试试卷
 */
@ApiModel("考试试卷")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamPaperDTO {

    /**
     * 试卷编号
     */
    @ApiModelProperty("试卷编号")
    private Integer examId;

    /**
     * 题目编号
     */
    @ApiModelProperty("题目编号")
    private Integer questionId;

    /**
     * 题目类型
     */
    @ApiModelProperty("题目类型")
    private Integer questionType;
}
