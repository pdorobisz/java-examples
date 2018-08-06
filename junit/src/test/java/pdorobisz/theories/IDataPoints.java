package pdorobisz.theories;

import org.junit.experimental.theories.DataPoints;

public interface IDataPoints {

    @DataPoints
    public static int[] ints = new int[] { 11, 22, 33 };
}
