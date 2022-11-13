// hexlet/code/App.java
package hexlet.code;

public class App {
    public static void main(String[] args) {
        var userAnswer = UserDialog.start();
        var numberOfAttempts = 3;

        switch (userAnswer) {
            case "1":
                Cli.start();
                break;
            case "2":
                Even.start(numberOfAttempts);
                break;
            case "3":
                Calc.start(numberOfAttempts);
                break;
            default:
                break;
        }

    }
}
