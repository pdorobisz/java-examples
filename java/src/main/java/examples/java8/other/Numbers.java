package examples.java8.other;

public class Numbers {

    public static void main(String[] args) {
        // maksymalna wartosc jaka mozna zapisac na 32 bitach bez znaku (int) jako long (wszystkie bity na 1, najstarszy bit nie jest traktowany jako bit znaku)
        long maxUnsignedInt = (1l << 32) - 1;
        String string = String.valueOf(maxUnsignedInt);
        System.out.println("maxUnsignedInt: " + string);

        // po konwersji tego stringa na inta otrzymujemy -1 (wszystkie bity ustawione na 1, najstarszy jako znak)
        int unsignedInt = Integer.parseUnsignedInt(string, 10);
        System.out.println("unsignedInt: " + unsignedInt);

        // po konwersji na Stringa otrzymujemy znow reprezentacje bez znaku
        String unsignedString = Integer.toUnsignedString(unsignedInt, 10);
        System.out.println("unsignedString: " + unsignedString);

        // metody zapobiegajace przekroczeniu zakresu
        try {
            Math.addExact(Integer.MAX_VALUE, 1);
        } catch (Exception e) {
            System.out.println("overflow when adding");
            e.printStackTrace();
        }
        try {
            Math.incrementExact(Integer.MAX_VALUE);
        } catch (Exception e) {
            System.out.println("overflow when incrementing");
            e.printStackTrace();
        }
    }
}
