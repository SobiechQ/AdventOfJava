import org.jooq.lambda.Seq;
import org.jooq.lambda.tuple.Tuple2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Day01 extends AdventDay {

    @Override
    public int firstTask() {

        final var nums = Seq.ofType(this.lines().stream(), String.class)
                .map(s-> new Tuple2<>(s.split(" {3}")[0], s.split(" {3}")[1]))
                .map(s->new Tuple2<>(Integer.parseInt(s.v1), Integer.parseInt(s.v2)))
                .collect(Collectors.toSet());

        final var left = nums.stream()
                .map(t->t.v1)
                .mapToInt(Integer::intValue)
                .sorted();

        final var right = nums.stream()
                .map(t->t.v2)
                .mapToInt(Integer::intValue)
                .sorted();

        return Seq.ofType(left.boxed(), Integer.class)
                .zip(right.boxed())
                .map(t -> Math.abs(t.v1 - t.v2))
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public int secondTask() {
        final var nums = Seq.ofType(this.lines().stream(), String.class)
                .map(s-> new Tuple2<>(s.split(" {3}")[0], s.split(" {3}")[1]))
                .map(s->new Tuple2<>(Integer.parseInt(s.v1), Integer.parseInt(s.v2)))
                .collect(Collectors.toSet());

        final var left = nums.stream()
                .map(t->t.v1)
                .mapToInt(Integer::intValue);

        final var rightMap = nums.stream()
                .map(t->t.v2)
                .mapToInt(Integer::intValue)
                .collect(
                        (Supplier<Map<Integer, Integer>>) HashMap::new,
                        (integerIntegerMap, value) -> {
                            integerIntegerMap.putIfAbsent(value, 0);
                            integerIntegerMap.computeIfPresent(value, (_, integer2) -> integer2 + 1);
                        },
                        Map::putAll
                );

        return left
                .map(l -> l * rightMap.getOrDefault(l, 0))
                .sum();
    }

    @Override
    public String getInputFileName() {
        return "day01.txt";
    }
}