package examples.initialization;

import static examples.initialization.ClassInitDemo.echo;

public class FieldsAndConstructors {

    public static void main(String[] args) {
        /*
        Kolejnosc inicjalizacji pol, a konstruktory:
        1. Wywolanie konstruktora nadklasy lub innego konstruktora tej klasy (przez this)
        2. Inicjalizacja pol i wykonanie blokow inicjalizujacych instancji (w kolejnosci wystepowania)
        3. Reszta konstruktora
         */
        new Sub();
    }
}

class Super {

    Super() {
        // wywolanie konstruktora klasy Object
        System.out.println("Super()");
    }
}

class Sub extends Super {

    private static String staticX = "static field examples.initialization";

    private String x = echo("field examples.initialization");

    {
        System.out.println("examples.initialization block");
    }


    public Sub() {
        // Niepoprawne, bo nie mozna odwolywac sie do pol instancji zanim nie zostanie wywolany konstruktor klasy bazowej
        // lub inny konstruktor tej klasy.
        // this(x);
        this(staticX); // ok
        System.out.println("Sub(), x=" + x);
    }

    public Sub(String s) {
        // tutaj nastepuje wywolanie super();
        // DOPIERO teraz nastepuje inicjalizacja pol instancji.
        System.out.println("Sub(String s), x=" + x);
        // teraz zainicjalizowana wartosc zostaje nadpisana
        x = "initialized in Sub(String s)";
    }
}