package com.imooc.diveinspringboot.bootstrap;

import com.imooc.diveinspringboot.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 仓储的引导类
 */
@ComponentScan(basePackages = "com.imooc.diveinspringboot.repository")
public class RepositoryBootStrap {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootStrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // myFirstLeveRepository Bean 是否存在
        MyFirstLevelRepository myFirstLeveRepository =
                context.getBean("myFirstLevelRepository", MyFirstLevelRepository.class);

        System.out.println("myFirstLevelRepository Bean：" + myFirstLeveRepository);

        context.close();
    }
}
