package com.huanglei.wf.dao;

import com.huanglei.wf.entity.MyEvent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface MyEventRepository extends ReactiveMongoRepository<MyEvent, Long> { // 1

    @Tailable        // 1
    Flux<MyEvent> findBy(); // 2
}
