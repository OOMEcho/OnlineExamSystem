package com.xihua.controller;

import com.xihua.utils.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Author:   lxs
 * Date:     2021/9/30 12:16
 * Description: 项目测试
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public JsonResult hello() {
        int i = 1 / 0;
        return JsonResult.success(Arrays.asList("Hello,World", "Java"));
    }

    @GetMapping("/getUser")
    public JsonResult getUser() {
        return JsonResult.success("test");
    }

    @GetMapping("/test")
    public JsonResult test(){
        return JsonResult.success("test");
    }
}
