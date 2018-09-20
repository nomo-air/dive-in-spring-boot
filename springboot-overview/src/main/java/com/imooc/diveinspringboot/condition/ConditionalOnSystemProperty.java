package com.imooc.diveinspringboot.condition;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * Java 系统属性条件判断
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(OnSystemPropertyCondition.class )
public @interface ConditionalOnSystemProperty {

    // Java 系统属性名称
    String name();

    // Java 系统属性值
    String value();
}
