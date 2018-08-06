package examples.java8.interfaces;

public interface Child {

    int getAge();

    default String sayHello(String name) {
        return "blabla";
    }

    // domyslna implementacja
    default String play(String toyName) {
        return "playing with " + toyName;
    }
}
