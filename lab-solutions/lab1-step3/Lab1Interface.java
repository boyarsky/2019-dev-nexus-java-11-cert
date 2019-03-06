import java.util.Random;

public interface Lab1Interface {

    default int getRandomNumberTickets(int max) {
        return getRandom(0, max);
    }

    default int getNumberStrikes() {
        return getRandom(0, 3);
    }

    private int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min + 1;
    }
}
