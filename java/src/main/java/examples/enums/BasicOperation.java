package examples.enums;

/**
 * Podczas kompilacji enum jest przeksztalcany w klase z prywatnym konstruktorem, a jego elementy sa obiektami
 * przypisanymi do pol statycznych tej klasy (nazwy tych pol sa takie jak nazwy wartosci), np.:
 *
 * public class BasicOperation extends Enum {
 *     private BasicOperation() {...}
 *
 *     public static BasicOperation MINUS;
 *     public static BasicOperation PLUS;
 *
 *     static{
 *      MINUS = new BasicOperation();
 *      PLUS = new BasicOperation();
 *     }
 * }
 *
 * Gdy enum zawiera abstrakcyjne metody to klasa w jaka jest przeksztalcany staje sie abstrakcyjna, a poszczegolne
 * wartosci sa implementowane jako instancje anonimowych klas:
 *
 * MINUS = new BasicOperation() {
 *              public int apply(int x, int y) {...}
 *          };
 */
public enum BasicOperation implements Operation {
    PLUS {
        @Override
        public int apply(int x, int y) {
            return x + y;
        }

        /**
         * Nie da sie wywolac tej metody na zewnatrz w nastepujacy sposob: BasicOperation.PLUS.apply2(1,2);
         * Jest to spowodowane tym, ze PLUS to obiekt klasy anonimowej rozszerzajacej BasicOperation, ale na zewnatrz
         * poslugujemy sie referencjami wskazujacymi wlasnie na BasicOperation.
         *
         */
        public int apply2(int x, int y) {
            return x + y;
        }
    },
    MINUS {
        @Override
        public int apply(int x, int y) {
            return x - y;
        }
    };

    @Override
    public abstract int apply(int x, int y); // mozna dodac ta deklaracje, ale nie jest to konieczne
}
