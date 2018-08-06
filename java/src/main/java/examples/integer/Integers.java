package examples.integer;

public class Integers {

    public static void main(String[] args) {
        // false, porownujemy dwa rozne obiekty
        System.out.println(new Integer("127") == new Integer("127"));

        // true, wartosci -128-127 sa cache'owane wiec obydwa wywolania valueOf zwroca ten sam obiekt
        System.out.println(Integer.valueOf("127") == Integer.valueOf("127"));

        // false, przy domyslnych ustawieniach, mozna zmienic gorna granice do ktorej sa cache'owane wartosci:
        // java -Djava.lang.Integer.IntegerCache.high=128 MyClass
        System.out.println(Integer.valueOf("128") == Integer.valueOf("128"));

        // false, jw. gdyz podczas autoboxingu (zamiana int na Integer) wystepuje wywolanie valueOf, ktore
        // korzysta z cache'owania.
        System.out.println((Integer) 128 == (Integer) 128);

        // true, parseInt zwraca int (typ prymitywny), wiec porownujemy tu wartosci
        System.out.println(Integer.parseInt("127") == Integer.valueOf("127"));

        // true, porownanie typu prymitywnego z obiektem Integer reprezentujacym ta sama wartosc
        // (nastapi automatyczny unboxing i bedziemy porownywac wartosci, a nie obiekty)
        System.out.println(Integer.parseInt("128") == new Integer(128));
    }
}
