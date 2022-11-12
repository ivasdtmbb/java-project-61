package hexlet.code;

import java.util.Scanner;

public class Even {

    public static void start() {
        var userName = Cli.chat();
        Scanner scanner = new Scanner(System.in);
        var randomRange = 1000;
        var attempts = 3;

        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");

        for (var i = 0; i < attempts; i++) {

            var randNumber = Math.round(Math.random() * randomRange);
            String correctAnswer;

            if (randNumber % 2 == 0) {
                correctAnswer = "yes";
            } else {
                correctAnswer = "no";
            }

            System.out.println("Question: " + randNumber);
            System.out.print("Your Answer: ");
            String userAnswer = scanner.next();

            if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Correct!");
            } else {

                String message = String.format(
                        "'%s' is wrong answer ;(. Correct answer was '%s'.\n"
                        + "Let's try again, %s!",
                        userAnswer,
                        correctAnswer,
                        userName
                );
                System.out.println(message);
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
