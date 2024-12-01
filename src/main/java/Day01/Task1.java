package Day01;

import org.jooq.lambda.Seq;
import org.jooq.lambda.tuple.Tuple2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        try(final var reader = new BufferedReader(new FileReader("src/main/java/Day01/input.txt"))){
            final var nums = Seq.ofType(reader.lines(), String.class)
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

            final var sum = Seq.ofType(left.boxed(), Integer.class)
                    .zip(right.boxed())
                    .map(t -> Math.abs(t.v1 - t.v2))
                    .mapToInt(Integer::intValue)
                    .sum();

            System.out.println(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
