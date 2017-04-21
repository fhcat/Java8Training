package lab12;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by shenv on 4/21/2017.
 */
public class TestStream3 {

    public static void main(String... args) {
        String word = args[0];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // -c
        System.out.println(reader.lines().parallel().filter(line -> line.toUpperCase().contains(word.toUpperCase())).count());
//        System.out.println(reader.lines().parallel().filter(line -> line.toUpperCase().contains(word.toUpperCase())).collect());

        // regular
        reader.lines().filter(line -> line.contains(word)).forEach(System.out::println);
    }
}
