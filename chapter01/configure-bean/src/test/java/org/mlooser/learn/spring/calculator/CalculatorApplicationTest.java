package org.mlooser.learn.spring.calculator;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mlooser.learn.spring.calculator.operations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalculatorApplication.class)
public class CalculatorApplicationTest {
    @Autowired
    private Calculator calculator;

    @Rule
    public OutputCapture capture = new OutputCapture();

    @MockBean(name = "division")
    private Operation mockDivision;

    @Test(expected = IllegalArgumentException.class)
    public void calculationDivisionTest() {
        calculator.calculate(1, 2, '/');
    }

    @Test
    public void calculateTest() {
        calculator.calculate(2, 3, '*');
        capture.expect(Matchers.containsString("2 * 3"));
    }

    @Test
    public void operationsCountTest() {
        Object operations = ReflectionTestUtils.getField(calculator, "operations");
        assertThat((Collection) operations).hasSize(3);
    }

    @Test
    public void mockDivisionTest() {
        when(mockDivision.handles('/'))
                .thenReturn(true);
        when(mockDivision.apply(14, 7))
                .thenReturn(2);

        assertThat(calculator.calculate(14, 7, '/'))
                .isEqualTo(2);
    }

}
