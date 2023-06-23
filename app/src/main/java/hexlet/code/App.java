package hexlet.code;


import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        var userAnswer = Engine.menu(userInput);

        Engine.processUserAnswer(userInput, userAnswer);
    }
}
