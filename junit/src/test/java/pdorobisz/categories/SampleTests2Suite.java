package pdorobisz.categories;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(FastTestsCategory.class)
// @IncludeCategory(SlowTestsCategory.class)
@SuiteClasses({ SampleTests2.class })
public class SampleTests2Suite {

}
