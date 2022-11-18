package hexlet.code;

public class Prime {

    public static void start(int attempts) {

        var randomLowRange = 0;
        var randomHighRange = 4000;
        var userName = Cli.start();

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        for (var i = 0; i < attempts; i++) {
            int isPrimeNumber = RandomGenerator.generateInt(randomLowRange, randomHighRange);
            var correctAnswer = isCorrectAnswer(isPrimeNumber);

            if (UserDialog.gameDialog(String.valueOf(isPrimeNumber), String.valueOf(correctAnswer), userName)) {
                UserDialog.correct();
            } else {
                return;
            }
        }
        UserDialog.winner(userName);
    }

    public static String isCorrectAnswer(int number) {
        var index = 0;

        for (var i = number; i > 0; i--) {
            if (number % i == 0) {
                index++;
            }
        }
        // the int number is prime if it divides twice - on itself and 1 //
        return index == 2 ? "yes" : "no";
    }
}

