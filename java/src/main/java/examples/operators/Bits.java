package examples.operators;

public class Bits {
    public static void main(String[] args) {
        int i = -16;

        System.out.println("i:       " + Integer.toBinaryString(i));
        // przesuniecia znakowe:
        System.out.println("i << 2:  " + Integer.toBinaryString(i << 2)); // przesuniecie w lewo (pomnozenie przez 2), najmlodsze bity (z prawej) ustawiane na 0
        System.out.println("i >> 3:  " + Integer.toBinaryString(i >> 3)); // przesuniecie w prawo (podzielenie przez 2) z zachowaniem znaku.
        // przesuniecie w prawo bez zachowania znaku - najstarsze bity (z lewej) sa ustawiane na 0
        System.out.println("i >>> 3:    " + Integer.toBinaryString(i >>> 3));

        System.out.println("i << 32: " + Integer.toBinaryString(i << 32)); // brak przesuniecia (przesuwa sie o modulo z liczby bitow do przesuniecia)
        System.out.println("i << 33: " + Integer.toBinaryString(i << 33)); // przesuniecie w lewo o 1 (33 mod 32 = 1)

        // ustawianie bitow
        System.out.println("-----");
        System.out.println("original value: " + Integer.toBinaryString(i));
        System.out.println("set bit 2:      " + Integer.toBinaryString(setBit(i, 2)));
        System.out.println("unset bit 6 :   " + Integer.toBinaryString(unsetBit(i, 6)));
    }

    private static int setBit(int number, int bit) {
        int mask = 1 << bit;
        return number | mask;
    }

    private static int unsetBit(int number, int bit) {
        int mask = ~setBit(0, bit);
        return number & mask;
    }
}
