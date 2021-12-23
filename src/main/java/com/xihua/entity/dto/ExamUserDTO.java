package com.xihua.entity.dto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Author:   lxs
 * Date:     2021/12/23 8:57
 * Description: 考试记录
 */
@ApiModel("考试记录")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamUserDTO {

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;

    /**
     * 考试编号
     */
    @ApiModelProperty("考试编号")
    private Integer examId;

    /**
     * 考试成绩
     */
    @ApiModelProperty("考试成绩")
    private Integer score;

    /**
     * 考试时间
     */
    @ApiModelProperty("考试时间")
    @JSONField(format = "yyyy-MM-dd")
    private Date examDate;
}
