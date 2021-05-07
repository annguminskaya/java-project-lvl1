package hexlet.code;

/**
 * @author aguminskaya
 * @since 24.04.2021
 */
public class Engine {

    public static final Integer RETRY_COUNT = 3;

    public static void startGame(String gameDescription, String userName, String[] questions, String[] correctAnswers) {
        Cli.printlnMessage(gameDescription);
        boolean roundResult = false;
        for (int i = 0; i < questions.length; i++) {
            Cli.printlnMessage(String.format("Question: %s", questions[i]));
            Cli.printMessage("Your answer: ");
            final var answer = Cli.getInput(System.in);
            roundResult = checkAnswer(answer, correctAnswers[i]);
            if (!roundResult) {
                Cli.printlnMessage(String.format("Let's try again, %s!", userName));
                break;
            }
        }
        if (roundResult) {
            Cli.printlnMessage(String.format("Congratulations, %s!", userName));
        }
    }

    private static boolean checkAnswer(String answer, String correctAnswer) {
        if (answer.toLowerCase().equals(correctAnswer.toLowerCase())) {
            Cli.printlnMessage("Correct!");
            return true;
        } else {
            Cli.printlnMessage(String.format("\'%s\' is wrong answer ;(. Correct answer was \'%s\'.",
                    answer, correctAnswer));
            return false;
        }
    }

}
