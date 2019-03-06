import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DevNexusRefactored {

    public static void main(String... args) throws IOException {
        var devNexus = new DevNexusRefactored();
        devNexus.fileProcessing();
    }

    private void fileProcessing() throws IOException {
        var path = Paths.get("temps.txt");
        var lines = Files.readAllLines(path, Charset.defaultCharset());
        if (! lines.isEmpty()) {
            var first = Double.parseDouble(lines.get(0));
            var min = first;
            var max= first;
            var sum = 0;
            for (var i = 1; i< lines.size(); i++) {
                double current = Double.parseDouble(lines.get(i));
                min = Math.min(min, current);
                max = Math.max(max, current);
                sum += current;
            }
            var average = sum/lines.size();
            System.out.println("Min: " + min);
            System.out.println("Max: " + max);
            System.out.println("Avg: " + average);
        }
    }
}
