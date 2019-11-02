package com.huanglei.wf.router;

import com.huanglei.wf.handler.TimeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
/**
 * Created by lisulong on 2019/4/30.
 */
@Configuration
public class RouterConfig {
    @Autowired
    private TimeHandler timeHandler;

    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        return route(GET("/time"), req -> timeHandler.getTime(req))
                .andRoute(GET("/date"), TimeHandler::getDate)  // 这种方式相对于上一行更加简洁
                .andRoute(GET("/times"), TimeHandler::sendTimePerSec);  // 增加这一行
    }
}
//————————————————
//        版权声明：本文为CSDN博主「几钱清风」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/lisulong1/article/details/89711463//    原文链接：https://blog.csdn.net/lisulong1/article/details/89711463