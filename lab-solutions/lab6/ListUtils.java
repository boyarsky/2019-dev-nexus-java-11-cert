import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListUtils {

    public static List<Integer> randomInts() {
        System.out.println("Java 8 version");
        Random random = new Random();
        return Stream.generate(random::nextInt)
                .limit(10)
                .collect(Collectors.toList());
    }

    public static void main(String... args) {
        System.out.println(randomInts());
    }
}
