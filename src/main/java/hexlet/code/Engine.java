package hexlet.code;

/**
 * @author aguminskaya
 * @since 24.04.2021
 */
public interface Engine {

    Integer RETRY_COUNT = 3;
    String WRONG_ANSWER_PATTERN = "\'%s\' is wrong answer ;(. Correct answer was \'%s\'.";
    String ANSWER_PATTERN = "Your answer: ";

    String YES = "yes";
    String NO = "no";

    /**
     * Печатает условия игры и стартует сессию игры.
     * @param userName - имя игрока
     */
    void startGame(String userName);

    /**
     * Следит за количеством попыток игры и результатом.
     * @param userName - имя игрока
     */
    default void startGameSession(String userName) {
        boolean result = false;
        for (int i = 0; i < RETRY_COUNT; i++) {
            result = playGame();
            if (!result) {
                System.out.println(String.format("Let's try again, %s!", userName));
                break;
            }
        }
        if (result) {
            System.out.println(String.format("Congratulations, %s!", userName));
        }
    }

    /**
     * Запускает непосредственно игру.
     * @return - результат игры. True - правильно, false - неправильно
     */
    boolean playGame();

    /**
     * @return имя игры
     */
    String getName();

}
