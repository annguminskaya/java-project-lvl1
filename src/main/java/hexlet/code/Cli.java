package hexlet.code;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author aguminskaya
 * @since 22.04.2021
 */
public class Cli {

    public static String getName(InputStream inputStream) {
        printlnMessage("Welcome to the Brain Games!");
        printlnMessage("May I have your name?");
        final var name = getInput(inputStream);
        printlnMessage(String.format("Hello, %s!", name));
        return name;
    }

    public static String getInput(InputStream inputStream) {
        return new Scanner(inputStream).next();
    }

    public static void printlnMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(String message) {
        System.out.print(message);
    }
}
