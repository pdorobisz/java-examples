package examples.puzzlers;

class Base {
    public String f1 = "field1 - Base";
    public static String f2 = "field2 - Base";
    public static final String f3 = "field3 - Base";

    public static void method1(){
        System.out.println("method1 - Base");
    }
}

class Derived extends Base {
    private final String f1 = "field1 - Derived";
    public String f2 = "field2 - Derived";
    public static final String f3 = "field3 - Derived";

    public static void method1(){
        System.out.println("method1 - Derived");
    }
}

public class Hiding {

    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();

        // pola instancji
        System.out.println(base.f1);
        // System.out.println(derived.f1); // pole jest niewidoczne
        // w przypadku metod taki przypadek jest niemozliwy (metoda w klasie pochodnej nie moze miec mniejszego zakresu widoczonosci)

        // pole f1 z klasy bazowej jest jednak dalej dostepne gdyz zostalo tylko ukryte
        System.out.println(((Base) derived).f1);

        // pole statyczne i pole instancji
        System.out.println(Base.f2);
        System.out.println(derived.f2); // dostep do pola instancji
        // System.out.println(Derived.f2); // pole statyczne nie jest widoczne

        // pola statyczne
        System.out.println(base.f3);
        System.out.println(derived.f3); // dostep do pola statycznego z klasy pochodnej
        System.out.println(Derived.f3); // dostep do pola statycznego z klasy pochodnej
        System.out.println(((Base) derived).f3); // dostep do pola statycznego z klasy bazowej

        // metody
        Derived.method1();

        // dostep do metod statycznych zalezy od typu danego podczas kompilacji, a nie od typu podczas wykonywania
        // programu (jak w przypadku metod instancji)
        Base b = derived;
        ((Base) derived).method1(); // dostep do statycznej metody z klasy bazowej (
        b.method1(); // jw.
    }
}
