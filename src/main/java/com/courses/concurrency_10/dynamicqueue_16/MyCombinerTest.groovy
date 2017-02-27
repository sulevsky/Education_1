package com.courses.concurrency_10.dynamicqueue_16

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.TimeUnit

class MyCombinerTest {

    public static void main(String[] args) {
        AddInputQueue()
    }

    static AddInputQueue() {
        SynchronousQueue<String> consumer = new SynchronousQueue<>();
        new Thread(new Runnable() {
            @Override
            void run() {
                println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS))
                println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS))
                println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS))
                println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS))
                println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS))
                println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS))
                println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS))
                println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS))
                println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS))
                println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS))
                println(Thread.currentThread().getName() + "----got-----" + consumer.poll(10, TimeUnit.SECONDS))

            }
        }).start()

        BlockingQueue<String> numbers = new ArrayBlockingQueue<>(3);
        numbers.add("one")
        numbers.add("two")
        numbers.add("three")

        BlockingQueue<String> names = new ArrayBlockingQueue<>(3);
        names.add("Helen")
        names.add("Paolo")
        names.add("Adam")

        BlockingQueue<String> colors = new ArrayBlockingQueue<>(3);
        colors.add("red")
        colors.add("blue")
        colors.add("white")

        Combiner<String> combiner = new CombinerImpl<>(consumer);
        println "start add numbers"
        combiner.addInputQueue(numbers, 1, 1, TimeUnit.SECONDS)
        println "finish add numbers"
        combiner.addInputQueue(names, 2, 1, TimeUnit.SECONDS)
        combiner.addInputQueue(colors, 3, 1, TimeUnit.SECONDS)

        println "Finish"

//        def conditions = new PollingConditions(timeout: 10, initialDelay: 1.5)


    }


}
