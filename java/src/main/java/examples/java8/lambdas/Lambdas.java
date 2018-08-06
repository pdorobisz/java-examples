package examples.java8.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lambdas {
    public static void main(String[] args) {
        List<Child> children = Arrays.asList(new Child("Pawel"), new Child("Jasiu"), new Child("Malgosia"), new Child("Adam"));

        // Zamiast explicite implementowac komparator przekazujemy tylko implementacje jego metody (compare)
        Collections.sort(children, (c1, c2) -> c1.name.compareTo(c2.name));

        // to samo co:
//        Collections.sort(children, (Child c1, Child c2) -> {
//            return c1.name.compareTo(c2.name);
//        });


        ////// method reference
        Converter<String, Integer> intConverter = Integer::valueOf; // stworzenie anonimowej klasy implementujacej Converter
        // to samo co:
//        Converter<String, Integer> intConverter = i -> Integer.valueOf(i);
        System.out.println(intConverter.convert("567") + 3);

        // mozemy takze wykorzystywac referencje do konstruktora (podobnie jak do metody) - kompilator dopasowuje odpowiedni konstruktor
        Converter<String, Child> childConverter = Child::new;
        System.out.println(childConverter.convert("Zenek"));


        // W lambdzie mozna odwolywac sie do lokalnych zmiennych spoza lambdy. Nie musza one byc final, ale powinny byc tak traktowane (gdy sa gdzies w kodzie
        // zmieniane to blad kompilacji w linii z lambda.
        int x = 10;
        Converter<String, Integer> intConverter2 = i -> x + Integer.valueOf(i);
        // x++; // gdy odkomentowane to blad kompilacji w linii z lambda
    }
}
