package com.huanglei.wf.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class FirstWebFilter implements WebFilter{
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        serverWebExchange.getAttributes().put("User", "jerry");
        System.out.println("我是拦截器"+serverWebExchange);
        return webFilterChain.filter(serverWebExchange);
    }
}
