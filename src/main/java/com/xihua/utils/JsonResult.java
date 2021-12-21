package com.xihua.utils;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Author:   lxs
 * Date:     2021/9/30 12:12
 * Description: 统一返回JSON格式
 */
@ApiModel("Json返回结果实体类")
public class JsonResult implements Serializable {

    private static final long serialVersionUID = 6738387175874422264L;

    /**
     * 状态码
     */
    @ApiModelProperty("状态码")
    private Integer code;

    /**
     * 响应消息
     */
    @ApiModelProperty("响应消息")
    @JSONField(ordinal = 1)
    private String message;

    /**
     * 响应数据
     */
    @ApiModelProperty("响应数据")
    @JSONField(ordinal = 2)
    private Object data;

    public JsonResult() {
    }

    public JsonResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static JsonResult success() {
        return new JsonResult(200, "success", null);
    }

    public static JsonResult success(Object data) {
        return new JsonResult(200, "success", data);
    }

    public static JsonResult success(String message) {
        return new JsonResult(200, message, null);
    }

    public static JsonResult success(String message, Object data) {
        return new JsonResult(200, message, data);
    }

    public static JsonResult error() {
        return new JsonResult(500, "error", null);
    }

    public static JsonResult error(String message) {
        return new JsonResult(500, message, null);
    }

    public static JsonResult error(Object object) {
        return new JsonResult(500, "error", object);
    }

    public static JsonResult error(String message, Object data) {
        return new JsonResult(500, message, data);
    }

    public static JsonResult build(Integer code, String message, Object data) {
        return new JsonResult(code, message, data);
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
