package pdorobisz.runner;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class OrderedRunner extends BlockJUnit4ClassRunner {

    public OrderedRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> testMethods = super.computeTestMethods();
        for (FrameworkMethod frameworkMethod : testMethods) {
            System.out.println("method to run: " + frameworkMethod.getName());
        }
        Collections.sort(testMethods, new Comparator<FrameworkMethod>() {

            @Override
            public int compare(FrameworkMethod m1, FrameworkMethod m2) {
                return m1.getName().compareTo(m2.getName());
            }
        });
        return testMethods;
    }

}
