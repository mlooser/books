package org.mlooser.learn.j9c;

import com.vmlens.api.AllInterleavings;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

interface ThrowingRunnable {
    void run() throws Exception;
}

interface ThrowingConsumer<T, E extends Exception> {
    void accept(T t) throws E;
}

public class AllInterleavingsUtils {
    public static void runAllInterleavings(String executionName, ThrowingRunnable runnable) throws Exception {
        try (AllInterleavings allInterleavings =
                     new AllInterleavings(executionName);) {
            while (allInterleavings.hasNext()) {
                runnable.run();
            }
        }
    }

    public static void startAndJoinThreads(Runnable... runables) {

        List<Thread> threads = Arrays
                .stream(runables)
                .map(Thread::new)
                .map(t->{t.start(); return t;})//peek doesn't work
                .collect(Collectors.toList());

        //vmlens doesn't work properly when "join" is combined with stream
        threads.forEach(convertCheckedException(Thread::join));
    }

    public static <T> Consumer<T> convertCheckedException(ThrowingConsumer<T,Exception> consumer) {
        return i -> {
            try {
                consumer.accept(i);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
