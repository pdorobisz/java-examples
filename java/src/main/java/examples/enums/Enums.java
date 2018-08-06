package examples.enums;

import java.util.ArrayList;
import java.util.Collection;

public class Enums {

    public static void main(String[] args) {
        Collection<Operation> operations = new ArrayList<Operation>();
        operations.add(BasicOperation.MINUS);
        operations.add(AdvancedOperation.MIN);
        for (Operation operation : operations) {
            test(operation, 2, 3);
        }
    }

    private static void test(Operation operation, int x, int y) {
        System.out.println(operation.toString() + "(" + x + "," + y + "): " + operation.apply(x, y));
    }
}
