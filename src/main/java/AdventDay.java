import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public abstract class AdventDay {

    public abstract int firstTask();
    public abstract int secondTask();
    public abstract String getInputFileName();
    public List<String> lines() {
        try (final var reader = new BufferedReader(new FileReader("src/main/resources/"+this.getInputFileName()))) {
            return reader.lines().toList();
        } catch (Exception _) {
            return List.of();
        }
    }


}
