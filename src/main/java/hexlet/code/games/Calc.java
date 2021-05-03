package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.List;
import java.util.Random;

/**
 * @author aguminskaya
 * @since 24.04.2021
 */
public final class Calc implements Engine {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";


    private final List<String> operationList = List.of(PLUS, MINUS, MULTIPLY);

    @Override
    public String getName() {
        return "Calculator";
    }

    @Override
    public void startGame(String userName) {
        System.out.println("What is the result of the expression?");
        startGameSession(userName);
    }

    @Override
    public boolean playGame() {
        final var op1 = new Random().nextInt(100);
        final var op2 = new Random().nextInt(100);
        final var operation = operationList.get(new Random().nextInt(operationList.size()));
        System.out.println(String.format("Question: %d %s %d", op1, operation, op2));
        System.out.print("Your answer: ");
        final var answer = Cli.getString(System.in);
        Integer opResult = 0;
        switch (operation) {
            case PLUS:
                opResult = op1 + op2;
                break;
            case MINUS:
                opResult = op1 - op2;
                break;
            case MULTIPLY:
                opResult = op1 * op2;
                break;
            default: throw new IllegalArgumentException("Operation " + operation + " does't exist!");
        }
        if (opResult.equals(Integer.valueOf(answer))) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println(
                    String.format(WRONG_ANSWER_PATTERN,
                            answer, opResult));
            return false;
        }
    }
}
