package com.xihua.entity.model;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Author:   lxs
 * Date:     2021/12/21 14:55
 * Description: 考试管理实体类
 */
@ApiModel("考试管理实体类")
@Data
public class ExamManage implements Serializable {
    /**
     * 考试编号
     */
    @ApiModelProperty("考试编号")
    private Integer examId;

    /**
     * 考试介绍
     */
    @ApiModelProperty("考试介绍")
    private String description;

    /**
     * 考试日期
     */
    @ApiModelProperty("考试日期")
    @JSONField(format = "yyyy-MM-dd")
    private Date examDate;

    /**
     * 考试时长
     */
    @ApiModelProperty("考试时长")
    private Integer totalTime;

    /**
     * 总分
     */
    @ApiModelProperty("总分")
    private Integer totalScore;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ExamManage other = (ExamManage) that;
        return (this.getExamId() == null ? other.getExamId() == null : this.getExamId().equals(other.getExamId()))
                && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
                && (this.getExamDate() == null ? other.getExamDate() == null : this.getExamDate().equals(other.getExamDate()))
                && (this.getTotalTime() == null ? other.getTotalTime() == null : this.getTotalTime().equals(other.getTotalTime()))
                && (this.getTotalScore() == null ? other.getTotalScore() == null : this.getTotalScore().equals(other.getTotalScore()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExamId() == null) ? 0 : getExamId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getExamDate() == null) ? 0 : getExamDate().hashCode());
        result = prime * result + ((getTotalTime() == null) ? 0 : getTotalTime().hashCode());
        result = prime * result + ((getTotalScore() == null) ? 0 : getTotalScore().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", examId=").append(examId);
        sb.append(", description=").append(description);
        sb.append(", examDate=").append(examDate);
        sb.append(", totalTime=").append(totalTime);
        sb.append(", totalScore=").append(totalScore);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}