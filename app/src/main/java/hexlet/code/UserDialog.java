package hexlet.code;

import java.util.Scanner;

public class UserDialog {
    public static String start() {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.print("1 - Greet\n"
                + "2 - Even\n"
                + "3 - Calc\n"
                + "4 - GCD\n"
                + "5 - Progression\n"
                + "6 - Prime\n"
                + "0 - Exit\n");

        System.out.print("Your choice: ");
        var choice = userInput.nextLine();
        System.out.println();

        return choice;

    }

    public static void wrongAnswer(String userAnswer, String correctAnswer, String userName) {
        String message = String.format(
                "'%s' is wrong answer ;(. Correct answer was '%s'.\n"
                        + "Let's try again, %s!",
                userAnswer,
                correctAnswer,
                userName
        );
        System.out.println(message);
    }

    public static void winner(String userName) {
        System.out.println("Congratulations, " + userName + "!");
    }

    public static boolean gameDialog(String question, String correctAnswer, String userName) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Question: " + question);
        System.out.print("Your answer: ");
        String userAnswer = userInput.next();

        userInput.close();

        if (userAnswer.equals(correctAnswer)) {
            return true;
        } else {
            wrongAnswer(userAnswer, correctAnswer, userName);
            return false;
        }
    }

    public static void correct() {
        System.out.println("Correct!");
    }
}
