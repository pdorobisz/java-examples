package examples.strings;

public class StringInternalization {

    public static void main(String[] args) {
        // literaly sa automatycznie internowane
        String s = "abcd";

        String s2 = new String(s); // stworzenie nowego obiektu

        // Metoda intern sprawdza czy dany string znajduje sie juz w puli. Jezeli tak to go zwraca, a jezeli nie
        // to wstawia go do puli.
        // W obydwu przypadkach otrzymamy ten sam obiekt.
        String interned1 = new String(s).intern();
        String interned2 = new String(s).intern();

        System.out.println(s == s2); // false (mamy rozne obiekty)
        System.out.println(s.equals(s2)); // true (wartosci sa sobie rowne)
        System.out.println(interned1 == interned2); // true (odnosza sie do tych samych stringow)
    }
}
