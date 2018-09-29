package com.imooc.web.method.support;

import com.imooc.web.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Objects;
import java.util.Properties;

/**
 * {@link Properties} {@link HandlerMethodReturnValueHandler}
 */
public class PropertiesHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        // 判断返回值类型，是否与 Properties 类型匹配
        return Properties.class.equals(Objects.requireNonNull(returnType.getMethod()).getReturnType());
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest) throws Exception {
        // 强制转换
        Properties properties = (Properties) returnValue;
        PropertiesHttpMessageConverter converter = new PropertiesHttpMessageConverter();
        ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;
        // Servlet request API
        HttpServletRequest request = servletWebRequest.getRequest();
        String contentType = request.getHeader("Content-Type");
        // 获取请求头Content-Type媒体类型
        MediaType mediaType = MediaType.parseMediaType(contentType);
        // 获取
        HttpServletResponse response = servletWebRequest.getResponse();
        HttpOutputMessage message = new ServletServerHttpResponse(response);
        // 通过 PropertiesHttpMessageConverter 输出
        converter.write(properties, mediaType, message);
        // 告知Spring Web Mvc 当前请求已经处理完毕
        mavContainer.setRequestHandled(true);
    }
}
