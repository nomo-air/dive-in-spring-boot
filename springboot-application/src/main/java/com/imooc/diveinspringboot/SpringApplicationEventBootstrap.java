package com.imooc.diveinspringboot;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring应用事件引导类
 */
public class SpringApplicationEventBootstrap {

    public static void main(String[] args) {
        // 创建上线文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册应用事件监听
        context.addApplicationListener(event -> {
            System.out.println("监听到事件：" + event);
        });
        // 启动上下文
        context.refresh();
        // 发事件
        context.publishEvent("Hello World ---1");
        context.publishEvent("Hello World ---2");
        // 发事件，关联事件源，自定义事件
        context.publishEvent(new ApplicationEvent("Hello World ---3"){});
        // 关闭上下文
        context.close();

    }
}
