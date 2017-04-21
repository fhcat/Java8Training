package lab13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.DoubleStream;

/**
 * Created by shenv on 4/21/2017.
 */
public class TestCurrying {

    private enum GradeCalcType {
        AVERAGE,
        WORSE,
        BEST
    }

    private static Function<GradeCalcType, Function<List<Double>, Double>> curryingFunction = type -> {
        Function<List<Double>, Double> func = null;
        switch (type) {
            case BEST: {
                func = l -> l.stream().max(Double::compareTo).orElse(-1d);
                break;
            }
            case AVERAGE: {
                func = l -> l.stream().reduce(0d, (ll,r) -> ll+r) / l.size();
                break;
            }
            case WORSE: {
                func = l -> l.stream().min(Double::compareTo).orElse(-1d);
                break;
            }
            default:
            {
                func = null;
                break;
            }
        }
        return func;
    };

    public static void main(String... args) {
        List<Double> scores = Arrays.asList(.65, .75, .85);

        System.out.println(curryingFunction.apply(GradeCalcType.AVERAGE).apply(scores));
        System.out.println(curryingFunction.apply(GradeCalcType.BEST).apply(scores));
        System.out.println(curryingFunction.apply(GradeCalcType.WORSE).apply(scores));
    }
}
