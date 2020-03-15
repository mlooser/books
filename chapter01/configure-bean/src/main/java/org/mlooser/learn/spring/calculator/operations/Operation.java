package org.mlooser.learn.spring.calculator.operations;

public interface Operation {
    int apply(int lhs, int rhs);
    boolean handles(char op);
}
