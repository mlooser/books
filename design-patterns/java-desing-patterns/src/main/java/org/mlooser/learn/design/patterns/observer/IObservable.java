package org.mlooser.learn.design.patterns.observer;

public interface IObservable {
    void addObservator( IObservator observator);
    void removeObservator( IObservator observator);
}
