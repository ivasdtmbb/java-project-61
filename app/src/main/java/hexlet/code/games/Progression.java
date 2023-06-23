package hexlet.code;

import java.util.Scanner;

public class Progression {

    public static void start(Scanner userInput, int attempts) {
        var userName = Cli.start(userInput);
        final int randomLowRange = 0;
        final int randomHighRange = 20;
        final int progressionLength = 10;

        printGameInstructions();

        for (var i = 0; i < attempts; i++) {
            var firstElement = RandGen.generateInt(randomLowRange, randomHighRange);
            var pitch = RandGen.generateInt(randomLowRange, randomHighRange);
            var missedElementPosition = RandGen.generateInt(randomLowRange, progressionLength - 1);

            String correctAnswer = String.valueOf(getCorrectAnswer(firstElement, pitch, missedElementPosition));
            String question = generateQuestionString(firstElement, pitch, progressionLength, missedElementPosition);

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

    private static int getCorrectAnswer(int firstElement, int pitch, int missedElementPosition) {
        return (firstElement + missedElementPosition * pitch);
    }

    private static String generateQuestionString(int firstEl, int pitch, int progressionLen, int missedElementPos) {
        var question = new StringBuilder();
        for (int i = 0; i < progressionLen; i++) {
            if (i == missedElementPos) {
                question.append(".. ");
            } else {
                question.append(String.valueOf(firstEl + i * pitch) + " ");
            }
        }
        return question.toString();
    }
}

