package org.mlooser.learn.design.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class ObservableValue implements IObservable {
    private int value;
    private List<IObservator> observators = new ArrayList<>();

    public void addObservator(IObservator observator) {
        observators.add(observator);
    }

    public void removeObservator(IObservator observator) {
        observators.remove(observator);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (this.value != value) {
            this.value = value;
            notifyObservers();
        }
    }

    private void notifyObservers() {
        observators.forEach(o -> o.notify(this));
    }
}
