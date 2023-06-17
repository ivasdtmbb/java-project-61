package hexlet.code;

public class RandGen {
    public static int generateInt(int from, int randomRange) {
        return (int) (from + Math.round(Math.random() * randomRange));
    }
}
