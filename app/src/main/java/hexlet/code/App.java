// hexlet/code/App.java
package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        var userAnswer = UserDialog.start(userInput);
        final int numberOfAttempts = 3;

        switch (userAnswer) {
            case "1":
                Cli.start(userInput);
                break;
            case "2":
                Even.start(numberOfAttempts, userInput);
                break;
            case "3":
                Calc.start(numberOfAttempts, userInput);
                break;
            case "4":
                GCD.start(numberOfAttempts, userInput);
                break;
            case "5":
                Progression.start(numberOfAttempts, userInput);
                break;
            case "6":
                Prime.start(numberOfAttempts, userInput);
                break;
            default:
                break;
        }

    }
}
