package com.imooc.web.reactive.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@SpringBootApplication
@RestController
public class WebFluxApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebFluxApplication.class, args);
    }

    @GetMapping("mvc")
    public String mvc() {
        println("MVC");
        return "MVC";
    }

    @GetMapping("mono")
    public Mono<String> mono() {
        println("Mono");
        return Mono.just("Mono");
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        /*
        return RouterFunctions.route(request -> { // 判断请求参数是否匹配
                    URI uri = request.uri();
                    return "/hello-world".equals(uri.getPath());
                },
                request -> { // 绑定实现
                    return ServerResponse.status(HttpStatus.OK)
                            .body(Mono.just("HelloWorld"), String.class);
                }
        );
        */
        return route(GET("/hello-world"), this::helloWorld);
    }

    public Mono<ServerResponse> helloWorld(ServerRequest serverRequest) {
        println("helloWorld");
        return ServerResponse.status(HttpStatus.OK).body(Mono.just("HelloWorld"), String.class);
    }

    private static void println(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[线程：" + threadName + "] " + object);
    }
}
