package examples.java8.interfaces;

public interface Person {
    String getName();

    int getAge();

    // domyslna implementacja
    default String sayHello(String name) {
        return "hello " + name + ", my name is " + getName() + ", I'm " + getAge() + " years old.";
    }

    default String walk(String destination) {
        return "I'm walking to " + destination;
    }
}
