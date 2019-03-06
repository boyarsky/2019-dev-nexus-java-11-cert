
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Speakers {

    public static void main(String... args) throws IOException {
        var speakers = new Speakers();
        speakers.fileProcessing();
    }

    private void fileProcessing() throws IOException {
        Path path = Paths.get("speakers.txt");
        String text = new String(Files.readAllBytes(path));
        String firstAlphabetical = text.lines()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalStateException("No names found"));

        System.out.println("First name alphabetical: " + firstAlphabetical);
        String lastAlphabetical = text.lines()
                .max(this::compareByLastName)
                .orElseThrow(() -> new IllegalStateException("No names found"));
        System.out.println("Last name alphabetical: " + lastAlphabetical);

        String longestName = text.lines()
                .max(Comparator.comparing(String::length).reversed())
                .orElseThrow(() -> new IllegalStateException("No names found"));
        System.out.println("I love DevNexus!\n".repeat(10) + longestName);

        String[] lines = text.lines().toArray(String[]::new);
        List<String> backed = Arrays.asList(lines);
        //backed.add("bad");
        //backed.remove(0);
        backed.set(0, "new");

        List<Integer> immutable = List.of(1,2 ,3);
        //immutable.add(1);
        //immutable.remove(1);
        //immutable.set(0, 7);

    }

    private int compareByLastName(String s1, String s2) {
        String[] split1 = s1.split(",");
        String[] split2 = s2.split(",");
        return split1[1].compareTo(split2[1]);
    }
}
