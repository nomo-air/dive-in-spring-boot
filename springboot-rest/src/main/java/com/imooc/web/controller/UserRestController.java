package com.imooc.web.controller;

import com.imooc.web.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @PostMapping(value = "/echo/user",
            consumes = "application/*;charset=UTF-8", // 输入
            produces = "application/json;charset=GBK") // 输出
    public User user(@RequestBody User user) {
        return user;
    }
}
