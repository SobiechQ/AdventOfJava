import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day02Test {

    @Test
    void firstTask() {
        final AdventDay day = new Day02();
        Assertions.assertEquals(day.firstTask(), 472);
    }

    @Test
    void secondTask() {
        final AdventDay day = new Day02();
        Assertions.assertEquals(day.secondTask(), 520);
    }
}