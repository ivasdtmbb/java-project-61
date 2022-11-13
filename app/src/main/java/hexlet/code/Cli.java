package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static String start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = String.valueOf(scanner.nextLine());
        System.out.println("Hello, " + userName + "!");

        return userName;
    }
}
