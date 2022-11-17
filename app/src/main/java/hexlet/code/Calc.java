package hexlet.code;

import java.util.Scanner;

public class Calc {

    public static void start(int attempts) {
        var userName = Cli.start();
        var scanner = new Scanner(System.in);
        var randomLowRange = 0;
        var randomHighRange = 100;
        int number1;
        int number2;
        int correctAnswer;
        char[] operators = {'*', '-', '+'};
        char operator;

        System.out.println("What is the result of the expression?");

        for (var i = 0; i < attempts; i++) {
            operator = operators[RandomGenerator.generateInt(0, operators.length - 1)];
            number1 = RandomGenerator.generateInt(randomLowRange, randomHighRange);
            number2 = RandomGenerator.generateInt(randomLowRange, randomHighRange);
            correctAnswer = getResult(number1, number2, operator);

            System.out.println("Question: " + number1 + " " + operator + " " + number2);
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

    public static int getResult(int number1, int number2, char operator) {
        switch (operator) {
            case '*':
                return number1 * number2;
            case '-':
                return number1 - number2;
            case '+':
                return number1 + number2;
            default:
                break;
        }
        return 0;
    }
}
