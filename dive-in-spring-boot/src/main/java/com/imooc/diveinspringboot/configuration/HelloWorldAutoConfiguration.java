package com.imooc.diveinspringboot.configuration;

import com.imooc.diveinspringboot.annotation.EnableHelloWorld;
import com.imooc.diveinspringboot.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * HelloWorld 自动转配
 */
@Configuration // spring 模式注解
@EnableHelloWorld // spring @Enable 模块装配
@ConditionalOnSystemProperty(name ="user.name", value = "zhengwanlei")
public class HelloWorldAutoConfiguration {

}
