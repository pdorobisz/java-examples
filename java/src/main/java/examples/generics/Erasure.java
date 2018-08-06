package examples.generics;

import java.util.*;

public class Erasure<T> {


    private void overloadedMethod(Collection<T> collection) {
        System.out.println("overloadedMethod: Collection");
    }

    // Po erasure obydwie metody beda wygladac tak samo (zostanie usuniety typ T)
    // wiec wystapilby blad kompilacji gdyby ta metoda nie byla zakomentowana.
//    private void overloadedMethod(Collection collection) {
//    }

    private void overloadedMethod(List<Integer> list) {
        System.out.println("overloadedMethod: List");
    }

    private void overloadedMethod(Set set) { // mozna tez: Set<?> set
        System.out.println("overloadedMethod: Set");
    }

    public static void main(String[] args) {
        Erasure<String> erasure = new Erasure<>();
        erasure.overloadedMethod(new ArrayList<Integer>()); // wypisze "overloadedMethod: List"
        erasure.overloadedMethod(new ArrayList<String>()); // wypisze "overloadedMethod: Collection"
        erasure.overloadedMethod(new HashSet<Short>()); // wypisze "overloadedMethod: Set" poniewaz Set nie jest parametryzowany w metodzie

        ////
        MySubClass<String> subClass = new MySubClass<>();
        // subClass.doSth("abc"); // podczas kompilacji wystapi blad, gdyz obiekt bedzie posiadal dwie metody z taka sama sygnatura
    }

    static class MyClass<T> {
        public void doSth(T t) {
            System.out.println("MyClass.doSth: " + t);
        }
    }

    static class MySubClass<S extends CharSequence> extends MyClass<String> {
        // @Override // nie wystepuje nadpisanie metody, a jedynie jej przeciazenie
        public void doSth(S s) {
            System.out.println("MySubClass.doSth: " + s);
        }
    }
}


