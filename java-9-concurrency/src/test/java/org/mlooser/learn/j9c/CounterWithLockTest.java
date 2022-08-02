package org.mlooser.learn.j9c;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mlooser.learn.j9c.AllInterleavingsUtils.startAndJoinThreads;

public class CounterWithLockTest {

    @Test
    public void addValTest() throws Exception {

        AllInterleavingsUtils.runAllInterleavings(
                "CounterWithLockTest.addValTest",
                () -> {
                    CounterWithLock counter = new CounterWithLock();

                    startAndJoinThreads(
                            () -> counter.addValue(2),
                            () -> counter.addValue(-2)
                    );

                    assertThat(counter.getValue())
                            .isEqualTo(0);
                }
        );
    }
}