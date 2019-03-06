import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListUtils {

    public static List<Integer> randomInts() {
        System.out.println("Java 11 version");
        var random = new Random();
        var array = Stream.generate(random::nextInt)
                .limit(10)
                .toArray(Integer[]::new);
        return List.of(array);
    }

    public static void main(String... args) {
        System.out.println(randomInts());
    }
}
