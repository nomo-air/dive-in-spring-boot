package com.imooc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello-world"; // View逻辑名称
    }

    @ModelAttribute
    public String message() {
        return "HelloWorld";
    }
}
