package lesson1;

public class Orange extends Fruits {

    private static final float WEIGHT = 1.5f;

    public Orange() {
        super(WEIGHT);
    }

    public static float getWEIGHT() {
        return WEIGHT;
    }
}
