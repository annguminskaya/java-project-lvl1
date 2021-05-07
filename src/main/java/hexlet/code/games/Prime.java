package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

/**
 * @author aguminskaya
 * @since 03.05.2021
 */
public final class Prime {

    private static final String YES = "yes";
    private static final String NO = "no";
    private static final int PRIME_MAX_NUMBER = 100;
    public static final String NAME = "Prime";

    public static void playGame(String userName) {
        String[] questions = new String[Engine.RETRY_COUNT];
        String[] answers = new String[Engine.RETRY_COUNT];
        for (int i = 0; i < Engine.RETRY_COUNT; i++) {
            final var n = new Random().nextInt(PRIME_MAX_NUMBER);
            if (isPrime(n)) {
                answers[i] = "yes";
            } else {
                answers[i] = "no";
            }
            questions[i] = String.valueOf(n);
        }
        Engine.startGame(String.format("Answer '%s' if the number is prime, otherwise answer '%s'.", YES, NO),
                userName, questions, answers);
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
