package pdorobisz.runner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(OrderedRunner.class)
public class RunnerTest {

    @Before
    public void before() {
        System.out.println("before");
    }

    @Test
    public void testB() {
        System.out.println("testB");
    }

    @Test
    public void testA() {
        System.out.println("testA");
    }

    @Test
    public void testC() {
        System.out.println("testC");
    }
}
