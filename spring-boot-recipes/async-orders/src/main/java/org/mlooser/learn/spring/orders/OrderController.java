package org.mlooser.learn.spring.orders;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.Executors;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/ordersRBE")
    public ResponseBodyEmitter getOrdersRBE() {
        var emitter = new ResponseBodyEmitter();
        var executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                var orders = orderService.findAll();
                for (var order : orders) {
                    delay();
                    emitter.send(order);
                }

                emitter.complete();
            } catch (IOException e) {
                emitter.completeWithError(e);
            }
        });
        executor.shutdown();
        return emitter;
    }

    @GetMapping("/ordersSSE")
    public SseEmitter getOrdersSSE() {
        var emitter = new SseEmitter();
        var executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                var orders = orderService.findAll();
                for (var order : orders) {
                    delay();
                    var eventBuiler = SseEmitter.event();
                    emitter.send(eventBuiler
                            .data(order)
                            .name("order-created")
                            .id(String.valueOf(order.hashCode())));
                }
                emitter.complete();
            } catch (IOException e) {
                emitter.completeWithError(e);
            }
        });
        executor.shutdown();
        return emitter;
    }

    private void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
