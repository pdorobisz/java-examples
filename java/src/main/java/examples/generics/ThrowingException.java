package examples.generics;

import java.sql.SQLException;

public class ThrowingException<T extends Exception> {

    public void rethrow(Exception t) throws T {
        // informacja o typie jest usuwana wiec rzutowanie nic nie robi i mozemy rzucic wyjatek dowolnego typu
        throw (T) t;
    }

    public static void main(String[] args) {
        try {
            // wyjatek "widziany" jako Exception (taki typ wywnioskowal kompilator)
            new ThrowingException().rethrow(new SQLException());
        } catch (Exception e) {
            System.out.println("caught as Exception");
        }

        // Mozemy podpowiedziec kompilatorowi jaki typ powinien byc (tutaj RuntimeException).
        // Kompilator mysli, ze rzucony bedzie RuntimeException wiec nie wymaga try/catch mimo, ze rzucony
        // zostanie SQLException.
        new ThrowingException<RuntimeException>().rethrow(new SQLException());
    }
}
