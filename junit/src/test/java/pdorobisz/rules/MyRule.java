package pdorobisz.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MyRule implements TestRule {

    @Override
    public Statement apply(final Statement base, Description description) {
        System.out.println("--apply my rule for: " + description);
        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                System.out.println("  --about to execute: " + base);
                try {
                    base.evaluate(); // test method execution
                } catch (Throwable e) {
                    System.out.println("exception was thrown: " + e);
                }
                System.out.println("  --execution finished: " + base);
            }
        };
    }
}
