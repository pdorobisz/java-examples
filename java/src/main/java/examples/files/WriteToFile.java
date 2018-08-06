package examples.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteToFile {

    public static final String PATH = new File(WriteToFile.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getPath() + File.separator;

    public static void main(String[] args) {
        System.out.println(PATH);

        example1();
        example2();
        example3();
        example4();
    }

    private static void example1() {
        try (
                FileOutputStream outputStream = new FileOutputStream(PATH + "examplefile1.txt"); // strumien do zapisu bajtow do pliku, ma tylko metody do zapisu bajtow
                OutputStreamWriter writer = new OutputStreamWriter(outputStream); // konwertuje znaki do strumienia bajtow (mozna podac kodowanie), posiada metody do zapisu znakow
                BufferedWriter bufferedWriter = new BufferedWriter(writer) // buforuje dane do zapisu by przyspieszyc zapis, dodaje metode zapisujaca znak nowej linii odpowiedni dla systemu
        ) {
            for (int i = 0; i < 10; i++) {
                int code = 65 + i;
                bufferedWriter.write(String.valueOf(code));
                bufferedWriter.write(": ");
                bufferedWriter.write(code); // zapisuje znak o danym kodzie
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void example2() {
        try (
                // tworzy writer z domyslnym kodowaniem (tworzy sobie FileOutputStream)
                FileWriter fileWriter = new FileWriter(PATH + "examplefile2.txt");
                BufferedWriter writer = new BufferedWriter(fileWriter)
        ) {
            writer.write("ABCDEFGH");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void example3() {
        try (
                FileOutputStream outputStream = new FileOutputStream(PATH + "examplefile3.txt"); // strumien do zapisu bajtow do pliku
                PrintStream printStream = new PrintStream(outputStream); // posiada metody zapisujace rozne typy (takze ze znakiem nowej linii), mozna podac kodowanie
                PrintWriter printWriter = new PrintWriter(printStream) // writer umiejacy zapisac rozne typy, ten konstruktor tworzy OutputStreamWriter opakowany w BufferedWriter
                // (sam writer nie moze bezposrednio pisac do strumienia)
        ) {
            for (int i = 0; i < 10; i++) {
                int code = 65 + i;
                printWriter.print(code); // metoda zapisujaca int
                printWriter.print(": "); // metoda zapisujaca String
                printWriter.print((char) code); // metoda zapisujaca char
                printWriter.print(" "); // metoda zapisujaca boolean
                printWriter.println(code % 2 == 0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void example4() {
        // klasa Files z Javy 7
        try {
            Files.write(Paths.get(PATH + "examplefile4.txt"), "Hello World!!!".getBytes());
            // mozna tez pobrac strumien (Files.newOutputStream) albo writera (Files.newBufferedWriter)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
