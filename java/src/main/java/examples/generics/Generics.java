package examples.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.*;

public class Generics {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
    }

    private static void example1() {
        ArrayList<Integer> integers = new ArrayList<>();
        //ArrayList<Object> objects = integers; // BLAD, ArrayList<Integer> nie jest podtypem ArrayList<Object>
        Collection<Integer> objects = integers; // OK
    }

    private static void example2() {
        ArrayList rawList = new ArrayList();
        // Mozna przeksztalcic raw liste tak by w runtimie nastepowalo sprawdzenie czy wstawiany element jest odpowiedniego typu.
        // Takie sprawdzanie moze pogorszyc wydajnosc.
        List<Box> boxes = Collections.checkedList(rawList, Box.class);

        // Nie mozna jednak sprawdzac czy typ listy jest parametryzowany odpowiednim typem, gdyz podczas wykonywania programu
        // taka informacja jest niedostepna (type erasure).
        // List<Box<String>> boxes2 = Collections.checkedList(rawList, Box.class);
    }

    private static void example3() {
        try {
            new ActionImpl<ActionException>().doThrow();
        } catch (ActionException e) {
            // Po parametryzacji typem wyjatku kompilatora widzi, ze metoda rzuca wyjatek tego typu
        }
    }

    private static void example4() {
        varArs("abc", "def", "ghi");
        varArs(new ArrayList<Date>(), new LinkedList<Date>());
    }

    private static <T> T[] varArs(T... t) {
        // nie mozna stworzyc tablicy elementow T w ten sposob:
        // T[] array = new T[3];

        // jednak kompilator sam stworzy taka tablice w miejscu, gdzie wystepuje varArgs:
        System.out.println("varArgs: " + t);
        return t;
    }

    private static class ActionException extends Exception {
    }

    private static class ActionImpl<E extends Exception> {
        public void doThrow() throws E {
        }
    }
}
