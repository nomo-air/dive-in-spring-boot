package com.imooc.spring.reactive.reactor;

import com.imooc.spring.reactive.loader.DataLoader;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Flux 示例
 */
public class FluxDemo {
    public static void main(String[] args) throws InterruptedException {

        println("运行...");
        Flux.just("A", "B", "C")
        /*
                .publishOn(Schedulers.elastic()) // 线程池切换
                .map(value -> "+" + value) // 转换
                .subscribe(
                        FluxDemo::println, // 数据消费 = onNext(T)
                        FluxDemo::println, // 异常处理 = onError(Throwable)
                        () -> { // 完成回调 = onComplete();
                            println("完成操作");
                        },
                        subscription -> {// 背压操作 onSubscribe(Subscription)
                            // subscription.request(Integer.MAX_VALUE); // n(大于0) 请求元素的数量
                            subscription.cancel(); // 取消上游传输数据到下游
                        }
                );
        Thread.sleep(1000L); // 多线程没有打印
        */
        .subscribe(new Subscriber<String>() {
            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                subscription.request(1);
            }

            @Override
            public void onNext(String s) {
                println(s);
                subscription.request(1);
                throw new RuntimeException("抛出运行时异常"); // 会阻塞后边的打印
            }

            @Override
            public void onError(Throwable throwable) {
                println(throwable.getMessage());
            }

            @Override
            public void onComplete() {
                println("完成操作");
            }
        });
    }

    private static void println(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[线程：" + threadName + "] " + object);
    }

}
