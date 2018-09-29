package com.imooc.web.config;

import com.imooc.web.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * REST {@link WebMvcConfigurer}
 */
@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {


    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters){
        // 不建议添加到 converters 末尾
        converters.add(0, new PropertiesHttpMessageConverter()); // 添加到首位
    }

}
