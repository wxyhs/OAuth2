package com.userserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Wxy
 * @Description:测试接口
 * @Date created in 11:25 2021/3/22
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/admin/hello")
    public String admin(){
        return "admin";
    }


}
