package pdorobisz.categories;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
// also includes categories inherited from SlowTestsCategory
@IncludeCategory(SlowTestsCategory.class)
@SuiteClasses({ SampleTests.class })
public class SlowTestsSuite {

}
