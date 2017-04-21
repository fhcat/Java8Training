package lab12;

import java.util.stream.IntStream;

/**
 * Created by shenv on 4/21/2017.
 */
public class TestStreams1 {

    private static boolean isPrime(int n) {
        return IntStream.range(2, n).allMatch(i -> n%i!=0 && n > 1);
    }

    public static void main(String... args) {
//        IntStream.rangeClosed(0, 10000)
//                .parallel()
//                .filter(n -> n%2==0)
//                .forEach(System.out::println);

//        int sum = IntStream.rangeClosed(0, 100).filter(n -> n%2==1).reduce(0, (l,r) -> l+r);
//        System.out.println(sum);

        System.out.println(IntStream.rangeClosed(0, 100)
//                .parallel()
                .filter(n -> isPrime(n))
                .filter(n -> n%2==1)
                .peek(System.out::println)
                .reduce(0, (l,r) -> l+r));

        System.out.println(IntStream.rangeClosed(0,100)
                .parallel()
                .filter(n -> IntStream.rangeClosed(1,n)
                .reduce(1, (l,r) -> l*r) >= 1000000 )
                .findFirst()
                .orElse(-1));
    }
}

