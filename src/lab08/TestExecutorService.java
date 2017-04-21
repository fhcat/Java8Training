package lab08;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by shenv on 4/20/2017.
 */
public class TestExecutorService {

    public static void main(String... args) {
        int n = 1000000;
        int numberOfThreads = (int)Math.ceil(n/1000);

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        List<Future<List<Integer>>> futures = new ArrayList<>(n/1000);
        for(int i=0;i < numberOfThreads;i++) {
            int start = i * 1000;
            int end = (i+1) * 1000;
            if (end > n)
                end = n;
            Future<List<Integer>> future = executorService.submit(new FindPrimeInRange(start, end));
            futures.add(future);
        }

        int totalN = 0;
        for (Future<List<Integer>> future: futures){
            try {
                List<Integer> threadResult = future.get();
                totalN += threadResult.size();
                System.out.println("Printing result for thread " + future.toString() );
                System.out.println("Total number: " + totalN);
//                threadResult.forEach(System.out::println);
            } catch (ExecutionException e) {

            } catch (InterruptedException e) {

            } finally {

            }
        }

        executorService.shutdown();
    }
}
