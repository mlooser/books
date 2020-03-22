package org.mlooser.learn.spring.ahw;

import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class HelloWorldController {
    private final TaskExecutor taskExecutor;

    public HelloWorldController(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @GetMapping("/hello")
    public CompletableFuture<String> getHello(){

        return CompletableFuture.supplyAsync(()->{
           longTask();
           return "Hello async";
        });
    }

    private void longTask(){
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
