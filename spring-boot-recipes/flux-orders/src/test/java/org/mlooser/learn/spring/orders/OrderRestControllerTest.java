package org.mlooser.learn.spring.orders;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureWebTestClient
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderRestControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void listSseTest() {
        webTestClient.get().uri("/api-orders/sse")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Order.class).hasSize(20);
    }

    @Test
    public void addAndGetOrderTest() {
        var order = new Order("test1", 1);
        webTestClient.post().uri("/api-orders").syncBody(order)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Order.class).isEqualTo(order);

        webTestClient.get().uri("/api-orders/{id}", order.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(Order.class).isEqualTo(order);
    }
}
