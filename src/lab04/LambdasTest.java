package lab04;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.lang.System.out;

/**
 * Created by shenv on 4/19/2017.
 */
public class LambdasTest {
    public static void main(String[] args) {
        out.println("Lab 04");

        Consumer<Integer> consumer = (a) -> out.println(a * a);
        consumer.accept(3);

        Function<Integer, Integer> function = (a) -> a * a;
        out.println(function.apply(4));

        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a * b;
        out.println(biFunction.apply(5, 10));

        Supplier<Double> supplier = () -> Math.PI;
        out.println(supplier.get());
    }
}
