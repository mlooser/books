package org.mlooser.learn.spring.echo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Controller
public class EchoHandler {
    @MessageMapping("/echo")
    @SendTo("/topic/echo")
    public String echo(String message){
        return "RECEIVED: " + message;
    }
}
