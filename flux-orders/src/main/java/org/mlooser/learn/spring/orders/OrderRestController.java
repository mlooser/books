package org.mlooser.learn.spring.orders;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api-orders")
public class OrderRestController {
    private final OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Mono<Order> store(@RequestBody Mono<Order> order){
        return orderService.save(order);
    }

    @GetMapping("/{id}")
    public Mono<Order> find(@PathVariable("id") String id){
        return orderService.findById(id);
    }

    @GetMapping(value = "/stream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Order> listJsonStream(){
        return orderService.orders();
    }

    @GetMapping(value = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Order> listSse(){
        return orderService.orders();
    }
}
