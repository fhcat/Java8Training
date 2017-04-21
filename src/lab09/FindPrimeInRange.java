package lab09;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by shenv on 4/20/2017.
 */
public class FindPrimeInRange implements Callable<List<Integer>> {
    private int start, end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public FindPrimeInRange(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public List<Integer> call() throws Exception {
        System.out.println("Thread " + Thread.currentThread().getId() + " started.");
        List<Integer> result = new ArrayList<>();
        int i;
        for (i = start; i < end; i++) {
            if (isPrime(i))
                result.add(i);
        }
        System.out.println("Thread " + Thread.currentThread().getId() + " finished.");
        return result;

    }

    private boolean isPrime(int primeCandidate) {
        boolean isPrime = primeCandidate == 2;

        if (primeCandidate > 2) {
            isPrime = true;
            for (int testValue = 2; testValue <= Math.sqrt(primeCandidate); ++testValue) {
                if (primeCandidate % testValue == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        return isPrime;
    }
}
