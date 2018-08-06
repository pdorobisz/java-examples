package examples.lists;

import java.util.*;

public class Iterators {

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Iterator<Integer> iterator1 = ints.iterator();
        Iterator<Integer> iterator2 = ints.iterator();

        // usuwanie
        iterator1.next();
        iterator1.remove(); // moze byc wywolane tylko raz po kazdym wywolaniu next()
        // iterator1.remove(); // kolejne wywolanie spowoduje wyjatek IllegalStateException

        // iterator2.next(); // ConcurrentModificationException bo lista zostala zmodyfikowana przez iterator1
        System.out.println(ints);
    }
}
