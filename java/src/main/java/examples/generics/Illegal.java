package examples.generics;

import java.util.List;

public class Illegal {

    // Typy generyczne nie moga byc uzywane z:

    // 1. Wyjatkami
    // public class MyException<T> extends Exception {}

    // 2. W klasach anonimowych (nie mialoby sensu bo klasa anonimowa nie ma nazwy)

    // 3. Z enumami
    // enum MyEnum<T> {}

    // 4. Przy tworzeniu tablic (new List<String>[10] jest niepoprawne, a typ List<String>[] jest poprawny, ale nie ma sensu
    // gdyz nie jestesmy w stanie stworzyc listy tego typu)
    // List<String>[] examples.lists = new List<String>[10];
    List<?>[] lists = new List<?>[10]; // poprawne - mozna uzywac wildcardow
}

// Nie mozna dwa razy implementowac tego samego interfejsu parametryzowanego roznymi typami.
class MyClass implements MyInterface<String>/*, MyInterface<Integer>*/ {

    @Override
    public String getValue() {
        return null;
    }
}

interface MyInterface<T> {
    T getValue();
}
