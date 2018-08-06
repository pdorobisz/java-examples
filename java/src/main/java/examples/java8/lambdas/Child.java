package examples.java8.lambdas;

public class Child {
    public final String name;

    public Child(String name) {
        this.name = name;
    }

    public Child() {
        this.name = "unknown";
    }

    @Override
    public String toString() {
        return "Child: " + name;
    }
}
