package hexlet.code;

import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringJoiner;

public class Prime {

    public static void start(int attempts) {

        String primesListFile = "prime_numbers.txt"; // file with prime numbers

        var userName = Cli.start();
        var userInput = new Scanner(System.in);
        int[] primeNumbers = primesFromFile(primesListFile);
        int randomRange = primeNumbers[primeNumbers.length - 1]; //biggest value of our prime numbers table

        //System.out.println(Arrays.toString(primeNumbers)); // test

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        for (var i = 0; i < attempts; i++) {
            int question = RandomGenerator.generateInt(0, randomRange);
            var correctAnswerBool = ArrayUtils.contains(primeNumbers, question);
            var correctAnswerString = correctAnswerBool ? "yes" : "no";

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = userInput.next();

            if (userAnswer.equals(correctAnswerString)) {
                System.out.println("Correct!");
            } else {
                UserDialog.wrongAnswer(userAnswer,
                        correctAnswerString, userName);
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }

    public static int[] primesFromFile(String filename) {
        File primeNums = new File(filename);
        try {
            Scanner fileReader = new Scanner(primeNums);

            var primeNumsStringJoiner = new StringJoiner(" ");
            while (fileReader.hasNextLine()) {
                var line = fileReader.nextLine(); // read each line of the file with prime numbers
                var numStings = line.split(" "); // create a String[] with " " delimiter from the file's line
                for (var num : numStings) {
                    primeNumsStringJoiner.add(num); // append each number to String[] (primeNumsString)
                }
            }
            var primeNumsStrings = (primeNumsStringJoiner.toString()).split(" ");
            int[] primes = new int[primeNumsStrings.length];
            for (var i = 0; i < primes.length; i++) {
                primes[i] = Integer.parseInt(primeNumsStrings[i].trim());
            }
            fileReader.close();
            return primes;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return new int[0];
    }
}


