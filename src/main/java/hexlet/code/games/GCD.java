package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;

/**
 * @author aguminskaya
 * @since 02.05.2021
 */
public final class GCD implements Engine {

    @Override
    public String getName() {
        return "GCD";
    }

    @Override
    public void startGame(String userName) {
        System.out.println("Find the greatest common divisor of given numbers.");
        startGameSession(userName);
    }

    @Override
    public boolean playGame() {
        final var op1 = new Random().nextInt(100);
        final var op2 = new Random().nextInt(100);
        System.out.println(String.format("Question: %d %d", op1, op2));
        System.out.print(ANSWER_PATTERN);
        final var answer = Cli.getInteger(System.in);
        final var result = gcdByEuclidsAlgorithm(op1, op2);
        if (result == answer) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println(
                    String.format(WRONG_ANSWER_PATTERN,
                            answer, result));
            return false;
        }
    }

    int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}
