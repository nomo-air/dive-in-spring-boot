package com.imooc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@Controller
public class PropertiesRestController {

    @PostMapping(value = "/add/props",
            consumes = "text/properties;charset=UTF-8") // Content-Type 过滤媒体类型
    public Properties addSuccess(
            // @RequestBody
            Properties properties) {
        return properties;
    }
}
