package hexlet.code;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        var userAnswer = Cli.start(userInput);

        userInput.close();
    }
}
