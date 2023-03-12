package KiviCapital.Utils;

import java.util.Scanner;

/**
 * Class for Reading user inputs.
 */
public final class InputReader {

    private static Scanner scanner;

    /**
     * Return scanner.
     * @return - Scanner Object.
     */
    public static Scanner getScanner() {
        checkAndCreateScanner();
        return scanner;
    }

    public static String readNextLine() {
        checkAndCreateScanner();
        return scanner.nextLine();
    }

    public static int readNextInt() {
        checkAndCreateScanner();
        return scanner.nextInt();
    }

    private static void checkAndCreateScanner() {
        if (scanner == null) {
            try {
                scanner = new Scanner(System.in);
            } catch (Exception e) {
                System.out.println("Exception while creating scanner");
                e.printStackTrace();
                System.out.println("Exiting application");
                System.exit(1);
            }
        }
    }
}
