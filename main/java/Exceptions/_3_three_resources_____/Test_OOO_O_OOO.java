package Exceptions._3_three_resources_____;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_OOO_O_OOO {
    public static void main(String[] args) throws Throwable {
        // PREPARE
        final List<String> history = new ArrayList<>();

        final AutoCloseable resourceA = new AutoCloseable() {
            public void close() throws Exception {
                history.add("resourceA.close()");
            }
        };
        final AutoCloseable resourceB = new AutoCloseable() {
            public void close() throws Exception {
                history.add("resourceB.close()");
            }
        };
        final AutoCloseable resourceC = new AutoCloseable() {
            public void close() throws Exception {
                history.add("resourceC.close()");
            }
        };
        AutoCloseableFactory factoryA = new AutoCloseableFactory() {
            public AutoCloseable create() throws Throwable {
                history.add("factoryA.create()");
                return resourceA;
            }
        };
        AutoCloseableFactory factoryB = new AutoCloseableFactory() {
            public AutoCloseable create() throws Throwable {
                history.add("factoryB.create()");
                return resourceB;
            }
        };
        AutoCloseableFactory factoryC = new AutoCloseableFactory() {
            public AutoCloseable create() throws Throwable {
                history.add("factoryC.create()");
                return resourceC;
            }
        };
        TryBody body = new TryBody() {
            public void runBody() throws Throwable {
                history.add("body.runBody()");
            }
        };

        // CALL
        Dispatcher.call(factoryA, factoryB, factoryC, body);

        // CHECK
        if (!history.equals(Arrays.asList(
                "factoryA.create()", "factoryB.create()", "factoryC.create()",
                "body.runBody()",
                "resourceC.close()", "resourceB.close()", "resourceA.close()"))) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
