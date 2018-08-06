package pdorobisz.rules;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

// Rule is kind of AOP
@RunWith(Theories.class)
public class RulesTests {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("RulesTests - before class\n");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("\nRulesTests - after class");
    }

    @After
    public void after() {
        System.out.println();
    }

    @DataPoints
    public static int[] ints = new int[] { 11, 22 };

    @ClassRule
    public static MyClassRule classRule = new MyClassRule();

    // rules are applied in declaration order

    @Rule
    public MyRule rule = new MyRule();

    @Rule
    public MyRule2 rule2 = new MyRule2();

    @Rule
    public MyRule3 nullrule = null; // this rule will be skipped

    @Rule
    public MyRule3 rule3 = new MyRule3();

    @Test
    public void test1() {
        assertTrue(true);
    }

    @Test
    public void test2() {
        assertTrue(false);
    }

    @Theory
    public void test3(int x) {
        System.out.println("x=" + x);
        assertTrue(true);
    }
}
