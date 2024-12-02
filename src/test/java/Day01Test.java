import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class Day01Test {

    @Test
    void firstTask() {
        final AdventDay day = new Day01();
        Assertions.assertEquals(day.firstTask(), 2031679);
    }

    @Test
    void secondTask() {
        final AdventDay day = new Day01();
        Assertions.assertEquals(day.secondTask(), 19678534);
    }
}