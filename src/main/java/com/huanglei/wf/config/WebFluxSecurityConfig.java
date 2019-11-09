package com.huanglei.wf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class WebFluxSecurityConfig{

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange()
                //.pathMatchers("/loginPage").permitAll()  //无需进行权限过滤的请求路径
                .anyExchange().authenticated()
                .and()
                .httpBasic().and()
                .formLogin()
        //.loginPage("/loginPage")  //自定义的登陆页面
        ;
        return http.build();
    }
}


//————————————————
//        版权声明：本文为CSDN博主「蓝色格子衫」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/Joker_2007/article/details/82736183
