package com.imooc.web.http.converter.properties;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * {@link Properties} {@link HttpMessageConverter} 实现
 */
public class PropertiesHttpMessageConverter extends AbstractGenericHttpMessageConverter<Properties> {

    public PropertiesHttpMessageConverter(){
        // 设置支持的MediaType
        super(new MediaType("text","properties"));
    }

    @Override
    protected void writeInternal(Properties properties, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

    }

    @Override
    protected Properties readInternal(Class<? extends Properties> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        // 字符流 -> 字符编码
        // 从请求头Content-Type 解析编码
        HttpHeaders httpHeaders = inputMessage.getHeaders();
        MediaType contentType = httpHeaders.getContentType();
        // 获取字符编码
        Charset charset = contentType.getCharset();
        // 当charset不存在时，使用
        charset = charset == null ? Charset.forName("UTF-8") : charset;
        // 字节流
        InputStream inputStream = inputMessage.getBody();
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        Properties properties = new Properties();
        // 加载字符流成为 Properties 对象
        properties.load(reader);
        return properties;
    }

    @Override
    public Properties read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return readInternal(null, inputMessage);
    }
}
