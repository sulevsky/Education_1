package com.courses.concurrency_10.dynamicqueue_16;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class MyCombinerTest {
    public static void main(String[] args) {
        AddInputQueue();
    }

    public static void AddInputQueue() {
        final SynchronousQueue<String> consumer = new SynchronousQueue<String>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS));
                    System.out.println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS));
                    System.out.println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS));
                    System.out.println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS));
                    System.out.println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS));
                    System.out.println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS));
                    System.out.println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS));
                    System.out.println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS));
                    System.out.println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS));
                    System.out.println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS));
                    System.out.println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS));
                    System.out.println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS));
                    System.out.println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS));
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        BlockingQueue<String> numbers = new ArrayBlockingQueue<String>(3);
        numbers.add("one");
        numbers.add("two");
        numbers.add("three");

        BlockingQueue<String> names = new ArrayBlockingQueue<String>(3);
        names.add("Helen");
        names.add("Paolo");
        names.add("Adam");

        BlockingQueue<String> colors = new ArrayBlockingQueue<String>(3);
        colors.add("red");
        colors.add("blue");
        colors.add("white");

        Combiner<String> combiner = new CombinerImpl<String>(consumer);
        System.out.println("start add numbers");
        try {
            combiner.addInputQueue(numbers, 1, 1, TimeUnit.SECONDS);
        }
        catch (Combiner.CombinerException e) {
            e.printStackTrace();
        }
        System.out.println("finish add numbers");
        try {
            combiner.addInputQueue(names, 2, 1, TimeUnit.SECONDS);
        }
        catch (Combiner.CombinerException e) {
            e.printStackTrace();
        }
        try {
            combiner.addInputQueue(colors, 3, 1, TimeUnit.SECONDS);
        }
        catch (Combiner.CombinerException e) {
            e.printStackTrace();
        }

        System.out.println("Finish");
    }

}
