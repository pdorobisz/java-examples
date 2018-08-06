package pdorobisz.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MyClassRule implements TestRule {

    @Override
    public Statement apply(final Statement base, Description description) {
        System.out.println("--- class rule for: " + description);
        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                System.out.println("about to call: " + base + "\n\n");
                base.evaluate(); // executes all tests from 'base' (class or method)
                System.out.println("\n\nexecution finished: " + base);
            }
        };
    }

}
