import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class AppTest {
    public static void main(String[] args) throws Exception {
        Method[] testMethods = Arrays.stream(AppTest.class.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("test"))
                .filter(method -> method.getParameterCount() == 0)
                .filter(method -> Modifier.isStatic(method.getModifiers()))
                .sorted((left, right) -> left.getName().compareTo(right.getName()))
                .toArray(Method[]::new);

        int passed = 0;
        int failed = 0;

        System.out.println("Test run started");
        System.out.println("----------------");

        for (Method method : testMethods) {
            try {
                method.invoke(null);
                passed++;
                System.out.println("[PASS] " + method.getName());
            } catch (InvocationTargetException e) {
                failed++;
                Throwable cause = e.getCause() == null ? e : e.getCause();
                System.out.println("[FAIL] " + method.getName() + " -> " + cause.getMessage());
            }
        }

        System.out.println("----------------");
        System.out.println(testMethods.length + " tests found");
        System.out.println(passed + " tests successful");
        System.out.println(failed + " tests failed");

        if (failed > 0) {
            throw new AssertionError("Some tests failed");
        }

        System.out.println("All tests passed");
    }

    public static void testBlankGreeting() {
        assertEquals("Hello, World!", App.greeting(""));
    }

    public static void testJenkinsGreeting() {
        assertEquals("Hello, Jenkins!", App.greeting("Jenkins"));
    }

    public static void testNamedGreeting() {
        assertEquals("Hello, DevOps!", App.greeting("DevOps"));
    }

    public static void testNullGreeting() {
        assertEquals("Hello, World!", App.greeting(null));
    }

    private static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("expected [" + expected + "] but was [" + actual + "]");
        }
    }
}

