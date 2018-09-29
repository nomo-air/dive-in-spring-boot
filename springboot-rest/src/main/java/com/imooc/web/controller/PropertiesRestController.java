package com.imooc.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
public class PropertiesRestController {

    @PostMapping(value = "/add/props",
            consumes = "text/properties;charset=UTF-8") // Content-Type 过滤媒体类型
    public String addSuccess(@RequestBody Properties properties) {
        return "Success";
    }
}
