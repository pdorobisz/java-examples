package examples.java8.lambdas;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Functions {
    public static void main(String[] args) {
        // funkcja przyjmuje argument zwraca wartosc:
        Function<String, String> doubleStr = s -> s + s;
        Function<String, Child> toChild = Child::new;
        Child ola = doubleStr.andThen(toChild).apply("Ola");
        System.out.println(ola);

        // Supplier tworzy argument danego typu
        Supplier<Child> childSupplier = Child::new;
        System.out.println(childSupplier.get());

        // Consumer reprezentuje operacje na argumencie
        Consumer<Child> childConsumer = c -> System.out.println("consuming child " + c.name);
        childConsumer.accept(ola);
    }
}
