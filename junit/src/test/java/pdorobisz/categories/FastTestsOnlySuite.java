package pdorobisz.categories;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(FastTestsCategory.class)
@ExcludeCategory(SlowTestsCategory.class)
@SuiteClasses({ SampleTests.class })
public class FastTestsOnlySuite {
    // runs tests which are in FastTestsCategory BUT NOT in SlowTestsCategory
}
