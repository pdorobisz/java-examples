package examples.puzzles;

public class BaseClass {

    protected int i = 1;

    public BaseClass() {
        println();
        init();
    }

    void println() {
        System.out.println(i);
    }

    void init() {
        System.out.println("base.init()");
    }

    public static void main(String[] args) {
        // wypisze:
        // 1
        // child.init()
        ChildClass childClass = new ChildClass();

        // wypisze:
        // 2
        System.out.println(childClass.i);
    }
}

class ChildClass extends BaseClass {

    ChildClass() {
        // tutaj wystepuje wywolanie konstruktora klasy bazowej, a do i nie zostalo jeszcze przypisane 2
        i = 2;
    }

    @Override
    void init() {
        System.out.println("child.init()");
    }
}
