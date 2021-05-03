package hexlet.code;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author aguminskaya
 * @since 22.04.2021
 */
public class Cli {

    public static String getName(InputStream inputStream) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        final var name = getString(inputStream);
        System.out.println(String.format("Hello, %s!", name));
        return name;
    }

    public static Integer getInteger(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Your should type integer!");
            System.exit(1);
        }
        return null;
    }

    public static String getString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        try {
            return scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Your should type string value!");
            System.exit(1);
        }
        return null;
    }
}
