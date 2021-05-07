package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

/**
 * @author aguminskaya
 * @since 23.04.2021
 */
public final class Even {

    public static final String NAME = "Even";

    private static final String YES = "yes";
    private static final String NO = "no";

    public static void playGame(String userName) {
        String[] questions = new String[Engine.RETRY_COUNT];
        String[] answers = new String[Engine.RETRY_COUNT];
        for (int i = 0; i < Engine.RETRY_COUNT; i++) {
            final var n = new Random().nextInt(10_000);
            if (isEven(n)) {
                answers[i] = YES;
            } else {
                answers[i] = NO;
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
