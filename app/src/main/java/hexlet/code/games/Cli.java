// Cli.java class asks and returns a Username
package hexlet.code;
import java.util.Scanner;

public class Cli {
    public static String start(Scanner userInput) {

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = userInput.next();
        System.out.println("Hello, " + userName + "!");

        return userName;
    }
}
