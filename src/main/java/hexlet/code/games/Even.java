package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;

/**
 * @author aguminskaya
 * @since 23.04.2021
 */
public final class Even implements Engine {

    private static final Integer RANDOM_BOUND = 10_000;

    @Override
    public String getName() {
        return "Even";
    }

    @Override
    public void startGame(String userName) {
        System.out.println(String.format("Answer '%s' if the number is even, otherwise answer '%s'.", YES, NO));
        startGameSession(userName);
    }

    @Override
    public boolean playGame() {
        final var number = new Random().nextInt(RANDOM_BOUND);
        System.out.println(String.format("Question: %d", number));
        System.out.print(ANSWER_PATTERN);
        final var answer = Cli.getString(System.in);
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
