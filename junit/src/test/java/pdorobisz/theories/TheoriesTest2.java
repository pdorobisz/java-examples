package pdorobisz.theories;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoriesTest2 {

    @Before
    public void before() {
        System.out.println("Before is run before every execution of @Theory");
    }

    @DataPoints
    public static int[] intsArray = new int[] { 1, 2, 3 };

    @DataPoints
    public static int[] intsMethod() {
        System.out.println("@DataPoints method is executed before first execution of every @Theory test if this test accepts arguments");
        return new int[] { 4, 5 };
    }

    @DataPoint
    public static String s = "this string won't be used";

    // Test will fail when there will be no arguments to execute this method at least once
    @Theory
    public void test1(int t) {
        System.out.println("test1: " + t);
    }

    @Theory
    public void test2(int t) {
        System.out.println("test2: " + t);
    }

    @Theory
    public void test3() {
        System.out.println("test3 - no arguments so @DataPoints method not executed, and this test is executed only once.");
    }

    @Test
    public void test4() {
        System.out.println("ordinary JUnit test - @DataPoints method is not executed before this test.");
    }
}
