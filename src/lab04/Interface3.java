package lab04;

/**
 * Created by shenv on 4/19/2017.
 */
@FunctionalInterface
public interface Interface3 {
    int getAxB(int a, int b);
    static int getAxB2(int a, int b) {
        return a * b;
    }
}
