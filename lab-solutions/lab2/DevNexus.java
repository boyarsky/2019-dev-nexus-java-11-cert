import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DevNexus {

    public static void main(String... args) throws IOException {
        DevNexus devNexus = new DevNexus();
        devNexus.fileProcessing();
    }

    private void fileProcessing() throws IOException {
        Path path = Paths.get("temps.txt");
        List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
        if (! lines.isEmpty()) {
            double first = Double.parseDouble(lines.get(0));
            double min = first;
            double max= first;
            double sum = 0;
            for (int i = 1; i< lines.size(); i++) {
                double current = Double.parseDouble(lines.get(i));
                min = Math.min(min, current);
                max = Math.max(max, current);
                sum += current;
            }
            double average = sum/lines.size();
            System.out.println("Min: " + min);
            System.out.println("Max: " + max);
            System.out.println("Avg: " + average);
        }
    }
}
