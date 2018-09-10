package com.imooc.diveinspringboot.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 激活HelloWorld模块
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
// @Import(HelloWorldConfiguration.class)
@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {

}
