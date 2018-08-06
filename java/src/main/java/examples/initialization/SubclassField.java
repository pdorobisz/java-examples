package examples.initialization;


public class SubclassField {

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Student();
        // Student p2 = new Student();

        p1.name = "abc";
        p2.name = "xyz"; // ustawienie pola z klasy Person (nie ma polimorfizmu)!

        // Wypisze "abcnull".
        // p2.toString() zwraca wartosc pola "name" z klasy Student, ktore nie jest zainicjalizowane (zainicjalizowane jest pole
        // z klasy Person).
        // Gdyby p2 bylo typu Student to wypisane zostaloby "abcxyz".
        System.out.println(p1.toString() + p2);
    }

    static class Person {
        public String name;

        @Override
        public String toString() {
            return name;
        }
    }

    static class Student extends Person {
        public String name;

        @Override
        public String toString() {
            // wystepuja dwa pola "name" - w tej klasie (this.name) i odziedziczone z nadklasy (super.name).
            return name;
        }
    }
}
