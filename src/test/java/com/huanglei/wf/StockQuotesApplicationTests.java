package com.huanglei.wf;

import com.huanglei.wf.entity.Quote;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringRunner.class)
//  We create a `@SpringBootTest`, starting an actual server on a `RANDOM_PORT`
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StockQuotesApplicationTests {

//    // Spring Boot will create a `WebTestClient` for you,
//    // already configure and ready to issue requests against "localhost:RANDOM_PORT"
//    @Autowired
//    private WebTestClient webTestClient;
//
//    @Test
//    public void fetchQuotes() {
//        webTestClient
//                // We then create a GET request to test an endpoint
//                .get().uri("/quotes?size=20")
//                .accept(MediaType.APPLICATION_JSON)
//                .exchange()
//                // and use the dedicated DSL to test assertions against the response
//                .expectStatus().isOk()
//                .expectHeader().contentType(MediaType.APPLICATION_JSON)
//                .expectBodyList(Quote.class)
//                .hasSize(20)
//                // Here we check that all Quotes have a positive price value
//                .consumeWith(allQuotes ->
//                        assertThat(allQuotes.getResponseBody())
//                                .allSatisfy(quote -> assertThat(quote.getPrice()).isPositive()));
//    }
//
//    @Test
//    public void fetchQuotesAsStream() {
//        List<Quote> result = webTestClient
//                // We then create a GET request to test an endpoint
//                .get().uri("/quotes")
//                // this time, accepting "application/stream+json"
//                .accept(MediaType.APPLICATION_STREAM_JSON)
//                .exchange()
//                // and use the dedicated DSL to test assertions against the response
//                .expectStatus().isOk()
//                .expectHeader().contentType(MediaType.APPLICATION_STREAM_JSON)
//                .returnResult(Quote.class)
//                .getResponseBody()
//                .take(30)
//                .collectList()
//                .block();
//
//        assertThat(result).allSatisfy(quote -> assertThat(quote.getPrice()).isPositive());
//    }
}
//————————————————
//        版权声明：本文为CSDN博主「Allen716」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/wshl1234567/article/details/80320116
