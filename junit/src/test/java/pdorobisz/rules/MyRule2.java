package pdorobisz.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MyRule2 implements TestRule {

    @Override
    public Statement apply(final Statement base, Description description) {
        System.out.println("**apply my rule2 for: " + description);
        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                System.out.println("  **about to execute: " + base);
                base.evaluate();
                System.out.println("  **execution finished: " + base);
            }
        };
    }
}
