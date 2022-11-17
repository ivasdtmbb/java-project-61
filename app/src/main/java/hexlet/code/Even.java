package hexlet.code;

import java.util.Scanner;

public class Even {

    public static void start(int attempts) {
        var userName = Cli.start();
        String correctAnswer;
        Scanner scanner = new Scanner(System.in);
        var randomRange = 1000;

        System.out.println("Answer 'yes' if number is even otherwise answer 'no'.");

        for (var i = 0; i < attempts; i++) {

            var randNumber = RandomGenerator.generateLong(randomRange);

            correctAnswer = getResult(randNumber);

            System.out.println("Question: " + randNumber);
            System.out.print("Your Answer: ");
            String userAnswer = scanner.next();

            if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                UserDialog.wrongAnswer(userName, correctAnswer, userName);
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }

    public static String getResult(long randNumber) {
        if (randNumber % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }
}
