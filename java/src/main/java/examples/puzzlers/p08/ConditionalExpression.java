package examples.puzzlers.p08;

public class ConditionalExpression {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        char c1 = 'a';
        char c2 = 'b';
        int i = 0;
        final int final_i = 65;

        // typ wyrazenia warunkowego zalezy od typow operandow:

        // 1. Obydwa wyrazenia maja ten sam typ, wiec wynik rowniez bedzie tego typu
        System.out.println("ten sam typ: " + (true ? c1 : c2));

        // 2. Jeden operand jest typu T (byte, short lub char), a drugi jest stala typu int ktora moze byc reprezentowana w T - wynik jest typu T
        System.out.println("char i stala: " + (true ? c1 : 0));
        System.out.println("char i stala: " + (true ? c1 : final_i)); // gdy zmienna ma modyfikator final to rowniez stosuje sie ta regula
        System.out.println("char i stala: " + (false ? c1 : final_i)); // jw. - druga zmienna jest zamieniana na char

        // 3. Pozostale przypadki - "binary promotion" obydwu operandow, a wynik jest promowanego typu
        System.out.println("pozostale: " + (true ? c1 : i)); // wypisze sie kod (97), a nie znak
        System.out.println("pozostale: " + (false ? c1 : i));
    }
}
