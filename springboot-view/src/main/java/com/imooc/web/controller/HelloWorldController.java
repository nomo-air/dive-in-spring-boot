package com.imooc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello-world"; // View逻辑名称
    }

    @ModelAttribute("message ")
    public String message() {
        return "HelloWorld";
    }

    @RequestMapping("")
    public String index(@RequestParam(defaultValue = "0", required = false) int value, Model model) {
        return "index";
    }
}
