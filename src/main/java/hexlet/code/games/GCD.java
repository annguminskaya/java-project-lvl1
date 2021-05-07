package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

/**
 * @author aguminskaya
 * @since 02.05.2021
 */
public final class GCD {

    public static final String NAME = "GCD";

    public static void playGame(String userName) {
        String[] questions = new String[Engine.RETRY_COUNT];
        String[] answers = new String[Engine.RETRY_COUNT];
        for (int i = 0; i < Engine.RETRY_COUNT; i++) {
            final var op1 = new Random().nextInt(100);
            final var op2 = new Random().nextInt(100);
            answers[i] = String.valueOf(gcdByEuclidsAlgorithm(op1, op2));
            questions[i] = String.format("%d %d", op1, op2);
        }
        Engine.startGame("Find the greatest common divisor of given numbers.", userName, questions, answers);
    }

    private static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}
