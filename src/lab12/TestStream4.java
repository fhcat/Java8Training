package lab12;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * Created by shenv on 4/21/2017.
 */
public class TestStream4 {

    public static void main(String... args) {
        IntStream.rangeClosed(1, 100)
                .filter(i -> i % 3==0)
                .mapToObj(i -> i + " fizz")
                .forEach(System.out::println);

        IntPredicate divisibleBy3 = i -> i %3 == 0;
        IntPredicate divisibleBy5 = i -> i %5 == 0;

        IntStream.rangeClosed(1, 100)
                .filter(divisibleBy3.or(divisibleBy5))
                .mapToObj(i -> i + " fizz")
                .forEach(System.out::println);

    }
}
