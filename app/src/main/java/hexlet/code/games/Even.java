package hexlet.code;

import java.util.Scanner;

public class Even {
    public static void start(Scanner userInput, int attempts) {
        var userName = Cli.start(userInput);
        var randomLowRange = 0;
        var randomHighRange = 1000;

        printGameInstructions();

        for (var i = 0; i < attempts; i++) {
            var randomNumber = RandGen.generateInt(randomLowRange, randomHighRange);

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
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }
    private static String getCorrectAnswer(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }

    private static String generateQuestionString(int randomNumber) {
        return String.valueOf(randomNumber);
    }
}
