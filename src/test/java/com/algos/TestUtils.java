package com.algos;

import static org.junit.Assert.fail;

public class TestUtils {
    public static void assertFails(UnsafeRunnable runnable, Class<? extends Exception> expectedException,
                                   String expectedMessage) {
        try {
            runnable.run();
        } catch (Exception e) {
            Class<? extends Exception> actualExceptionClass = e.getClass();
            if (!actualExceptionClass.equals(expectedException)) {
                fail("Expected exception '" + expectedException + "' didn't occur! " +
                     "Actual exception is '" + actualExceptionClass + "'.");
            }
            String actualMessage = e.getMessage();
            if (actualMessage != null && !actualMessage.equals(expectedMessage)) {
                fail("Expected message '" + expectedMessage + "' wasn't the right one! " +
                     "Actual message is '" + actualMessage + "'.");
            }
            return;
        }
        fail("Expected exception " + expectedException + " didn't occur!");
    }
}
