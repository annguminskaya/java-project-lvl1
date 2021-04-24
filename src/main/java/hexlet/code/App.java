package hexlet.code;

import hexlet.code.games.Even;

import java.util.Scanner;

public class App {

    private static final Integer TRIES = 3;

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n"
                +
                "2 - Even\n"
                +
                "0 - Exit");
        System.out.println("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        final var answer = scanner.nextInt();
        String userName;
        switch (answer) {
            case 1:
                Cli.getName(System.in);
                break;
            case 2:
                userName = Cli.getName(System.in);
                boolean result = false;
                for (int i = 0; i < TRIES; i++) {
                    result = Even.isEven(System.in);
                    if (!result) {
                        System.out.println(String.format("Let's try again, %s!", userName));
                        break;
                    }
                }
                if (result) {
                    System.out.println(String.format("Congratulations, %s!", userName));
                }
                break;
            default:
                System.out.println("Bye!");
        }
    }
}
