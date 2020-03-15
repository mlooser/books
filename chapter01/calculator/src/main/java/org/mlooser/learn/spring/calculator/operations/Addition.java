package org.mlooser.learn.spring.calculator.operations;

import org.springframework.stereotype.Component;

@Component
public class Addition implements Operation {
    public int apply(int lhs, int rhs) {
        return lhs + rhs;
    }

    public boolean handles(char op) {
        return '+' == op;
    }
}
