package examples.puzzlers;

public class Modulo {

    public static void main(String[] args) {
        // w matematyce reszta nie moze byc mniejsza od 0 bo musi byc spelnione:
        // a = d*b + r, 0<=r<|b|, d - wynik dzielenia, r - reszta z dzielenia
        // w Javie wynik dzielenia jest zawsze zaokraglany w kierunku 0, czyli dla ujemnej dzielnej reszta musi byc ujemna.
        print(5, 2);
        print(5, -2);
        print(-5, 2);
        print(-5, -2);
    }

    private static void print(int a, int b) {
        System.out.println(String.format("%d/%d=%d, %d", a, b, a / b, a % b));
    }

}
