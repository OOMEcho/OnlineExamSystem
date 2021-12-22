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
 * Date:     2021/12/22 19:51
 * Description: 考试记录
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("考试记录")
public class ExamInfoDTO {

    /**
     * 考试介绍
     */
    @ApiModelProperty("考试介绍")
    private String description;

    /**
     * 分数
     */
    @ApiModelProperty("分数")
    private Integer score;

    /**
     * 考试时间
     */
    @ApiModelProperty("考试时间")
    @JSONField(format = "yyyy-MM-dd")
    private Date examDate;
}
