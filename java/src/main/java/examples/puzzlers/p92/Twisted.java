package examples.puzzlers.p92;

public class Twisted {
    private final String name;

    Twisted(String name) {
        this.name = name;
    }

    private String name() {
        System.out.println("*** name, this: " + this);
        return name;
    }

    String hello() {
        System.out.println("*** hello, this: " + this);
        return "hello " + name;
    }

    private void reproduce() {
        // anonimowa klasa dziedziczaca z zewnetrznej klasy (Twisted)
        new Twisted("reproduce") {
            void printName() {
                // prywatne elementy klasy nie sa dziedziczone wiec tutaj wywolujemy metode name() z klasy Twisted (zewnetrznej)
                System.out.println("name method: " + name());
                // a tutaj odwolujemy sie do prywatnego pola klasy Twisted (anonimowa klasa nie odziedziczyla go)
                System.out.println("name field: " + name);
                // Tutaj wywolujemy odziedziczona metode z Twisted (ta metoda nie jest juz prywatna).
                // Metoda hello korzysta z pola name, ktore nie jest widoczne w tej klasie (jest prywatne), ale jego wartosc
                // zostala ustawiona przez wywolanie konstruktora klasy bazowej: new Twisted("reproduce")
                System.out.println("hello: " + hello());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Twisted("main").reproduce();
    }
}