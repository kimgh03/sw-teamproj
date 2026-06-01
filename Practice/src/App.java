public class App {
    public static void main(String[] args) {
        System.out.println(greeting("DevOps"));
    }

    public static String greeting(String name) {
        if (name == null || name.isBlank()) {
            return "Hello, World!";
        }
        return "Hello, " + name + "!";
    }
}

