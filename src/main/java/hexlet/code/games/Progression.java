package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author aguminskaya
 * @since 02.05.2021
 */
public final class Progression implements Engine {

    private static final int PROGRESSION_MIN_SIZE = 5;
    private static final int PROGRESSION_BOUND_SIZE = 10;
    private static final int PROGRESSION_MAX_STEP = 10;
    private static final int PROGRESSION_MAX_START_ELEMENT = 20;

    @Override
    public String getName() {
        return "Progression";
    }


    @Override
    public void startGame(String userName) {
        System.out.println("What number is missing in the progression?");
        startGameSession(userName);
    }

    @Override
    public boolean playGame() {
        int progressionLength = new Random().nextInt(PROGRESSION_BOUND_SIZE) + PROGRESSION_MIN_SIZE;
        int progressionDifference = new Random().nextInt(PROGRESSION_MAX_STEP);
        var progression = generateProgression(progressionLength, progressionDifference);
        int positionToHide = new Random().nextInt(progressionLength - 1) + 1;
        int hiddenValue = progression.get(positionToHide);
        progression.set(positionToHide, null);
        System.out.print("Question: ");
        for (Integer element: progression) {
            if (element == null) {
                System.out.print(".. ");
            } else {
                System.out.print(element + " ");
            }
        }
        System.out.println();
        System.out.print(ANSWER_PATTERN);
        final var answer = Cli.getInteger(System.in);
        if (answer == hiddenValue) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println(
                    String.format(WRONG_ANSWER_PATTERN,
                            answer, hiddenValue));
            return false;
        }
    }

    private List<Integer> generateProgression(int length, int difference) {
        int startPosition = new Random().nextInt(PROGRESSION_MAX_START_ELEMENT);
        List<Integer> progression = new ArrayList<>();
        progression.add(startPosition);
        int currentElement = startPosition;
        for (int i = 1; i < length; i++) {
            currentElement = currentElement + difference;
            progression.add(currentElement);
        }
        return progression;
    }
}
