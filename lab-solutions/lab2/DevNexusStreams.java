import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.OptionalDouble;

public class DevNexusStreams {

    public static void main(String... args) throws IOException {
        var devNexus = new DevNexusStreams();
        devNexus.fileProcessing();
    }

    private void fileProcessing() throws IOException {
        Path path = Paths.get("temps.txt");
        OptionalDouble max = Files.lines(path)
                .mapToDouble(Double::parseDouble)
                .max();
        OptionalDouble min = Files.lines(path)
                .mapToDouble(Double::parseDouble)
                .min();
        OptionalDouble avg = Files.lines(path)
                .mapToDouble(Double::parseDouble)
                .average();

        min.ifPresent(d -> System.out.println("Min: " + d));
        max.ifPresent(d -> System.out.println("Max: " + d));
        avg.ifPresent(d -> System.out.println("Avg: " + d));

    }
}
