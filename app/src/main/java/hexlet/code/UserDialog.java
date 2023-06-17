package hexlet.code;
import java.util.Scanner;

public class UserDialog {
    public static String start(Scanner userInput) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.print("1 - Greet\n"
                + "2 - Even\n"
                + "0 - Exit\n");

        System.out.print("Your choice: ");
        String choise = userInput.next();
        System.out.println();

        return choise;
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
