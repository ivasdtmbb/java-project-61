package hexlet.code;

public class RandomGenerator {

    public static long generateLong(int randomRange) {

        return Math.round(Math.random() * randomRange);
    }

    public static int generateInt(int randomRange) {
        return (int) Math.round(Math.random() * randomRange);
    }
}
