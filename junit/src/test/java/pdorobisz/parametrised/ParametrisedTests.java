package pdorobisz.parametrised;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParametrisedTests {

    private final String str;
    private final int x;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }

    @Before
    public void before() {
        System.out.println("before");
    }

    @After
    public void after() {
        System.out.println("after\n");
    }

    // class can only have one constructor
    public ParametrisedTests(String str, int x) {
        System.out.println("constructor");
        this.str = str;
        this.x = x;
    }

    // use only one set of parameters, otherwise it's not sure which set will be chosen
    @Parameters(name = "{index}: {0} -> {1}")
    public static Collection<Object[]> args() {
        System.out.println("args initialization2 - runs before @beforeClass");
        return Arrays.asList(new Object[][] { { "one", 1 }, { "two", 2 }, { "three", 3 } });
    }

    @Test
    public void test() {
        System.out.println("test: " + str + ", " + x);
        assertTrue(x != 2); // fail only one test in series
    }

    @Test
    public void test2() {
        System.out.println("test2 in base class: " + str + ", " + x);
    }

}
