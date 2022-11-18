package hexlet.code;

import java.util.Scanner;

public class Calc {

    public static void start(int attempts, Scanner userInput) {

        var randomLowRange = 0;
        var randomHighRange = 100;
        var userName = Cli.start(userInput);

        char[] operators = {'*', '-', '+'};

        System.out.println("What is the result of the expression?");

        for (var i = 0; i < attempts; i++) {
            var number1 = RandomGenerator.generateInt(randomLowRange, randomHighRange);
            var number2 = RandomGenerator.generateInt(randomLowRange, randomHighRange);
            var operator = operators[RandomGenerator.generateInt(0, operators.length - 1)];

            var question = getQuestionString(operator, number1, number2);
            var correctAnswer = getCorrectAnswer(operator, number1, number2);

            if (UserDialog.gameDialog(String.valueOf(question), String.valueOf(correctAnswer),
                    userName, userInput)) {
                UserDialog.printCorrect();
            } else {
                return;
            }
        }
        UserDialog.printWinner(userName);
    }

    public static int getCorrectAnswer(char operator, int number1, int number2) {
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

    public static String getQuestionString(char operator, int number1, int number2) {
        return String.valueOf(number1) + " " + operator + " " + String.valueOf(number2);
    }
}
