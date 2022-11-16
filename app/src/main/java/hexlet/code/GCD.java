package hexlet.code;

import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
import java.util.Scanner;

public class GCD {
    public static void start(int attempts) {
        var userName = Cli.start();
        var scanner = new Scanner(System.in);
        var randomRange = 100;
        int number1;
        int number2;
        int correctAnswer;

        System.out.println("Find the greatest common divisor of given numbers.");

        for (var i = 0; i < attempts; i++) {
	        number1 = RandomGenerator.generateInt(1, randomRange);
	        number2 = RandomGenerator.generateInt(1, randomRange);
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


    // getResult function returns a Greatest Common Denominator of two numbers

    public static int getResult(int number1, int number2) {
        int[] denominatorsOfNumber1 = getDenominators(number1);
        int[] denominatorsOfNumber2 = getDenominators(number2);
        // System.out.println("1: " + Arrays.toString(denominatorsOfNumber1)); // for testing
        // System.out.println("2: " + Arrays.toString(denominatorsOfNumber2)); // for testing

        for (var denominator: denominatorsOfNumber1) {
            if (ArrayUtils.contains(denominatorsOfNumber2, denominator)) {
                return denominator;
            }
        }
        return 1;
    }

    // getDenominators function returns all number's denominators (from biggest to lowest)

    public static int[] getDenominators(int number) {
	int[] denominators = new int[number];
	var index = 0;

	for (var i = number; i > 0; i--) {
	    if (number % i == 0) {
		denominators[index] = i;
		index++;
	    }
	}
	//int[] denomsForTestOutput = Arrays.copyOfRange(denominators, 0, index); // for testing
	//System.out.println(Arrays.toString(denomsForTestOutput)); // for testing
	return Arrays.copyOfRange(denominators, 0, index);
    }
}
