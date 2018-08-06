package examples.operators;

public class Overloading {

    public static void main(String[] args) {
        // przeciazone operatory w Javie
        System.out.println("+");
        System.out.printf("liczby: 1+2=%d%n", 1 + 2); // sumowanie
        System.out.printf("string: \"hello \" + \"world\" = \"%s\"%n", "hello " + "world"); //konkatenacja

        System.out.println("\n&, |");
        // 3 = 011b, 5 = 101b
        System.out.printf("liczby: %d&%d=%d%n", 3, 5, (3 & 5)); // bitowe AND
        System.out.printf("boolean: true & false = %s%n", log(true) & log(false)); // zawsze obliczane wszystkie wartosci logiczne
        System.out.printf("liczby: %d|%d=%d%n", 3, 5, (3 | 5)); // bitowe OR
        System.out.printf("boolean: true | false = %s%n", log(true) | log(false)); // zawsze obliczane wszystkie wartosci logiczne
    }

    private static boolean log(boolean b){
        System.out.printf(" [value] %s%n", b);
        return b;
    }
}
