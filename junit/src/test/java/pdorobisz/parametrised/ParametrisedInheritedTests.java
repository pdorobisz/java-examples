package pdorobisz.parametrised;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParametrisedInheritedTests extends ParametrisedTests {

    private final String str;
    private final int x;

    // this would override parameters from base class
    // @Parameters
    // public static Collection<Object[]> args2() {
    // System.out.println("args initialization2 - runs before @beforeClass");
    // return Arrays.asList(new Object[][] { { "four", 4 }, { "five", 5 } });
    // }

    // inherits Parameters from ParametrisedTests
    public ParametrisedInheritedTests(String str, int x) {
        super(str, x);
        this.str = str;
        this.x = x;
    }

    @Override
    @Test
    public void test() {
        System.out.println("test in subclass: " + str + ", " + x);
    }

}
