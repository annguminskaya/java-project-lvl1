package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Engine> engines = List.of(new Even(), new Calc(), new GCD(), new Progression(), new Prime());
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greeting");
        for (int i = 0; i < engines.size(); i++) {
            System.out.println(i + 2 + " - " + engines.get(i).getName());
        }
        System.out.println("0 - Exit");
        System.out.println("Your choice: ");
        final int answer = Cli.getInteger(System.in);
        if (answer > engines.size() + 1 || answer < 0) {
            System.out.println("Wrong menu choice!");
            System.exit(1);
        }
        String userName;
        if (answer != 0) {
            userName = Cli.getName(System.in);
            if (answer != 1) {
                var game = engines.get(answer - 2);
                if (game != null) {
                    game.startGame(userName);
                }
            }
        }
    }
}
