package examples.java8.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    private static Collection<String> collection = Arrays.asList("aa", "ab", "ac", "ba", "bb", "bc", "aaa", "aaaa", "bbb", "bbbb", "ccccc", "a", "abcadfdfd");

    public static void main(String[] args) {
        // proste stworzenie strumienia
        String collected = Stream.of("ala", "ma", "kota")
                .collect(Collectors.joining(":"));
        System.out.println("collected: " + collected);

        collection
                // stworzenie strumienia
                // .parallelStream() // przetwarzany rownolegle
                .stream()
                        // przetwarzajac strumien korzystamy z operacji intermediate i terminal
                        // intermediate operations (moze byc wiele):
                .filter(s -> s.startsWith("a"))
                .sorted((s1, s2) -> s1.length() - s2.length())
                .map(String::toUpperCase)
                        // terminal operation (moze byc tylko jedna):
                .forEach(System.out::println);

        String reduced = collection
                .stream()
                .filter(s -> s.length() == 2)
                .reduce("::", (s1, s2) -> s1 + "-" + s2); // "::" - pierwsza wartosc

        System.out.println(reduced);

        // Ze Stringa mozna uzyskac strumien znakow
        String uniqueChars = "ala ma kota"
                .chars() // zamiana na strumien intow: IntStream (posiada metody takie jak sum(), average()
                .distinct()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c)) // zamiana na strumien obiektow
                .collect(Collectors.joining());
        System.out.println("uniqueChars: " + uniqueChars);

        String afterFlatMap = Stream.of("a,b,c", "x,y,z", "1,2,3")
                // flatMap przyjmuje jako argument funkcje tworzaca strumien dla kazdego elementow wejsciowego.
                // W ten sposob powstaje strumien strumieni, ktory zostaje nastepnie "splaszczony" w jeden strumien zawierajacy
                // elementy ze wszystkich strumieni.
                .flatMap(s -> Stream.of(s.split(",")))
                .collect(Collectors.joining());
        System.out.println("afterFlatMap: " + afterFlatMap);
    }
}
