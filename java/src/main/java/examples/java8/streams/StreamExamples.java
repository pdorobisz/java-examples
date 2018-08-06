package examples.java8.streams;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {
        countElementOccurencesInArray();
    }

    private static void countElementOccurencesInArray() {
        int array[] = {1, 2, 1, 1, 3, 2, 3, 2, 4};

        final Map<Integer, Long> counted = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("element occurences: " + counted);
    }
}
