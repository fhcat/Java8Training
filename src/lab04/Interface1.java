package lab04;

/**
 * Created by shenv on 4/19/2017.
 */
@FunctionalInterface
public interface Interface1 {
    void printSquare(int a);

    default void foo(int a) {
        printSquare(a);
    }
}
