package com.huanglei.wf.service.impl;

import com.huanglei.wf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import reactor.core.publisher.Mono;

public class WebReactiveUserDetailsService
        implements ReactiveUserDetailsService{

    @Autowired
    private UserService userService;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        Mono<com.huanglei.wf.entity.User> defUser = userService.findByUsername(username);

        UserDetails user = User.withUsername(null)
                .password(encoder.encode(null))
                .roles(null)
                .build();
        return Mono.just(user);
    }

}
//————————————————
//        版权声明：本文为CSDN博主「蓝色格子衫」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/Joker_2007/article/details/82736183
