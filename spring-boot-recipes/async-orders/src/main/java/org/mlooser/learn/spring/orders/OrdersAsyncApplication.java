package org.mlooser.learn.spring.orders;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class OrdersAsyncApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrdersAsyncApplication.class, args);
    }

    @Bean
    public ApplicationRunner ordersInitializer(OrderService orderService) {
        return args -> {
            for (int i = 0; i < 20; ++i) {
                String id = UUID.randomUUID().toString();
                int amount = ThreadLocalRandom.current().nextInt(100);
                orderService.addOrder(new Order(id, amount));
            }
        };
    }
}
