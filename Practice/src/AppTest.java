public class AppTest {
    public static void main(String[] args) {
        assertEquals("Hello, DevOps!", App.greeting("DevOps"), "named greeting");
        assertEquals("Hello, World!", App.greeting(""), "blank greeting");
        System.out.println("All tests passed");
    }

    private static void assertEquals(String expected, String actual, String testName) {
        if (!expected.equals(actual)) {
            throw new AssertionError(testName + " expected [" + expected + "] but was [" + actual + "]");
        }
    }
}

