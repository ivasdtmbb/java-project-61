package hexlet.code;

import java.util.Scanner;

public class Progression {

    public static void start(Scanner userInput, int attempts) {
        var userName = Cli.start(userInput);
        var randomLowRange = 0;
        var randomHighRange = 20;
        var progressionLength = 10;

        printGameInstructions();

        for (var i = 0; i < attempts; i++) {
            int[] progressionElements = generateProgressionElements(progressionLength, randomLowRange, randomHighRange);
            var missedElementPosition = RandGen.generateInt(randomLowRange, progressionLength - 1);

            String correctAnswer = String.valueOf(getCorrectAnswer(progressionElements, missedElementPosition));
            String question = generateQuestionString(progressionElements, missedElementPosition);

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
        System.out.println("What number is missing in the progression?");
    }

    private static int getCorrectAnswer(int[] progressionElements, int missedElementPosition) {
        return progressionElements[missedElementPosition];
    }

    private static String generateQuestionString(int[] progressionElements, int missedElementPosition) {
        var question = new StringBuilder();
        for (int i = 0; i < progressionElements.length; i++) {
            if (i == missedElementPosition) {
                question.append(".. ");
            } else {
                question.append(String.valueOf(progressionElements[i]) + " ");
            }
        }
        return question.toString();
    }

    private static int[] generateProgressionElements(int progressionLength, int randomLowRange, int randomHighRange) {
        var firstElement = RandGen.generateInt(randomLowRange, randomHighRange);
        var pitch = RandGen.generateInt(randomLowRange, randomHighRange);
        int[] progression = new int[progressionLength];

        for (int i = 0; i < progressionLength; i++) {
            progression[i] = firstElement + (i * pitch);
        }
        return progression;
    }
}

