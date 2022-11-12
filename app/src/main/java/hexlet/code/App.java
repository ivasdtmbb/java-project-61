// hexlet/code/App.java
package hexlet.code;

public class App {
    public static void main(String[] args) {
        var userAnswer = StartMenu.start();

        switch (userAnswer) {
            case "1":
                Cli.chat();
                break;
            case "2":
                Even.start();
            default:
                break;
        }

    }
}
