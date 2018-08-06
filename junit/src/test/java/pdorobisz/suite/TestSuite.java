package pdorobisz.suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = { Tests3.class })
public class TestSuite {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("TestSuite - before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("TestSuite - after class");
    }

}
