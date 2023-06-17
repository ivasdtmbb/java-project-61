package hexlet.code;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        var numberOfAttempts = 3;
        var userAnswer = UserDialog.start(userInput);

        switch (userAnswer) {
            case "1":
                Cli.start(userInput);
                userInput.close();
                break;
            case "2":
                Even.start(userInput, numberOfAttempts);
                userInput.close();
                break;
            default:
                break;
        }


    }
}
