package hexlet.code;

import java.util.Scanner;

public class Calc {
    public static void start(Scanner userInput, int attempts) {
        var userName = Cli.start(userInput);
        final int randomLowRange = 0;
        final int randomHighRange = 100;

        char[] operators = {'*', '-', '+'};
        printGameInstructions();

        for (var i = 0; i < attempts; i++) {
            var number1 = RandGen.generateInt(randomLowRange, randomHighRange);
            var number2 = RandGen.generateInt(randomLowRange, randomHighRange);
            var operator = operators[RandGen.generateInt(0, operators.length - 1)];

            String correctAnswer = String.valueOf(getCorrectAnswer(number1, number2, operator));
            String question = generateQuestionString(number1, number2, operator);

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
        System.out.println("What is the result of the expression?");
    }

    private static int getCorrectAnswer(int number1, int number2, char operator) {
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

    private static String generateQuestionString(int number1, int number2, char operator) {
        return String.valueOf(number1) + " " + operator + " " + String.valueOf(number2);
    }
}
