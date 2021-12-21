package com.xihua.config.exception;

import com.xihua.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

/**
 * Author:   lxs
 * Date:     2021/7/14 11:31
 * Description: 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public JsonResult runtimeExceptionHandler(RuntimeException e) {
        log.error("运行时异常：" + e.getMessage());
        return JsonResult.error("服务器被搬走了！！！");
    }

    @ExceptionHandler(NullPointerException.class)
    public JsonResult nullPointerExceptionHandler(NullPointerException e) {
        log.error("空指针异常：" + e.getMessage());
        return JsonResult.error("服务器被搬走了！！！");
    }

    @ExceptionHandler(ClassCastException.class)
    public JsonResult classCastExceptionHandler(ClassCastException e) {
        log.error("类型转换异常：" + e.getMessage());
        return JsonResult.error("服务器被搬走了！！！");
    }

    @ExceptionHandler(IOException.class)
    public JsonResult ioExceptionHandler(IOException e) {
        log.error("IO异常：" + e.getMessage());
        return JsonResult.error("服务器被搬走了！！！");
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public JsonResult indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException e) {
        log.error("数组越界异常：" + e.getMessage());
        return JsonResult.error("服务器被搬走了！！！");
    }

    @ExceptionHandler(Exception.class)
    public JsonResult exception(Exception e) {
        log.error("异常：" + e.getMessage());
        return JsonResult.error("服务器被搬走了！！！");
    }

}
