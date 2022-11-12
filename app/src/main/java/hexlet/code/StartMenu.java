package hexlet.code;

import java.util.Scanner;

public class StartMenu {

    public static String start() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.print("1 - Greet\n"
                + "2 - Even\n"
                + "3 - Calc\n"
                + "4 - GCD\n"
                + "5 - Progression\n"
                + "6 - Prime\n"
                + "0 - Exit\n");

        System.out.print("Your choice: ");
        String userAnswer = scanner.nextLine();

        return userAnswer;
    }
}
