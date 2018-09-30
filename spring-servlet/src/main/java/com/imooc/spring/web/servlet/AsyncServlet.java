package com.imooc.spring.web.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static javax.servlet.http.HttpServletResponse.SC_SERVICE_UNAVAILABLE;

@WebServlet(
        asyncSupported = true, // 激活异步特性
        name = "asyncServlet", // Servlet 名字
        urlPatterns = "/async-servlet"
)
public class AsyncServlet extends HttpServlet {
    // 覆盖service

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 判断是否支持异步
        if (req.isAsyncSupported()) {
            // 创建 AsyncContext
            AsyncContext asyncContext = req.startAsync();
            // 设置超时时间
            asyncContext.setTimeout(50L);
            asyncContext.addListener(new AsyncListener() {
                @Override
                public void onComplete(AsyncEvent asyncEvent) throws IOException {
                    println("执行完成");
                }

                @Override
                public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                    println("执行超时");
                    HttpServletResponse servletResponse = (HttpServletResponse) asyncEvent.getSuppliedResponse();
                    servletResponse.setStatus(SC_SERVICE_UNAVAILABLE);
                }

                @Override
                public void onError(AsyncEvent asyncEvent) throws IOException {
                    println("执行错误");
                }

                @Override
                public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                    println("开始执行");
                }
            });
            println("Hello World");
            /*
            ServletResponse servletResponse = asyncContext.getResponse();
            // 设置响应媒体类型
            servletResponse.setContentType("text/plain;charset=UTF-8");
            // 获取字符流
            PrintWriter writer = servletResponse.getWriter();
            writer.print("Hello World");
            writer.flush();
            */
        }
    }

    private static void println(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("AsyncServlet [" + threadName + "]：" + object);
    }
}
