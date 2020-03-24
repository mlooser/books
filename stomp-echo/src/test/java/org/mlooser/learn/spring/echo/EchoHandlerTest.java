package org.mlooser.learn.spring.echo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EchoHandlerTest {
    private final EchoHandler echoHandler = new EchoHandler();

    @Test
    public void echoTest() {
        var inMessage = "test";
        var outMessage = echoHandler.echo(inMessage);

        assertEquals("RECEIVED: " + inMessage, outMessage);
    }
}
