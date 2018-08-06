package pdorobisz.theories.annotations;

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class NamesSupplier extends ParameterSupplier {

    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature signature) {
        System.out.println("NamesSupplier: " + signature);

        List<PotentialAssignment> result = new ArrayList<>();
        result.add(PotentialAssignment.forValue("name1", "John"));
        result.add(PotentialAssignment.forValue("name2", "Mark"));
        result.add(PotentialAssignment.forValue("name3", "Paul"));

        return result;
    }
}
