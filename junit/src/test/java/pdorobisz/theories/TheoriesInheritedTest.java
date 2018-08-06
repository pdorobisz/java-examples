package pdorobisz.theories;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoriesInheritedTest extends TheoriesTest {

    // DataPoints inherited from TheoriesTest class
    @Theory
    public void test(int x) {
        System.out.println("test: " + x);
    }
}
