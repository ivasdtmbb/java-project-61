package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static void runGamesEngine() {
        Scanner userInput = new Scanner(System.in);
        var gameChoice = Engine.menu(userInput);
        chooseGame(userInput, gameChoice);
    }
    public static void chooseGame(Scanner userInput, String gameChoice) {
        final int numberOfAttempts = 3;

        switch (gameChoice) {
            case "1":
                Cli.start(userInput);
                break;
            case "2":
                Even.start(userInput, numberOfAttempts);
                break;
            case "3":
                Calc.start(userInput, numberOfAttempts);
                break;
            case "4":
                GCD.start(userInput, numberOfAttempts);
                break;
            case "5":
                Progression.start(userInput, numberOfAttempts);
                break;
            case "6":
                Prime.start(userInput, numberOfAttempts);
                break;
            default:
                break;
        }
        userInput.close();
    }
    public static String menu(Scanner userInput) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.print("1 - Greet\n"
                + "2 - Even\n"
                + "3 - Calc\n"
                + "4 - GCD\n"
                + "5 - Progression\n"
                + "6 - Prime\n"
                + "0 - Exit\n");

        System.out.print("Your choice: ");
        String choise = userInput.next();
        System.out.println();

        return choise;
    }

    public static String getUserAnswer(String question, Scanner userInput) {
        System.out.println("Question: " + question);
        System.out.print("Your answer: ");
        var userAnswer = userInput.next();

        return userAnswer;
    }
    public static void printCorrect() {
        System.out.println("Correct!");
    }

    public static void printWinner(String userName) {
        System.out.println("Congratulations, " + userName + "!");
    }

    public static void printWrongAnswer(String userAnswer, String correctAnswer, String userName) {
        String message = String.format(
                "'%s' is wrong answer ;(. Correct answer was '%s'.\n"
                        + "Let's try again, %s!",
                        userAnswer,
                        correctAnswer,
                        userName
                        );
        System.out.println(message);
    }
}
