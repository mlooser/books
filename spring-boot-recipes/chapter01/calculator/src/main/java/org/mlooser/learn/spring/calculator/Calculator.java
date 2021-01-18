package org.mlooser.learn.spring.calculator;

import org.mlooser.learn.spring.calculator.operations.Operation;

import java.util.Collection;

public class Calculator {
    private final Collection<Operation> operations;

    public Calculator(Collection<Operation> operations) {
        this.operations = operations;
    }

    public int calculate(int lhs, int rhs, char op) {
        StringBuilder msg = new StringBuilder()
                .append(lhs)
                .append(' ')
                .append(op)
                .append(' ')
                .append(rhs);

        System.out.println(msg);

        for (Operation operation : operations) {
            if (operation.handles(op)) {
                return operation.apply(lhs, rhs);
            }
        }
        throw new IllegalArgumentException("Unknown operation " + op);
    }
}
