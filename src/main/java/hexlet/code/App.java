package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

public class App {

    public static void main(String[] args) {
        String[] menuList = {"Greeting", Even.NAME, Calc.NAME, GCD.NAME, Progression.NAME, Prime.NAME};
        Cli.printlnMessage("Please enter the game number and press Enter.");
        for (int i = 0; i < menuList.length; i++) {
            Cli.printlnMessage((i + 1) + " - " + menuList[i]);
        }
        Cli.printlnMessage("0 - Exit");
        final int answer = Integer.parseInt(Cli.getInput(System.in));
        if (answer > menuList.length || answer < 0) {
            Cli.printlnMessage("Wrong menu choice!");
            System.exit(1);
        }
        if (answer == 0) {
            System.exit(0);
        }
        String userName = Cli.getName(System.in);
        startGameByName(menuList[answer - 1], userName);
    }

    private static void startGameByName(String name, String userName) {
        switch (name) {
            case "Greeting": break;
            case Even.NAME: Even.playGame(userName); break;
            case Calc.NAME: Calc.playGame(userName); break;
            case GCD.NAME: GCD.playGame(userName); break;
            case Progression.NAME: Progression.playGame(userName); break;
            case Prime.NAME: Prime.playGame(userName); break;
            default: throw new IllegalArgumentException("Wrong menu choice!");
        }
    }
}
