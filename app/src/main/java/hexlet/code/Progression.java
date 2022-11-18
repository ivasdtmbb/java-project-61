package hexlet.code;

import java.util.Scanner;

public class Progression {

    public static void start(int attempts, Scanner userInput) {

        var userName = Cli.start(userInput);

        System.out.println("What number is missing in the progression?");

        for (var i = 0; i < attempts; i++) {

            int[] progressionNumbers = generateProgression();
            var missedPosition = RandomGenerator.generateInt(0, progressionNumbers.length - 1);

            var question = getQuestionString(progressionNumbers, missedPosition);
            var correctAnswer = progressionNumbers[missedPosition];

            if (UserDialog.gameDialog(String.valueOf(question), String.valueOf(correctAnswer),
                    userName, userInput)) {
                UserDialog.printCorrect();
            } else {
                return;
            }
        }
        UserDialog.printWinner(userName);
    }

    // generateProgression() function generates and returns an arithmetic progression
    public static int[] generateProgression() {
        var randomLowRange = 1;
        var randomHighRange = 20; // for progression pitch generating
        var progressionLengthFrom = 5;
        var progressionLengthTo = 7;

        // progression length would be in range 5 - 12 items
        var progressionLength = RandomGenerator.generateInt(progressionLengthFrom, progressionLengthTo);
        var progressionStartValue = RandomGenerator.generateInt(randomLowRange, randomHighRange);
        var progressionPitch = RandomGenerator.generateInt(randomLowRange, randomHighRange);

        int[] newProgression = new int[progressionLength];
        newProgression[0] = progressionStartValue;

        for (var i = 1; i < progressionLength; i++) {
            newProgression[i] = newProgression[i - 1] + progressionPitch;
        }
        return newProgression;
    }

    // getQuestionString returns a progression String with a missed number
    public static String getQuestionString(int[] progression, int missedPosition) {
        var progressionString = new StringBuilder();
        var progressionLength = progression.length;
        for (var i = 0; i < progressionLength; i++) {
            if (i != missedPosition) {
                progressionString.append(progression[i]);
                progressionString.append(" ");
            } else {
                progressionString.append(".. ");
            }
        }
        return progressionString.toString();
    }
}

