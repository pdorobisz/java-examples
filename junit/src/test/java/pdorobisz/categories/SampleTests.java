package pdorobisz.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SampleTests {

    @Test
    @Category(IntegrationTestsCategory.class)
    public void test1() {
        System.out.println("test1: IntegrationTestsCategory");
    }

    @Test
    @Category({ IntegrationTestsCategory.class, FastTestsCategory.class })
    public void test2() {
        System.out.println("test2: IntegrationTestsCategory, FastTestsCategory");
    }

    @Test
    @Category({ PerformanceTestsCategory.class })
    public void test3() {
        System.out.println("test3: PerformanceTestsCategory");
    }

    // this test won't be run by Categories runner because it doesn't have any category assigned
    @Test
    public void test4() {
        System.out.println("test4: <NO CATEGORY>");
    }

    @Test
    @Category({ FastTestsCategory.class, SlowTestsCategory.class })
    public void test5() {
        System.out.println("test5: IntegrationTestsCategory, SlowTestsCategory");
    }

    @Test
    @Category({ FastTestsCategory.class })
    public void test6() {
        System.out.println("test6: FastTestsCategory");
    }
}
