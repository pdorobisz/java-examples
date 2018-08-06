package pdorobisz.theories.annotations;

import org.junit.Before;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class AnnotationsTest {

    @Before
    public void before() {
        System.out.println("Before is run before every execution of @Theory");
    }

    @DataPoints
    public static int[] ints = new int[] { 111, 222 };

    @Theory
    public void test0(@Names String name) {
        System.out.println("test0: " + name);
    }

    // two suppliers
    @Theory
    public void test1(@Values(offset = 1000) int value, @Names String name) {
        System.out.println("test1: " + value + ": " + name);
    }

    @Theory
    // @TestedOn - predefined supplier
    public void test2(@TestedOn(ints = { 1, 2, 3, 4 }) int value) {
        System.out.println("test2: " + value);
    }

    // mixed - annotation and DataPoint
    @Theory
    public void test3(@Values int value1, int value2) {
        System.out.println("test3: " + value1 + ", " + value2);
    }

    @Theory
    // we can also use @ParametersSuppliedBy directly
    public void test4(@ParametersSuppliedBy(NamesSupplier.class) String value) {
        System.out.println("test4: " + value);
    }
}
