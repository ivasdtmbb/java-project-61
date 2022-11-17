package hexlet.code;

import java.util.Scanner;

public class Progression {



    public static void start(int attempts) {
        var userName = Cli.start();
        var scanner = new Scanner(System.in);
        var randomRange = 20; // for progression pitch generating
        int correctAnswer;

        System.out.println("What number is missing in the progression?");

        for (var i = 0; i < attempts; i++) {
            var progressionLength = RandomGenerator.generateInt(5, 7); // the length would be in range 5 - 12 items
            var progressionStart = RandomGenerator.generateInt(1, randomRange);
            var progressionPitch = RandomGenerator.generateInt(1, randomRange);
            var missedPosition = RandomGenerator.generateInt(0, progressionLength - 1);

            // System.out.println("Length: " + progressionLength + " Start: " + progressionStart
            //        + " Pitch: " + progressionPitch + " Missed pos.: " + missedPosition); // for testing

            int[] newProgression = generateProgression(progressionStart,
                    progressionPitch, progressionLength);

            correctAnswer = newProgression[missedPosition];

            System.out.println("Question: " + progressionToString(newProgression, missedPosition));
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

    public static int[] generateProgression(int progressionStart, int progressionPitch,
                                            int progressionLength) {
        int[] newProgression = new int[progressionLength];
        newProgression[0] = progressionStart;

        for (var i = 1; i < progressionLength; i++) {
            newProgression[i] = newProgression[i - 1] + progressionPitch;
        }

        // System.out.println(Arrays.toString(newProgression)); // for testing
        return newProgression;
    }

    public static String progressionToString(int[] newProgression, int missedPosition) {
        var progressionString = new StringBuilder();
        var prLength = newProgression.length;
        for (var i = 0; i < prLength; i++) {
            if (i != missedPosition) {
                progressionString.append(newProgression[i]);
                progressionString.append(" ");
            } else {
                progressionString.append(".. ");
            }
        }
        return progressionString.toString();
    }
}
