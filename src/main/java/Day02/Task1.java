package Day02;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Task1 {
    public static void main(String[] args) {
        try(final var reader = new BufferedReader(new FileReader("src/main/java/Day02/input.txt"))) {
            final var count = reader.lines()
                    .map(s-> Arrays.stream(s.split(" ")))
                    .map(ss -> ss.map(Integer::parseInt).toList())
                    .map(Task1::isSafe)
                    .filter(b->b)
                    .count();
            System.out.println(count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isSafe(List<Integer> reports) {
        final var queue = new ArrayDeque<>(reports);
        final var last = Optional.ofNullable(queue.poll());
        return last.map(l -> {
                    final var isIncreasing = Optional.ofNullable(queue.peek()).map(p -> p > l).orElse(false);
                    return Task1.next(queue, l, isIncreasing);
                }
        ).orElse(true);
    }

    private static boolean next(Queue<Integer> reports, int last, boolean isIncreasing){
        final var current = Optional.ofNullable(reports.poll());
        return current.map(c -> {
            final var delta = Math.abs(c - last);
            final var check = isIncreasing ? c > last : c < last;
            return delta >= 1 && delta <= 3 && check && Task1.next(reports, c, isIncreasing);
        }).orElse(true);
    }
}
