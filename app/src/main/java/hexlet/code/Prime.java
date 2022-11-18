package hexlet.code;

import java.util.Scanner;

public class Prime {

    public static void start(int attempts, Scanner userInput) {

        final var randomLowRange = 0;
        final var randomHighRange = 4000;
        var userName = Cli.start(userInput);

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        for (var i = 0; i < attempts; i++) {
            int questionNumber = RandomGenerator.generateInt(randomLowRange, randomHighRange);
            var correctAnswer = getCorrectAnswer(questionNumber);

            if (UserDialog.gameDialog(String.valueOf(questionNumber), String.valueOf(correctAnswer),
                    userName, userInput)) {
                UserDialog.printCorrect();
            } else {
                return;
            }
        }
        UserDialog.printWinner(userName);
    }

    // the function finds out whether passed value is a Prime number
    public static String getCorrectAnswer(int number) {
        var index = 0;

        for (var i = number; i > 0; i--) {
            if (number % i == 0) {
                index++;
            }
        }
        // the int number is prime if it divides twice - on itself and 1 //
        return index == 2 ? "yes" : "no";
    }
}

