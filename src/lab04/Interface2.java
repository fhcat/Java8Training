package lab04;

/**
 * Created by shenv on 4/19/2017.
 */
@FunctionalInterface
public interface Interface2 {
    int getSquareOfA(int a);

    default void printSquare(int a) {
        System.out.println(getSquareOfA(a));
    }
}

