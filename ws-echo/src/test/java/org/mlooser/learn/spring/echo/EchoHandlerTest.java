package org.mlooser.learn.spring.echo;

import org.junit.Test;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import static org.mockito.Mockito.*;

public class EchoHandlerTest {
    private final EchoHandler echoHandler = new EchoHandler();

    @Test
    public void handleTextMessageTest() throws Exception {
        var mockSession = mock(WebSocketSession.class);
        var message = new TextMessage("test");

        echoHandler.handleTextMessage(mockSession,message);

        verify(mockSession, times(1))
                .sendMessage(new TextMessage("RECEIVED test"));
    }
}
