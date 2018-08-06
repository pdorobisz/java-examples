package examples.puzzlers;

public class NumbersCast {

    public static void main(String[] args) {
        int x = -2;
        byte b = (byte) x;
        short s = b; // konwersja rozszerzajaca - przepisywana jest ta sama wartosc (ze znakiem)
        char c = (char) s; // przepisujemy dokladnie te same bity co w s (short i char maja ten sam rozmiar), ale char jest zawsze dodatni, wiec bity sa inaczej
                           // interpretowane
        char c2 = (char) b; // konwersja rozszerzajaca - zapisujemy wartosc b przy pomocy 16 bitow (czyli w przypadku ujemnej wartosci b otrzymamy duza liczbe
                            // dodatnia bo najstarszy bit przestanie miec ujemna wage)
        int i = c; // konwersja rozszerzajaca, ale przypisywana wartosc jest dodatnia

        System.out.println(x + " : " + Integer.toBinaryString(x));
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("char 2: " + (int) c2);
        System.out.println(i + " : " + Integer.toBinaryString(i));

        System.out.println("-------------------------");

        c = (char) x; // konwersja zwezajaca zakres - brane sa tylko 2 najmlodsze bity
        s = (short) x;
        b = (byte) 128;
        System.out.println("short: " + s);
        System.out.println("byte: " + b);
        System.out.println("char: " + (int) c);

        System.out.println("-------------------------");

        // sterowanie konwersja
        // przypisanie do wiekszego typu
        i = (short) c; // zachowanie znaku: te same bity co w char sa przepisywane do shorta (short posiada znak wiec zmienia sie interpretacja bitow)

        // przypisanie do mniejszego typu
        b = (byte) x;
        c = (char) (x & 0xFF);

        System.out.println("char: " + (int) c);
        System.out.println("int: " + i);
    }
}
