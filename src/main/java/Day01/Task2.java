package Day01;

import org.jooq.lambda.Seq;
import org.jooq.lambda.tuple.Tuple2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        try(final var reader = new BufferedReader(new FileReader("src/main/java/Day01/input.txt"))){
            final var nums = Seq.ofType(reader.lines(), String.class)
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

            final var sum = left
                    .map(l -> l * rightMap.getOrDefault(l, 0))
                    .sum();

            System.out.println(sum);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
