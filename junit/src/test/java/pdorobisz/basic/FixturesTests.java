package pdorobisz.basic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FixturesTests {

    public FixturesTests() {
        System.out.println("\nconstructor!!!");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("**before class**");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("\n**after class**");
    }

    @Before
    public void before() {
        System.out.println("\nbefore test");
    }

    @After
    public void after() {
        System.out.println("after test");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() throws Exception {
        System.out.println("test2");
        // after methods are invoked even if exception was thrown
        throw new Exception("exception");
    }
}
