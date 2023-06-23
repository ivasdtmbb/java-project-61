package hexlet.code;

import java.util.Scanner;

public class Prime {
    public static void start(Scanner userInput, int attempts) {
        var userName = Cli.start(userInput);

        printGameInstructions();

        for (var i = 0; i < attempts; i++) {
            var randomNumber = RandGen.generateInt();

            var correctAnswer = getCorrectAnswer(randomNumber);
            String question = generateQuestionString(randomNumber);

            var userAnswer = Engine.getUserAnswer(question, userInput);

            if (userAnswer.equals(correctAnswer)) {
                Engine.printCorrect();
            } else {
                Engine.printWrongAnswer(userAnswer, correctAnswer, userName);
                return;
            }
        }
        Engine.printWinner(userName);
    }

    private static void printGameInstructions() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }
    private static String getCorrectAnswer(int number) {
        if (number == 1) {
            return "yes";
        }

        var counter = 0;
        for (int i = number; i > 0; i--) {
            if (number % i == 0) {
                counter++;
            }
        }
        return counter == 2 ? "yes" : "no";
    }

    private static String generateQuestionString(int randomNumber) {
        return String.valueOf(randomNumber);
    }
}
