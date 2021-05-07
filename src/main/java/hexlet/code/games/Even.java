package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

/**
 * @author aguminskaya
 * @since 23.04.2021
 */
public final class Even {

    private static final Integer RANDOM_BOUND = 10_000;
    private static final String YES = "yes";
    private static final String NO = "no";
    public static final String NAME = "Even";

    public static void playGame(String userName) {
        String[] questions = new String[Engine.RETRY_COUNT];
        String[] answers = new String[Engine.RETRY_COUNT];
        for (int i = 0; i < Engine.RETRY_COUNT; i++) {
            final var n = new Random().nextInt(RANDOM_BOUND);
            if (isEven(n)) {
                answers[i] = "yes";
            } else {
                answers[i] = "no";
            }
            questions[i] = String.valueOf(n);
        }
        Engine.startGame(String.format("Answer '%s' if the number is even, otherwise answer '%s'.", YES, NO),
                userName, questions, answers);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
