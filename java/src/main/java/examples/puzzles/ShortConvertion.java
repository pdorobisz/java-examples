package examples.puzzles;

import java.util.HashSet;

public class ShortConvertion {

    public static void main(String[] args) {
        HashSet<Short> s = new HashSet<Short>();
        for (short i = 0; i < 100; i++) {
            s.add(i);
            // Object o = (short) (i - 1); // (1)
            Object o = i - 1; // nastapi konwersja do inta (1 to int), a nastepnie zadziala autoboxing i powstanie Integer
            s.remove(o); // zbior przechowuje obiekty klasy Short, ale tu usuwamy Integera wiec nic nie zostanie usuniete ze zbioru
        }
        // Wypisze sie 100 gdy nic nie zostalo usuniete
        // Gdy uzyjemy kodu z (1) to wypisane zostanie 1 gdyz "o" bedzie referencja do obiektu klasy Short.
        System.out.println(s.size());
    }
}
