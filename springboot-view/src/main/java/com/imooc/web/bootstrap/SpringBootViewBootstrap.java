package com.imooc.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.imooc.web")
public class SpringBootViewBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootViewBootstrap.class);
    }
}
