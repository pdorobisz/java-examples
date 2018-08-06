package examples.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyFile {

    private static final String PATH = new File(CopyFile.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getPath() + File.separator;
    private static final String SRC_FILE = "copyfilesrc";
    private static final String DEST_FILE = "copyfiledest";

    public static void main(String[] args) {
        createFile();
        example1();
        example2();
    }

    private static void example1() {
        try (
                FileInputStream inputStream = new FileInputStream(PATH + SRC_FILE);
                FileOutputStream outputStream = new FileOutputStream(PATH + DEST_FILE + 1)) {
            byte[] buffer = new byte[3]; // normalnie bufor powinien byc wiekszy
            while (inputStream.read(buffer) > 0) {
                outputStream.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void example2() {
        try {
            Files.copy(Paths.get(PATH, SRC_FILE), Paths.get(PATH, DEST_FILE + 2), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFile() {
        String text = "qwerty\nasdfg\nzxcv\n123\n456";
        try {
            Files.write(Paths.get(PATH, SRC_FILE), text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
