package pdorobisz.theories.annotations;

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class ValuesSupplier extends ParameterSupplier {

    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature signature) {
        System.out.println("ValuesSupplier: " + signature);
        int offset = signature.getAnnotation(Values.class).offset();

        List<PotentialAssignment> result = new ArrayList<>();
        result.add(PotentialAssignment.forValue("value1", offset + 100));
        result.add(PotentialAssignment.forValue("value2", offset + 200));
        result.add(PotentialAssignment.forValue("value3", offset + 300));

        return result;
    }
}
