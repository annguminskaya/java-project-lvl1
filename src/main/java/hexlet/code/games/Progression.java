package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

/**
 * @author aguminskaya
 * @since 02.05.2021
 */
public final class Progression {


    private static final int PROGRESSION_MIN_SIZE = 5;
    private static final int PROGRESSION_BOUND_SIZE = 10;
    private static final int PROGRESSION_MAX_STEP = 10;
    private static final int PROGRESSION_MAX_START_ELEMENT = 20;

    public static final String NAME = "Progression";

    public static void playGame(String userName) {
        String[] questions = new String[Engine.RETRY_COUNT];
        String[] answers = new String[Engine.RETRY_COUNT];
        for (int i = 0; i < Engine.RETRY_COUNT; i++) {
            int length = new Random().nextInt(PROGRESSION_BOUND_SIZE) + PROGRESSION_MIN_SIZE;
            int step = new Random().nextInt(PROGRESSION_MAX_STEP);
            int firstElement = new Random().nextInt(PROGRESSION_MAX_START_ELEMENT);
            int positionToHide = new Random().nextInt(length - 1) + 1;
            var progression = generateProgression(firstElement, length, step);
            var hiddenValue = progression[positionToHide];
            answers[i] = String.valueOf(hiddenValue);
            questions[i] = convertToString(progression, positionToHide);
        }
        Engine.startGame("What number is missing in the progression?", userName, questions, answers);
    }

    private static String convertToString(int[] progression, int positionToHide) {
        var builder = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i == positionToHide) {
                builder.append(".. ");
            } else {
                builder.append(progression[i]).append(" ");
            }
        }
        return builder.toString();
    }
    private static int[] generateProgression(int firstElement, int length, int step) {
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = firstElement + i * step;
        }
        return progression;
    }
}
