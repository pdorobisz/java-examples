package pdorobisz.theories;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoriesTest3 {

    // *********** int DataPoints ***********
    @DataPoints
    public static int[] intsArray = new int[] { 1, 2, 3 };

    @DataPoint
    public static int intField = 4;

    @DataPoints
    public static int[] intsMethod() {
        return new int[] { 5, 6, 7 };
    }

    @DataPoint
    public static int intMethod() {
        return 8;
    }

    // *********** Integer DataPoints ***********
    @DataPoints
    public static Integer[] integerArray = new Integer[] { 10, 20, 30 };

    @DataPoint
    public static Integer integerField = 40;

    @DataPoints
    public static Integer[] integersMethod() {
        return new Integer[] { 50, 60, 70 };
    }

    @DataPoint
    public static Integer integerMethod() {
        return 80;
    }

    // *********** String DataPoints ***********
    @DataPoints
    public static String[] stringsArray = { "aa", "bb", "cc" };

    @DataPoint
    public static String stringField = "dd";

    @DataPoints
    public static String[] stringsMethod() {
        return new String[] { "ee", "ff", "gg" };
    }

    @DataPoint
    public static String stringMethod() {
        return "hh";
    }

    // *********** char DataPoints ***********
    @DataPoints
    public static char[] charsArray = { 'a', 'b', 'c' };

    @DataPoint
    public static char charField = 'd';

    @DataPoints
    public static char[] charsMethod() {
        return new char[] { 'e', 'f', 'g' };
    }

    @DataPoint
    public static char charMethod() {
        return 'h';
    }

    // *********** Char DataPoints ***********
    @DataPoints
    public static Character[] charactersArray = { 'A', 'B', 'C' };

    @DataPoint
    public static Character characterField = 'D';

    @DataPoints
    public static Character[] charactersMethod() {
        return new Character[] { 'E', 'F', 'G' };
    }

    @DataPoint
    public static Character characterMethod() {
        return 'H';
    }

    // *********** tests ***********

    // DataPoints returned by method as an array of primitive type are ignored when argument of Theory is of that primitive type.
    // However those values will be used in Theory which takes wrapping class of that primitive type.

    // DataPoints from intsMethod are ignored.
    @Theory
    public void intTest(int i) {
        System.out.println("intTest: " + i);
    }

    // All DataPoints of Integer type + those returned by intsMethod
    @Theory
    public void integerTest(Integer integer) {
        System.out.println("integerTest: " + integer);
    }

    // All DataPoints of String type.
    @Theory
    public void stringTest(String s) {
        System.out.println("stringTest: " + s);
    }

    // DataPoints from charsMethod are ignored.
    @Theory
    public void charTest(char c) {
        System.out.println("charTest: " + c);
    }

    // All DataPoints of Char type + those returned by charsMethod
    @Theory
    public void characterTest(Character character) {
        System.out.println("characterTest: " + character);
    }
}
