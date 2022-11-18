package hexlet.code;

import java.util.Scanner;

public class Even {

    public static void start(int attempts, Scanner userInput) {

        var randomLowRange = 0;
        var randomHighRange = 1000;
        var userName = Cli.start(userInput);

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (var i = 0; i < attempts; i++) {
            var questionNumber = RandomGenerator.generateInt(randomLowRange, randomHighRange);
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

    // the function finds out whether passed value is an Even number
    public static String getCorrectAnswer(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
