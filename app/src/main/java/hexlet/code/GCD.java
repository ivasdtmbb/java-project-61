package hexlet.code;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Scanner;

public class GCD {
    public static void start(int attempts) {
        var userName = Cli.start();
        var scanner = new Scanner(System.in);
        var randomLowRange = 1;
        var randomHighRange = 100;
        int number1;
        int number2;
        int correctAnswer;

        System.out.println("Find the greatest common divisor of given numbers.");

        for (var i = 0; i < attempts; i++) {
            number1 = RandomGenerator.generateInt(randomLowRange, randomHighRange);
            number2 = RandomGenerator.generateInt(randomLowRange, randomHighRange);
            correctAnswer = getResult(number1, number2);

            System.out.println("Question: " + number1 + " " + number2);
            System.out.print("Your answer: ");
            int userAnswer = Integer.parseInt(scanner.next());

            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
            } else {
                UserDialog.wrongAnswer(String.valueOf(userAnswer),
                        String.valueOf(correctAnswer), userName);
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }


    // getResult function returns Greatest Common Denominator of two numbers

    public static int getResult(int number1, int number2) {
        int[] denominatorsOfNumber1 = getDenominators(number1);
        int[] denominatorsOfNumber2 = getDenominators(number2);

        for (var denominator: denominatorsOfNumber1) {
            if (ArrayUtils.contains(denominatorsOfNumber2, denominator)) {
                return denominator;
            }
        }
        return 1;
    }

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
}
