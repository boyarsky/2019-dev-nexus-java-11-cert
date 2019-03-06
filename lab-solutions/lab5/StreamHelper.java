import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamHelper {

    public static void main(String... args) throws IOException {
        System.out.println(makeStream("test").count());
        System.out.println(makeStream(null).count());
        System.out.println();
        blastOff();
        System.out.println();
        odds();
        System.out.println();
        beforeSixCharacterWord();
        System.out.println();
        firstSixCharacterWord();
        System.out.println();
        firstSixCharacterWordAndThreeMore();
        System.out.println();
        randomFirstEvens();
        System.out.println();
        randomFirstHalf();
    }

    public static Stream<String> makeStream(String str) {
        return Stream.ofNullable(str);
    }

    public static void blastOff() {
        Stream.iterate(10, i -> i >= 0, i -> i - 1)
                .forEach(System.out::println);
        System.out.println("Blast off!");
    }

    public static void odds() {
        Stream.iterate(1, i -> i + 2)
                .skip(39)
                .limit(1)
                .forEach(System.out::println);
    }

    public static void beforeSixCharacterWord() throws IOException {
        Path path = Paths.get("sentences.txt");
        String text = new String(Files.readAllBytes(path));
        Pattern.compile("\\s+").splitAsStream(text)
                .takeWhile(word -> word.length() < 6)
                .forEach(System.out::println);

    }

    public static void firstSixCharacterWord() throws IOException {
        Path path = Paths.get("sentences.txt");
        String text = new String(Files.readAllBytes(path));
        Pattern.compile("\\s+").splitAsStream(text)
                .dropWhile(word -> word.length() < 6)
                .limit(1)
                .forEach(System.out::println);

    }

    public static void firstSixCharacterWordAndThreeMore() throws IOException {
        Path path = Paths.get("sentences.txt");
        String text = new String(Files.readAllBytes(path));
        Pattern.compile("\\s+").splitAsStream(text)
                .dropWhile(word -> word.length() < 6)
                .limit(4)
                .forEach(System.out::println);

    }

    public static void randomFirstEvens() {
        Random random = new Random();
        Stream.generate(() -> random.nextInt(1000) + 1)
                .takeWhile(num -> num % 2 == 0)
                .forEach(System.out::println);

    }

    public static void randomFirstHalf() {
        Random random = new Random();
        Stream.generate(() -> random.nextInt(100) + 1)
                .limit(10)
                .dropWhile(num -> num > 50)
                .forEach(System.out::println);

    }
}
