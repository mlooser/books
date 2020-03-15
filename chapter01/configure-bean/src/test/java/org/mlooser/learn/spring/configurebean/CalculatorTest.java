package org.mlooser.learn.spring.configurebean;

import org.junit.Before;
import org.junit.Test;
import org.mlooser.learn.spring.configurebean.operations.Operation;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.*;

public class CalculatorTest {
    private Calculator calculator;
    private Operation mockOperation;

    @Before
    public void before() {
        mockOperation = mock(Operation.class);
        calculator = new Calculator(
                Collections.singletonList(mockOperation));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateExceptionTest() {
        when(mockOperation.handles(anyChar()))
                .thenReturn(false);

        calculator.calculate(1, 2, '.');
    }

    @Test
    public void calculateTest() {
        when(mockOperation.handles('*'))
                .thenReturn(true);

        when(mockOperation.apply(2, 2))
                .thenReturn(4);

        calculator.calculate(2, 2, '*');
        verify(mockOperation, times(1)).apply(2, 2);
    }
}
