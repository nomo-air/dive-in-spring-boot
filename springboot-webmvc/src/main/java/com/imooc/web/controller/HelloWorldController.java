package com.imooc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index(
            //  @RequestHeader("Accept-Language") String acceptLanguage,
            //  @CookieValue("JSESSIONID") String jsessionId,
            @RequestParam int value, Model model) {
        // model.addAttribute("acceptLanguage", acceptLanguage);
        // model.addAttribute("jsessionId", jsessionId);
        // model.addAttribute("message", "Hello World");
        return "index";
    }
}
