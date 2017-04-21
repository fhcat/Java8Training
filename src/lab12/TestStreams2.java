package lab12;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.lang.System.out;

/**
 * Created by shenv on 4/19/2017.
 */
public class TestStreams2 {
    public static void main(String[] args) {
        out.println("Lab 05");

        Predicate<Double[]> allPassed = (scores) -> {
            return  Arrays.stream(scores).allMatch(s -> s >= 0.60);
        };

        Predicate<Double[]> averagePassed = (scores) -> {
            return (Arrays.stream(scores).reduce(0d, (l,r) -> l+r) / scores.length) >= 0.80;
        };

        Predicate<Double[]> lastPerfect = (scores) -> {
            return scores[scores.length-1] == 1;
        };

        Predicate<Double[]> takenAll = (scores) -> {
            return Arrays.stream(scores).allMatch(s -> s > 0d);
        };

//        Double[] scores = (Double[]) Arrays.asList(.59, .90, .90, .90, 0d, 1d).toArray();
        Double[] scores = (Double[]) Arrays.asList(.70, .70, .70, .70, .70, 1d).toArray();

        Predicate<Double[]> passed = takenAll.and(allPassed.and(averagePassed).or(lastPerfect));

        out.println(passed.test(scores));

 /*       Function<Double, Double> doubleFunction = a -> a * 2;
        Function<Double, Double> squareFunction = a -> a * a;
        Function<Double, Double> cubeFunction = a -> a * a * a;
        Function<Double, Double> negateFunction = a -> -a;
        Function<Double, Double> foo = doubleFunction.andThen(squareFunction).andThen(cubeFunction).andThen(negateFunction);
        out.println(foo.apply(3d));
        Function<Double, Double> bar = negateFunction.compose(cubeFunction).compose(squareFunction).compose(doubleFunction);
        out.println(bar.apply(3d));

        Consumer<String> printToStdout = text -> {
            System.out.println(text);
        };
        Consumer<String> printFilteredToStderr = text -> {
            Predicate<String> containsPredicate = str -> {
                return str.contains("exception");
            };
            if (containsPredicate.test(text))
                System.err.println(text);
        };

        Consumer<String> superPrint = printToStdout.andThen(printFilteredToStderr);
        superPrint.accept("This is an info");
        superPrint.accept("This is an exception.");*/
    }
}
