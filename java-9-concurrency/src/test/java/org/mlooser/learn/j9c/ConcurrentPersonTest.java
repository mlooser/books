package org.mlooser.learn.j9c;

import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mlooser.learn.j9c.AllInterleavingsUtils.startAndJoinThreads;

public class ConcurrentPersonTest {
    @Test
    public void readWriteDataTest() throws Exception {

        List<String> bibleGuys = Arrays.asList(
                "John Thebabtist",
                "Peter Therock");

        Condition<String> isBibleGuy = new Condition(bibleGuys::contains,"bibleGuy");

        AllInterleavingsUtils.runAllInterleavings(
                "ConcurrentPersonTest.readWriteDataTest",
                () -> {
                    ConcurrentPerson person =
                            new ConcurrentPerson("John","Thebabtist");

                    StringBuilder personString = new StringBuilder();

                    startAndJoinThreads(
                            () -> person.setData("Peter","Therock"),
                            () -> personString.append(person)
                    );

                    assertThat(personString.toString())
                            .is(anyOf(isBibleGuy));
                }
        );
    }
}
