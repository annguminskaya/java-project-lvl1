package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

/**
 * @author aguminskaya
 * @since 24.04.2021
 */
public final class Calc {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";

    public static final String NAME = "Calculator";

    private static final String[] OPERATION_LIST = {PLUS, MINUS, MULTIPLY};

    public static void playGame(String userName) {
        String[] questions = new String[Engine.RETRY_COUNT];
        String[] answers = new String[Engine.RETRY_COUNT];
        for (int i = 0; i < Engine.RETRY_COUNT; i++) {
            final var op1 = new Random().nextInt(100);
            final var op2 = new Random().nextInt(100);
            final var operation = OPERATION_LIST[new Random().nextInt(OPERATION_LIST.length)];
            answers[i] = String.valueOf(doMathOperation(operation, op1, op2));
            questions[i] = String.format("%d %s %d", op1, operation, op2);
        }
        Engine.startGame("What is the result of the expression?", userName, questions, answers);
    }

    private static int doMathOperation(String operation, int op1, int op2) {
        switch (operation) {
            case PLUS:
                return op1 + op2;
            case MINUS:
                return op1 - op2;
            case MULTIPLY:
                return op1 * op2;
            default: throw new IllegalArgumentException("Operation " + operation + " does't exist!");
        }
    }
}
