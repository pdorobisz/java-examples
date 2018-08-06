package pdorobisz.theories;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

// Although one test method is invoked multiple times with different arguments Eclipse will show it as only one call. 
@RunWith(Theories.class)
public class TheoriesTest {

    @DataPoints
    public static int[] ints = new int[] { 1, 2, 3 };

    @DataPoint
    public static int int_ = 4;

    @DataPoints
    public static Integer[] integers = new Integer[] { 11, 22 };

    @DataPoint
    public static Integer integer = 33;

    @DataPoints
    public static byte[] bytes = new byte[] { 33, 44 };

    @DataPoints
    public static String[] strings = new String[] { "ala", "kot" };

    @DataPoints
    public static A[] as = new A[] { new A(1), new A(2) };

    @DataPoints
    public static B[] bs = new B[] { new B(1), new B(2) };

    // this will be ignored because is not of array type
    @DataPoints
    public static List<Integer> intsMethod() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(111);
        return list;
    }

    // @before and @after are run before every execution of test method (even if it is method with same name but different arguments).

    @Theory
    // JUnit will find DataPoints of same type as argument (here: Integer, not int)
    public void test0(Integer x) {
        System.out.println("test1: " + x);
    }

    @Theory
    public void test1(int x, int y) {
        System.out.println("test1: " + x + ", " + y);
    }

    @Theory
    public void test2(String x, String y) {
        System.out.println("test2: " + x + ", " + y);
    }

    @Theory
    public void test3(int x, String y) {
        System.out.println("test3: " + x + ", " + y);
    }

    @Theory
    // will use DataPoints of all types except primitive types
    public void test4(Object x) {
        System.out.println("test4: " + x);
    }

    @Theory
    public void test5(A x, A y) {
        // B is subclass of A so objects of this class will be passed as parameters too
        // condition is: A.class.isAssignableFrom(X.class), X - class of DataPoint object
        System.out.println("test5: " + x + ", " + y);
    }

    @Theory
    public void test6(B x, B y) {
        System.out.println("test6: " + x + ", " + y);
    }

    @Theory
    public void test7(A a, B b) {
        System.out.println("test7: " + a + ", " + b);
    }

    @Test
    public void ordinarTest() {
        System.out.println("Tests with @Test are also executed.");
    }

}
