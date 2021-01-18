package org.mlooser.learn.spring.hello;

import org.junit.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class HelloWorldControllerTest {
    private final HelloWorldController helloWorldController = new HelloWorldController();

    @Test
    public void helloTest(){
        Mono<String> result = helloWorldController.hello();

        StepVerifier
                .create(result)
                .expectNext("Hello from WebFlux")
                .verifyComplete();
    }
}
