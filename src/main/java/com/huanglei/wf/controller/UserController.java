package com.huanglei.wf.controller;

import com.huanglei.wf.entity.User;
import com.huanglei.wf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    public Mono<User> save(@RequestBody  User user) {
        return this.userService.save(user);
    }

    @DeleteMapping("/{username}")
    public Mono<Long> deleteByUsername(@PathVariable String username) {
        return this.userService.deleteByUsername(username);
    }

    @GetMapping("/{username}")
    public Mono<User> findByUsername(@PathVariable String username) {
        return this.userService.findByUsername(username);
    }

    @GetMapping(value = "",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> findAll() {
        return this.userService.findAll().delayElements(Duration.ofSeconds(2));
    }


    public static void main(String[] args) {
        int[] a={11,12,13};
        for (int m:a){
            System.out.println(m);
        }
        int asInt = IntStream.of(a).min().getAsInt();
        double asDouble = IntStream.of(a).average().getAsDouble();
        System.out.println(asDouble);
        System.out.println(asInt);
    }
}

