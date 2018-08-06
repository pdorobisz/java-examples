package examples.puzzles;

import java.io.IOException;

public class ExceptionHandling {
    static int ex() throws Exception {
        try {
            if (true) {
                throw new IOException();
            }
            return 2;
        } catch (IOException e) {
            System.out.println("in catch");
            throw new Exception(e);
        }
        finally {
            System.out.println("in finally");
            return -1; // powoduje, ze wyjatek nie zostaje rzucony
        }
    }

    public static void main(String[] args) {
        // wypisze:
        // in catch
        // in finally
        // -1
        int i = 1;
        try {
            i = ex();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println(i);
    }
}
