package pdorobisz.basic;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.internal.AssumptionViolatedException;

public class BasicTests {

    // class should have exactly one public zero-argument constructor
    public BasicTests() {
        // instance of this class is created before every test
    }

    @Test
    public void assumeThatTest() {
        System.out.println("--assumeThatTest--");
        try {
            assumeTrue(false);
        } catch (AssumptionViolatedException e) {
            // assume throws unchecked exception in order to exit test
            e.printStackTrace();
        }
        System.out.println("after assume");
        assertTrue(true);
        System.out.println("--assumeThatTest end--");
    }

    @SuppressWarnings("unused")
    @Test
    public void assumptionTest() {
        // we can stop execution by throwing AssumptionViolatedException exception, such test will be considered as successful
        if (true)
            throw new AssumptionViolatedException("my assumption");
        assertTrue(false);
    }

    @Test
    public void assertionExceptionTest() {
        System.out.println("--assertionTest--");
        try {
            assertEquals(1, 1);
            System.out.println("this text will be printed");
            assertEquals(1, 2);
            System.out.println("this text won't be printed");
        } catch (AssertionError e) {
            // assert* throws AssertionError in order to exit from test
            // this exception is also thrown by assert expressions (assert Expression)
            e.printStackTrace();
        }
        System.out.println("--assertionTest end--");
    }

    // this won't fail because we mark AssertionError exception as expected
    @Test(expected = AssertionError.class)
    public void assertionExceptionExceptedTest() {
        fail("this test should fail"); // throws AssertionError
    }

    // we can add this annotation to class as well
    @Ignore("this test is ignored")
    @Test
    public void ignoreTest() {
        System.out.println("--ignored--");
    }

    @Test
    public void arrayEqualsTest() {
        assertArrayEquals(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 });
        assertArrayEquals(new double[] { 1, 2, 3 }, new double[] { 1, 2.1, 2.9 }, 0.2); // maximum delta between expected and actual value
    }

    @Test
    public void deltaValueTest() {
        // we can specify maximum delta between expected and actual value for which both numbers are still considered equal
        // assertEquals(1.0, 2.0); - deprecated
        assertEquals(1.0, 1.0, 0);
        assertEquals(1.0, 1.09, 0.1);
        assertEquals(1.0f, 1.09f, 0.1f);
        assertEquals(-100, 100, Double.MAX_VALUE); // always equal
    }

    @Test(expected = ArithmeticException.class, timeout = 1000)
    public void exceptionExpectedTest() {
        System.out.println(1 / 0);
        fail("no exception was thrown");
    }
}
