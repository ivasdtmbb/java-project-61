package hexlet.code;

import java.math.BigInteger;
import java.util.Scanner;

public class GCD {
    public static void start(Scanner userInput, int attempts) {
        var userName = Cli.start(userInput);
        final int randomLowRange = 0;
        final int randomHighRange = 100;

        printGameInstructions();

        for (var i = 0; i < attempts; i++) {
            var number1 = RandGen.generateInt(randomLowRange, randomHighRange);
            var number2 = RandGen.generateInt(randomLowRange, randomHighRange);

            String correctAnswer = String.valueOf(getCorrectAnswer(number1, number2));
            String question = generateQuestionString(number1, number2);

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
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    private static BigInteger getCorrectAnswer(int number1, int number2) {
        var bigInt1 = new BigInteger(String.valueOf(number1));
        var bigInt2 = new BigInteger(String.valueOf(number2));
        var gcd = bigInt1.gcd(bigInt2);
        return gcd;
    }

    private static String generateQuestionString(int number1, int number2) {
        return String.valueOf(number1) + " " + String.valueOf(number2);
    }
}
