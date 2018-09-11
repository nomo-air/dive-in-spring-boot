package com.imooc.diveinspringboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link SpringApplication} 引导类
 */

public class SpringApplicationBootStrap {

    public static void main(String[] args) {

        Set<String> sources = new HashSet<>();
        // 配置class名称
        sources.add(ApplicationConfiguration.class.getName());

//        SpringApplication.run(ApplicationConfiguration.class, args);
        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(sources);
//        springApplication.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext context = springApplication.run(args);
        System.out.println("Bean：" + context.getBean(ApplicationConfiguration.class));
    }

    @SpringBootApplication
    public static class ApplicationConfiguration {

    }
}
