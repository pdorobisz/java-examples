package examples.numbers;

// Numeric promotion dla operatorow z dwoma argumentami
public class BinaryNumericPromotion {

    public static void main(String[] args) {
        int i = 0;
        short s = 1;
        byte b = 1;
        long l = 10L;
        float f = 1.0f;
        double d = 2.0;

        // Reguly

        // gdy jeden z operandow to double to drugi jest zamieniany na double:
        double result1 = d * f;

        // w przeciwnym wypadku, gdy jeden z operandow to float to drugi jest zamieniany na float:
        float result2 = i * f;

        // w przeciwnym wypadku, gdy jeden z operandow to long to drugi jest zamieniany na long:
        long result3 = i * l;

        // w przeciwnym wypadku obydwa operandy sa zamieniane na int:
        int result4 = b * b; // wynik to int!
        int result5 = s + s; // wynik to int!

        // operator += (i inne) wykonuje automatyczne rzutowanie na typ pierwszego operanda:
        //  E1 op= E2  =>   E1 = (T)((E1) op (E2)), T - typ E1
        byte result6 = (b += 1);
        short result7 = (s += s);
        int result8 = (i *= f); // wynik to float, ale jest rzutowany na int zeby mogl byc przypisany do i

        //////////////////
        // gdy obydwie wartosci sa stale kompilator automatycznie wstawi rzutowanie
        final short finalS1 = 10;
        final short finalS2 = 20;
        final short result9 = finalS1 + finalS2; // ok

        // jednak gdy kompilator stwierdza, ze przekroczony jest zakres typow to wymaga uzycia szerszego typu
//        final short finalS1 = Short.MAX_VALUE;
//        final short finalS2 = 20;
//        final short result9 = finalS1 + finalS2; // nie skompiluje sie bo wynika wykracza poza zakres short
    }
}
