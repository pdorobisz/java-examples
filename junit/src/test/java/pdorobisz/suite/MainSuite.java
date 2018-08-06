package pdorobisz.suite;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
// you can add one test class multiple times
@SuiteClasses({ Tests1.class, Tests2.class, Tests1.class, TestSuite.class })
public class MainSuite {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("MainSuite - before suite class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("MainSuite - after suite class");
    }

    @Before
    public void before() {
        System.out.println("before won't be executed");
    }

    @After
    public void after() {
        System.out.println("after won't be executed");
    }

    @Test
    public void test() {
        System.out.println("test from suite class won't be executed");
    }

}
