import java.util.Random;

public interface Lab1Interface {

    default int getRandomNumberTickets(int max) {
        Random random = new Random();
        return random.nextInt(max) + 1;
    }

    default int getNumberStrikes() {
        Random random = new Random();
        return random.nextInt(4);
    }
}
