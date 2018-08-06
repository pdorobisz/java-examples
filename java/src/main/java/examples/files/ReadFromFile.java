package examples.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadFromFile {

    private static final String PATH = new File(ReadFromFile.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getPath() + File.separator + "inputfile.txt";

    public static void main(String[] args) {
        writeToFile();
        System.out.println("---example 1---");
        example1();
        System.out.println("---example 2---");
        example2();
        System.out.println("---example 3---");
        example3();
        System.out.println("---example 4---");
        example4();
    }

    private static void example1() {
        String line;
        try (
                FileInputStream inputStream = new FileInputStream(PATH);
                InputStreamReader reader = new InputStreamReader(inputStream); // mozna podac kodowanie znakow
                BufferedReader bufferedReader = new BufferedReader(reader)
        ) {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void example2() {
        String line;
        try (
                FileReader reader = new FileReader(PATH); // uzywa domyslnego kodowania znakow i domyslnego bufora (tworzy sobie FileInputStream, a sam dziedziczy z InputStreamReader)
                BufferedReader bufferedReader = new BufferedReader(reader)
        ) {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void example3() {
        try (
                Scanner scanner = new Scanner(Paths.get(PATH)) // Scanner posiada metody do parsowania podstawowych typow, mozna tez mu podac znak oddzielajacy wartosci
                // (domyslnie sa to biale znaki), tworzy sobie InputStream i opakowuje go w InputStreamReader. Do konstruktora mozna tez podac kodowanie znakow

                // mozna tez bezposrednio podac strumien
                // FileInputStream inputStream = new FileInputStream(PATH);
                // Scanner scanner = new Scanner(inputStream);

                // albo readera
                // FileReader reader = new FileReader(PATH);
                // Scanner scanner = new Scanner(reader);

        ) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.println("int: " + scanner.nextInt());
                } else {
                    System.out.println("string: " + scanner.next());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void example4() {
        try {
            // klasa Files z Javy 7
            String content = new String(Files.readAllBytes(Paths.get(PATH)));
            // albo:
            // List<String> examples.strings = Files.readAllLines(Paths.get(PATH)); // mozna podac kodowanie znakow
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile() {
        String text = "hello\nworld\n11\n22 33 44 \na b c\n 567\n??";
        try {
            Files.write(Paths.get(PATH), text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
