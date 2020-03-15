package org.mlooser.learn.spring.configurebean.operations;

public interface Operation {
    int apply(int lhs, int rhs);
    boolean handles(char op);
}
