package hexlet.code;

import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;
import java.util.Scanner;

public class GCD {
    public static void start(int attempts, Scanner userInput) {

        var randomLowRange = 1;
        var randomHighRange = 100;
        var userName = Cli.start(userInput);

        System.out.println("Find the greatest common divisor of given numbers.");

        for (var i = 0; i < attempts; i++) {
            var number1 = RandomGenerator.generateInt(randomLowRange, randomHighRange);
            var number2 = RandomGenerator.generateInt(randomLowRange, randomHighRange);

            var question = getQuestionString(number1, number2);
            var correctAnswer = getCorrectAnswer(number1, number2);

            if (UserDialog.gameDialog(String.valueOf(question), String.valueOf(correctAnswer),
                    userName, userInput)) {
                UserDialog.printCorrect();
            } else {
                return;
            }
        }
        UserDialog.printWinner(userName);
    }

    // getCorrectAnswer function returns the Greatest Common Denominator of two numbers
    public static int getCorrectAnswer(int number1, int number2) {
        int[] denominatorsOfNumber1 = getDenominators(number1);
        int[] denominatorsOfNumber2 = getDenominators(number2);

        for (var denominator: denominatorsOfNumber1) {
            if (ArrayUtils.contains(denominatorsOfNumber2, denominator)) {
                return denominator;
            }
        }
        return 1;
    }

    // getDenominators returns an array int[] of the number's denominators
    public static int[] getDenominators(int number) {
        int[] denominators = new int[number];
        var index = 0;

        for (var i = number; i > 0; i--) {
            if (number % i == 0) {
                denominators[index] = i;
                index++;
            }
        }
        return Arrays.copyOfRange(denominators, 0, index);
    }

    public static String getQuestionString(int number1, int number2) {
        return String.valueOf(number1) + " " + String.valueOf(number2);
    }
}
