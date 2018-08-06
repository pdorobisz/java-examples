package examples.strings;

public class StringConcatenation {

    public static void main(String[] args) {
        String s = "hello";
        Test t = new Test();

        // gdy jeden z operandow "+" jest stringiem, a drugi nie to drugi jest konwertowany do stringa
        String s1 = 10 + s; // "10hello"
        String s2 = 10 + 20 + s; // "30hello"
        String s3 = s + 10; // "hello10"
        String s4 = s + 10 + 20; // "hello1020"
        String s5 = t + s; // "<<Test class>>hello"
        String s6 = s + t; // "hello<<Test class>>"
        // String s7 = t + 10; // blad

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
    }

    private static class Test {
        @Override
        public String toString() {
            return "<<Test class>>";
        }
    }
}
