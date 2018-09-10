package com.imooc.diveinspringboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * {@link SpringApplication} 引导类
 */

public class SpringApplicationBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfiguration.class, args);
    }

    @SpringBootApplication
    public static class ApplicationConfiguration {

    }
}
