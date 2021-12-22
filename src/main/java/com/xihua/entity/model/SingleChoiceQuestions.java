package com.xihua.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Author:   lxs
 * Date:     2021/12/6 14:55
 * Description: 单选题实体类
 */
@ApiModel("单选题实体类")
@Data
public class SingleChoiceQuestions implements Serializable {
    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Integer id;

    /**
     * 试题内容
     */
    @ApiModelProperty("试题内容")
    private String question;

    /**
     * 试题类型
     */
    @ApiModelProperty("试题类型")
    private Integer questionType;

    /**
     * 选项A
     */
    @ApiModelProperty("选项A")
    private String answerA;

    /**
     * 选项B
     */
    @ApiModelProperty("选项B")
    private String answerB;

    /**
     * 选项C
     */
    @ApiModelProperty("选项C")
    private String answerC;

    /**
     * 选项D
     */
    @ApiModelProperty("选项D")
    private String answerD;

    /**
     * 正确答案
     */
    @ApiModelProperty("正确答案")
    private String rightAnswer;

    /**
     * 分值
     */
    @ApiModelProperty("分值")
    private Integer score;

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
        SingleChoiceQuestions other = (SingleChoiceQuestions) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getQuestion() == null ? other.getQuestion() == null : this.getQuestion().equals(other.getQuestion()))
                && (this.getQuestionType() == null ? other.getQuestionType() == null : this.getQuestionType().equals(other.getQuestionType()))
                && (this.getAnswerA() == null ? other.getAnswerA() == null : this.getAnswerA().equals(other.getAnswerA()))
                && (this.getAnswerB() == null ? other.getAnswerB() == null : this.getAnswerB().equals(other.getAnswerB()))
                && (this.getAnswerC() == null ? other.getAnswerC() == null : this.getAnswerC().equals(other.getAnswerC()))
                && (this.getAnswerD() == null ? other.getAnswerD() == null : this.getAnswerD().equals(other.getAnswerD()))
                && (this.getRightAnswer() == null ? other.getRightAnswer() == null : this.getRightAnswer().equals(other.getRightAnswer()))
                && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getQuestion() == null) ? 0 : getQuestion().hashCode());
        result = prime * result + ((getQuestionType() == null) ? 0 : getQuestionType().hashCode());
        result = prime * result + ((getAnswerA() == null) ? 0 : getAnswerA().hashCode());
        result = prime * result + ((getAnswerB() == null) ? 0 : getAnswerB().hashCode());
        result = prime * result + ((getAnswerC() == null) ? 0 : getAnswerC().hashCode());
        result = prime * result + ((getAnswerD() == null) ? 0 : getAnswerD().hashCode());
        result = prime * result + ((getRightAnswer() == null) ? 0 : getRightAnswer().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", question=").append(question);
        sb.append(", questionType=").append(questionType);
        sb.append(", answerA=").append(answerA);
        sb.append(", answerB=").append(answerB);
        sb.append(", answerC=").append(answerC);
        sb.append(", answerD=").append(answerD);
        sb.append(", rightAnswer=").append(rightAnswer);
        sb.append(", score=").append(score);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}