package com.huanglei.wf.handler;
import com.huanglei.wf.entity.Quote;
import com.huanglei.wf.generator.QuoteGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.time.Duration.ofMillis;
import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class QuoteHandler {

    private final Flux<Quote> quoteStream;

    public QuoteHandler(QuoteGenerator quoteGenerator) {
        this.quoteStream = quoteGenerator.fetchQuoteStream(ofMillis(1000)).share();
    }

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ok().contentType(TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello Spring!"));
    }

    public Mono<ServerResponse> echo(ServerRequest request) {
        return ok().contentType(TEXT_PLAIN)
                .body(request.bodyToMono(String.class), String.class);
    }

    public Mono<ServerResponse> streamQuotes(ServerRequest request) {
        return ok()
                .contentType(APPLICATION_STREAM_JSON)
                .body(this.quoteStream, Quote.class);
    }

    public Mono<ServerResponse> fetchQuotes(ServerRequest request) {
        int size = Integer.parseInt(request.queryParam("size").orElse("10"));
        return ok()
                .contentType(APPLICATION_JSON)
                .body(this.quoteStream.take(size), Quote.class);
    }
}
//————————————————
//        版权声明：本文为CSDN博主「Allen716」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/wshl1234567/article/details/80320116
