package hexlet.code;

public class RandGen {
    public static int generateInt(int from, int randomRange) {
        return (int) (from + Math.round(Math.random() * randomRange));
    }

    public static int generateInt() {
        final int from = 0;
        final int randomRange = 1000;
        return (int) (from + Math.round(Math.random() * randomRange));
    }
}
