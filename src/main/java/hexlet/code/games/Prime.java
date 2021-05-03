package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;

/**
 * @author aguminskaya
 * @since 03.05.2021
 */
public final class Prime implements Engine {

    private static final int PRIME_MAX_NUMBER = 100;

    @Override
    public String getName() {
        return "Prime";
    }

    @Override
    public void startGame(String userName) {
        System.out.println(String.format("Answer '%s' if the number is prime, otherwise answer '%s'.", YES, NO));
        startGameSession(userName);
    }

    @Override
    public boolean playGame() {
        int number = new Random().nextInt(PRIME_MAX_NUMBER);
        System.out.println(String.format("Question: %d", number));
        System.out.print(ANSWER_PATTERN);
        final var answer = Cli.getString(System.in);
        final var isPrime = isPrime(number);
        if ((isPrime && answer.toLowerCase().equals(YES))
                || (!isPrime && answer.toLowerCase().equals(NO))) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println(
                    String.format("\'%s\' is wrong answer ;(. Correct answer was \'%s\'.",
                            answer, isPrime ? YES : NO));
            return false;
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
