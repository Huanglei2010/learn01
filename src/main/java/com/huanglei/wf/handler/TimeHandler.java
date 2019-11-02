package com.huanglei.wf.handler;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Created by lisulong on 2019/4/30.
 */
@Component
public class TimeHandler {
    public static Mono<ServerResponse> getTime(ServerRequest serverRequest) {
        return ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("Now is " + new SimpleDateFormat("HH:mm:ss").format(new Date())), String.class);
    }

    public static Mono<ServerResponse> getDate(ServerRequest serverRequest) {
        return ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("Today is " + new SimpleDateFormat("yyyy-MM-dd").format(new Date())), String.class);
    }

    public static Mono<ServerResponse> sendTimePerSec(ServerRequest serverRequest) {
        //模拟异步线程动态改变Flux结果
        StringBuilder result = new StringBuilder("abc");
        Thread thread = new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    result.append(i);
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
        return ok().contentType(MediaType.TEXT_EVENT_STREAM).body(  // 1
                Flux.interval(Duration.ofSeconds(1)).   // 2
                        map(l -> new SimpleDateFormat("HH:mm:ss").format(new Date()) + result.toString()), String.class);
    }
}
//————————————————
//        版权声明：本文为CSDN博主「几钱清风」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/lisulong1/article/details/89711463