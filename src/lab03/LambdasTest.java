package lab03;

import static java.lang.System.out;

/**
 * Created by shenv on 4/19/2017.
 */
public class LambdasTest {
    public static void main(String[] args) {
        {
            Interface1 i1 = (int a) -> out.println(a * a);
            i1.printSquare(10);
        }

        {
            Interface2 i2 = a -> a * a;
            out.println("y = " + i2.getSquareOfA(3));
        }

        {
            Interface3 i3 = (int a, int b) -> a * b;
            out.println(i3.getAxB(3, 5));
        }

        {
            Interface4 i4 = () -> {return 3.14;};
            double pi = i4.getPi();
        }



        out.println("Lab 02");
        LambdasTest obj = new LambdasTest();
        obj.callI1(3, a -> out.println(a * a));
        obj.callI1(3, out::println);


        obj.callI2(3, a -> a*a);
        obj.callI2(3, obj::square);


    }


    private void callI1(int a, Interface1 i1) {
        i1.printSquare(a);
    }

    private void callI2(int a, Interface2 i2) {
        out.println(i2.getSquareOfA(a));
    }

    private int square(int a) {
        return a * a;
    }
}
