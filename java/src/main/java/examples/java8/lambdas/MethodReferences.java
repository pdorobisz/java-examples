package examples.java8.lambdas;

import java.util.Arrays;
import java.util.List;

public class MethodReferences {
    public static void main(String[] args) {
        List<Hello> list = Arrays.asList(new Hello("World"), new Hello("John"), new Hello("Java"));

        // Sa 4 rodzaje method reference:

        // 1. Odwolanie do statycznej metody
        list.forEach(Hello::staticMethod);
        // to samo co:
        // list.forEach(element -> Hello.staticMethod(element));

        // 2. Odwolanie do metody konkretnego obiektu
        HelloPrinter helloPrinter = new HelloPrinter();
        list.forEach(helloPrinter::instanceMethodOfPrinter);
        // to samo co:
        // list.forEach(element -> helloPrinter.instanceMethodOfPrinter(element));

        // 3. Odwolanie do metody obiektow konkretnego typu:
        list.forEach(Hello::instanceMethod);
        // to samo co:
        // list.forEach((instance)->instance.instanceMethod());

        // 4. Odwolanie do konstruktora
        list.stream().map(HelloPrinter::new).toArray();
        // to samo co:
        // list.stream().map(hello -> new HelloPrinter(hello)).toArray();
    }

    private static class Hello {
        private String name;

        public Hello(String name) {
            this.name = name;
        }

        public static void staticMethod(Hello hello) {
            System.out.println("static method: Hello >" + hello.name + "<");
        }

        public void instanceMethod() {
            System.out.println("instance method: Hello *" + name + "*");
        }
    }

    private static class HelloPrinter {

        public HelloPrinter() {
        }

        public HelloPrinter(Hello hello) {
            System.out.println("constructor: " + hello.name);
        }

        public void instanceMethodOfPrinter(Hello hello) {
            System.out.println("instance method of particular object: Hello <" + hello.name + ">");
        }
    }
}
