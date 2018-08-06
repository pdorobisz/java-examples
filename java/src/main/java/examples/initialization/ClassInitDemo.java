package examples.initialization;

class A {
    static String xx = ClassInitDemo.echo(" static field A");
    static String xx2 = C.ss2; // null, bo tutaj C.ss2 nie bylo jeszcze zdefiniowane

    static {
        System.out.println("static block A");
    }

    public A() {
        ClassInitDemo.echo(" 3: A()");
    }

    String a1 = ClassInitDemo.echo(" 1: a1");
    String a2 = ClassInitDemo.echo(" 2: a2");
}

class B extends A {
    String b1 = ClassInitDemo.echo(" 4: b1");
    String b2;

    static String yy = ClassInitDemo.echo(" static field B");

    public B() {
        ClassInitDemo.echo(" 5: B()");
        b1 = ClassInitDemo.echo(" 6: b1 reset");
        a2 = ClassInitDemo.echo(" 7: a2 reset");
    }

    public B(String a) {
        System.out.println("B() constr: " + a);
    }
}

class C extends B {

    static String ss = ClassInitDemo.echo(" static field C");
    static String ss2 = ClassInitDemo.echo(" static field2 C");
    static String ss3 = A.xx;

    String c1;
    {
        c1 = ClassInitDemo.echo(" 8: c1");
    }
    String c2;
    String c3 = ClassInitDemo.echo(" 9: c3");

    public C() {
        super(ss);
        ClassInitDemo.echo("10: C()");
        c2 = ClassInitDemo.echo("11: c2");
        b2 = ClassInitDemo.echo("12: b2");
        System.out.println(A.xx2);
        System.out.println(C.ss2);
        System.out.println(C.ss3);
    }
}

public class ClassInitDemo {
    static {
        System.out.println("load ClassInitDemo");
    }

    static String echo(String arg) {
        System.out.println(arg);
        return arg;
    }

    public static void main(String[] args) {
        // Wgrywajac klase classloader wgrywa najpierw klasy z ktorej klasa dziedziczy. Kolejnosc wgrywania bedzie wiec nastepujaca:
        // 1. A (B z niej dziedziczy)
        // 2. B (C z niej dziedziczy)
        // 3. C
        // Podczas wgrywania klasy inicjalizowane sa jej pola statyczne oraz wykonywane sa bloki statyczne w kolejnosci wystepowania.
        //
        // Podczas tworzenia obiektu najpierw inicjowany jest obiekt klasy najwyzej w hierarchii. Inicjowanie obiektu:
        // 1. Inicjowanie pol i wykonanie blokow inicjujacych (w kolejnosci wystepowania)
        // 2. Konstruktor
        // Stworzenie obiektu C przebiega nastepujaco:
        // 1. Pola i bloki klasy A
        // 2. Konstruktor A wywolany przez B
        // 3. Pola i bloki klasy B
        // 4. Konstruktor B wywolany przez C
        // 5. Pola i bloki klasy C
        // 6. Konstruktor C

        new C();
    }
}