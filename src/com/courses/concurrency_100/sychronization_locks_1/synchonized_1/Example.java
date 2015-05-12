package com.courses.concurrency_100.sychronization_locks_1.synchonized_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by Vladimir on 12.05.2015.
 */
public class Example {
    public static void main(String[] args) {
        classicExample();
//        lambdaExample();
    }

    private static void classicExample(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Increment incrementInstance = new Increment();
        IncrementTask incrementTask1 = new IncrementTask(incrementInstance);
        IncrementTask incrementTask2 = new IncrementTask(incrementInstance);

        executorService.submit(incrementTask1);
        executorService.submit(incrementTask2);
        stop(executorService);
        System.out.println(incrementInstance.count);
    }

    public static class IncrementTask implements Runnable{
        private Increment increment;
        public IncrementTask(Increment increment){
            this.increment = increment;
        }
        @Override
        public void run() {
            for (int i = 0;i<5_000; i++){//try 50_000
                increment.increment();
//                increment.incrementSynchronized();
//                increment.incrementSynchronizedBlock();
            }
        }
    }

    private static void lambdaExample(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Increment incrementInstance = new Increment();
        IntStream.range(0,10000).forEach(i->executorService.submit(incrementInstance::increment));
        stop(executorService);
        System.out.println(incrementInstance.count);

    }

    public static void stop(ExecutorService executorService){
        try{
            executorService.shutdown();
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            if(!executorService.isTerminated()){
                System.out.println("Killing non-finished tasks");
            }
            executorService.shutdownNow();
        }
    }


}
