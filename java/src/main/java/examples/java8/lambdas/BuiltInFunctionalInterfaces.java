package examples.java8.lambdas;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltInFunctionalInterfaces {

    public static void main(String[] args) {
        // Predicate (zwraca boolean dla argumentu)
        Predicate<String> nonEmptyString = s -> s.length() > 0;
        System.out.println("nonEmptyString: " + nonEmptyString.test("abc"));
        System.out.println("nonEmptyString negate: " + nonEmptyString.negate().test("abc")); // predykat bedacy negacja oryginalnego predykatu

        // Function (zwraca wartosc dla argumentu)
        Function<Integer, Integer> increase = i-> i+1;
        Function<Integer, String> increasedString = increase.andThen(String::valueOf); // laczenie funkcji
        System.out.println("increasedString: " + increasedString.apply(123));

        // Supplier (dostarcza wartosc, nie przyjmuje argumentow)
        Supplier<Date> dateSupplier = Date::new;
        System.out.println("dateSupplier: " + dateSupplier.get());

        // Consumer (operacja do wykonania na argumencie)
        Consumer<Integer> printNumber = i-> System.out.println("consuming: " + i);
        Consumer<Integer> printNumber2 = i-> System.out.println("consuming again: " + i);
        printNumber.andThen(printNumber2).accept(456); // polaczenie dwoch konsumentow
    }
}
