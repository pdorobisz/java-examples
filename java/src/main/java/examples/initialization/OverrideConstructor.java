package examples.initialization;

public class OverrideConstructor {

    public static abstract class A {
        public A() {
            System.out.println("constructor A");
            foo();
        }

        public abstract void foo();
    }

    public static class B extends A {
        public B() {
            System.out.println("constructor B");
            foo();
        }

        public void foo() {
            System.out.println("foo B");
        }
    }

    public static abstract class A2 {
        public A2() {
            System.out.println("constructor A2");
            foo();
        }

        public void foo() {
            System.out.println("foo A2");
        }
    }

    public static class B2 extends A2 {
        public B2() {
            System.out.println("constructor B2");
            foo();
        }

        // Gdyby foo w A2 bylo private to nie byloby to nadpisanie i konstruktor A2 uzylby foo z klasy A2, a konstruktor
        // B2 uzylby foo z klasy B2.
        @Override
        public void foo() {
            System.out.println("foo B2");
        }
    }

    public static void main(String[] args) {
        // W obydwu przypadkach konstruktor klasy bazowej (wywolywany z klasy potomnej) korzysta z metody foo w klasie
        // potomnej, czyli wypisze sie:
        // constructor A
        // foo B
        // constructor B
        // foo B
        // ----------
        // constructor A2
        // foo B2
        // constructor B2
        // foo B2

        new B();
        System.out.println("----------");
        new B2();
    }
}
