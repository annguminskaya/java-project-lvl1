package hexlet.code;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author aguminskaya
 * @since 22.04.2021
 */
public class Cli {

    public static String getName(InputStream inputStream) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner scanner = new Scanner(inputStream);
        final var name = scanner.nextLine();
        System.out.println(String.format("Hello, %s!", name));
        return name;
    }
}
