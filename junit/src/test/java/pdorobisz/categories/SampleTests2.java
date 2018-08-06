package pdorobisz.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(FastTestsCategory.class)
public class SampleTests2 {

    @Test
    @Category(SlowTestsCategory.class)
    public void test1() {
        System.out.println("this test is fast and slow");
    }

    @Test
    public void test2() {
        System.out.println("this test is only fast");
        System.out.println(IntegrationTestsCategory.TYPE);
    }
}
