package org.mlooser.learn.spring.orders;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {
    private final Map<String, Order> orders = new HashMap<>();

    @PostConstruct
    public void init() {
        for (int i = 0; i < 20; ++i) {
            var order = new Order(UUID.randomUUID().toString(), 1);
            save(order);
        }
    }

    public Mono<Order> findById(String id) {
        return Mono.justOrEmpty(orders.get(id));
    }

    public Mono<Order> save(Mono<Order> order) {
        return order.map(this::save);
    }

    private Order save(Order order) {
        orders.put(order.getId(), order);
        return order;
    }

    public Flux<Order> orders() {
        return Flux
                .fromIterable(orders.values())
                .delayElements(Duration.ofMillis(128));
    }
}
