package examples.bigDecimal;

import java.math.BigDecimal;

public class BigDecimalExamples {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("12.34");
        BigDecimal scaled = bigDecimal.setScale(4);

        System.out.println("original: " + bigDecimal); // wypisze "12.34"
        System.out.println("original scale: " + bigDecimal.scale()); // wypisze "2"
        System.out.println("scaled: " + scaled); // wypisze "12.3400"
        System.out.println("scaled.unscaledValue: " + scaled.unscaledValue()); // wypisze "123400"

        // Sa rozne gdyz liczy sie scale...
        System.out.println("equals: " + (bigDecimal.equals(scaled)));
        // ...ale compareTo zwroci 0 (rowne), gdyz ignoruje scale. Jest to niespojnosc w API.
        System.out.println("compareTo: " + (bigDecimal.compareTo(scaled)));

    }
}
