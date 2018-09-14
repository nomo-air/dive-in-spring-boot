package com.imooc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index(
                      //  @RequestHeader("Accept-Language") String acceptLanguage,
                      //  @CookieValue("JSESSIONID") String jsessionId,
                        Model model) {
        // model.addAttribute("acceptLanguage", acceptLanguage);
        // model.addAttribute("jsessionId", jsessionId);
        // model.addAttribute("message", "Hello World");
        return "index";
    }
    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage) {
        return acceptLanguage;
    }

    @ModelAttribute("jsessionId")
    public String jsessionId(@CookieValue("JSESSIONID") String jsessionId) {
        return jsessionId;
    }

    @ModelAttribute("message")
    public String message() {
        return "Hello World";
    }
}
