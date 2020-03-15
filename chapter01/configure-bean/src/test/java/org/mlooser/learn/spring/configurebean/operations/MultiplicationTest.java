package org.mlooser.learn.spring.configurebean.operations;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplicationTest {
    private final Multiplication multiplication = new Multiplication();

    @Test
    public void handleTest() {
        assertThat(multiplication.handles('*'))
                .isTrue();

        assertThat(multiplication.handles('.'))
                .isFalse();
    }

    @Test
    public void applyTest() {
        assertThat(multiplication.apply(2, 3))
                .isEqualTo(6);
    }
}
