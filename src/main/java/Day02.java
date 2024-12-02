import java.util.*;
import java.util.stream.IntStream;

public class Day02 extends AdventDay {

    @Override
    public int firstTask() {
        return (int) this.lines().stream()
                .map(s-> Arrays.stream(s.split(" ")))
                .map(ss -> ss.map(Integer::parseInt).toList())
                .map(Day02::isSafeWithoutDamper)
                .filter(b->b)
                .count();
    }

    @Override
    public int secondTask() {
        return (int) this.lines().stream()
                .map(s-> Arrays.stream(s.split(" ")))
                .map(ss -> ss.map(Integer::parseInt).toList())
                .map(Day02::isSafeWithDamper)
                .filter(b->b)
                .count();
    }

    protected static boolean isSafeWithoutDamper(List<Integer> reports) {
        final var queue = new ArrayDeque<>(reports);
        final var last = Optional.ofNullable(queue.poll());
        return last.map(l -> {
                    final var isIncreasing = Optional.ofNullable(queue.peek()).map(p -> p > l).orElse(false);
                    return Day02.next(queue, l, isIncreasing);
                }
        ).orElse(true);
    }

    protected static boolean isSafeWithDamper(List<Integer> reports) {
        return Day02.isSafeWithoutDamper(reports) || Day02.isAnySafe(reports);
    }

    protected static boolean isAnySafe(List<Integer> reports) {
        return IntStream.range(0, reports.size())
                .mapToObj(i -> {
                    final var copy = new LinkedList<>(reports);
                    copy.remove(i);
                    return copy;
                })
                .anyMatch(Day02::isSafeWithoutDamper);
    }

    protected static boolean next(Queue<Integer> reports, int last, boolean isIncreasing) {
        final var current = Optional.ofNullable(reports.poll());
        return current.map(c -> {
            final var delta = Math.abs(c - last);
            final var check = isIncreasing ? c > last : c < last;
            return delta >= 1 && delta <= 3 && check && Day02.next(reports, c, isIncreasing);
        }).orElse(true);
    }

    @Override
    public String getInputFileName() {
        return "day02.txt";
    }
}
