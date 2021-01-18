package org.mlooser.learn.design.patterns.observer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ObservableValueTest {
    private ObservableValue observableValue;

    @Before
    public void before(){
        observableValue = new ObservableValue();
    }

    @Test
    public void setValueTest(){
        IObservator observator = Mockito.mock(IObservator.class);

        observableValue.setValue(0);
        observableValue.addObservator(observator);
        observableValue.setValue(1);

        Mockito.verify(observator, Mockito.times(1)).notify(observableValue);
    }

    @Test
    public void addAndRemoveTest(){
        IObservator observator = Mockito.mock(IObservator.class);

        observableValue.setValue(0);
        observableValue.addObservator(observator);
        observableValue.removeObservator(observator);
        observableValue.setValue(1);

        Mockito.verifyNoMoreInteractions(observator);
    }
}
