package com.wxm.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AOPController {

    @RequestMapping("/aspect/{id}")
    public String text(@PathVariable(value = "id") String id) {
        System.out.println("aop测试:" + id);
        return "hello word!";
    }
}
