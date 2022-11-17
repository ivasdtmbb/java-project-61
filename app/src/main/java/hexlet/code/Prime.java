package hexlet.code;

import java.util.Scanner;

public class Prime {

    public static void start(int attempts) {

        var randomLowRange = 0;
        var randomHighRange = 4000;
        var userName = Cli.start();
        var userInput = new Scanner(System.in);

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        for (var i = 0; i < attempts; i++) {
            int question = RandomGenerator.generateInt(randomLowRange, randomHighRange);
            var correctAnswerString = correctAnswer(question) ? "yes" : "no";

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = userInput.next();

            if (userAnswer.equals(correctAnswerString)) {
                System.out.println("Correct!");
            } else {
                UserDialog.wrongAnswer(userAnswer,
                        correctAnswerString, userName);
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }

    public static Boolean correctAnswer(int number) {
        int[] denominators = new int[number];
        var index = 0;

        for (var i = number; i > 0; i--) {
            if (number % i == 0) {
                denominators[index] = i;
                index++;
            }
        }

        return index == 2;
    }
}

