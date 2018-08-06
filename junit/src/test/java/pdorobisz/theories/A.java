package pdorobisz.theories;

public class A {

    protected final int nr;

    public A(int nr) {
        this.nr = nr;
    }

    @Override
    public String toString() {
        return "classA " + nr;
    }
}
