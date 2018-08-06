package examples.initialization;

public class FieldsInit {

    public static final String A = init("A") + "a" + Class2.B + init("A2");
    public static final String C = "c" + init("C");

    public static void main(String[] args) {
        System.out.println("main");
        System.out.println("A=" + A); // abnull
        System.out.println("C=" + C); // c
        System.out.println("Class2.B=" + Class2.B); // bnull
    }

    public static String init(String x) {
        System.out.println("init " + x);
        return "";
    }
}

class Class2 {
    public static final String B = "b" + FieldsInit.C + init("B");

    public static String init(String x) {
        System.out.println("init2 " + x);
        return "";
    }
}