package hexlet.code.games;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

/**
 * @author aguminskaya
 * @since 23.04.2021
 */
public class Even {

    private static final String YES = "yes";
    private static final String NO = "no";

    public static boolean isEven(InputStream inputStream) {
        final var number = new Random().nextInt(10_000);
        System.out.println(String.format("Answer '%s' if the number is even, otherwise answer '%s'.", YES, NO));
        System.out.println(String.format("Question: %d", number));
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(inputStream);
        final var answer = scanner.nextLine();
        final var isEven = number % 2 == 0;
        if ((isEven && answer.toLowerCase().equals(YES))
                || (!isEven && answer.toLowerCase().equals(NO))) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println(
                    String.format("\'%s\' is wrong answer ;(. Correct answer was \'%s\'.",
                            answer, isEven ? YES : NO));
            return false;
        }
    }
}
