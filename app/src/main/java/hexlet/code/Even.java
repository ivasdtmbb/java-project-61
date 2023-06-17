package hexlet.code;
import java.util.Scanner;

public class Even {
    public static void start(Scanner userInput, int attempts) {
        var userName = Cli.start(userInput);
        var randomLowRange = 0;
        var randomHighRange = 1000;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (var i = 0; i < attempts; i++) {
            var randomNumber = RandGen.generateInt(randomLowRange, randomHighRange);
            var correctAnswer = getCorrectAnswer(randomNumber);

            System.out.println("Question: " + String.valueOf(randomNumber));
            System.out.print("Your answer: ");
            var userAnswer = userInput.next();

            if (userAnswer.equals(correctAnswer)) {
                UserDialog.printCorrect();
            } else {
                UserDialog.printWrongAnswer(userAnswer, correctAnswer, userName);
                return;
            }
        }
        UserDialog.printWinner(userName);
    }

    private static String getCorrectAnswer(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }

}
