package com.courses.concurrency_10.dynamicqueue_16;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

//NOT THREAD SAFE
public class CombinerImpl<T> extends Combiner<T> {

    private final List<QueueDescription<T>> queueDescriptions = new CopyOnWriteArrayList<>();
    private final Thread executor;
    private volatile Double prioritiesSum;

    public CombinerImpl(SynchronousQueue<T> outputQueue) {
        super(outputQueue);
        this.executor = createExecutor();
    }

    //Background execution
    private Thread createExecutor() {
        Thread executor = new Thread(() -> {
            try {
                T next = fetchNext();
                while (next != null) {
                    outputQueue.put(next);
                    next = fetchNext();
                }
            }
            catch (CombinerException | InterruptedException e ) {
                //suppressed intentionally
            }
        });
        executor.setName("transporter-thread");
        executor.setDaemon(true);
        return executor;
    }

    @Override
    public synchronized void addInputQueue(BlockingQueue<T> queue,
                                           double priority,
                                           long isEmptyTimeout,
                                           TimeUnit timeUnit) {
        QueueDescription<T> description = new QueueDescription<T>(queue, priority, isEmptyTimeout, timeUnit);
        queueDescriptions.add(description);
        recalculatePrioritiesSum();
        if (!executor.isAlive()) {
            executor.start();
        }

    }

    @Override
    public synchronized void removeInputQueue(BlockingQueue<T> queue) {
        queueDescriptions
                .removeIf(descr -> descr.getQueue().equals(queue));
        recalculatePrioritiesSum();

    }

    @Override
    public synchronized boolean hasInputQueue(BlockingQueue<T> queue) {
        return queueDescriptions
                .stream()
                .anyMatch(desc -> desc
                        .getQueue()
                        .equals(queue));
    }

    private T fetchNext() throws CombinerException {
        while (!queueDescriptions.isEmpty()) {
            int index = getNextQueueIndex();
            QueueDescription<T> description = queueDescriptions.get(index);
            BlockingQueue<T> queue = description.getQueue();
            try {
                T element = queue.poll(description.getIsEmptyTimeout(), description.getTimeUnit());
                if (element == null) {
                    removeInputQueue(queue);
                }
                else {
                    return element;
                }
            }
            catch (InterruptedException e) {
                removeInputQueue(queue);
            }
        }
        return null;
    }

    private int getNextQueueIndex() {
        double guess = Math.random() * prioritiesSum;
        for (int i = 0; i < queueDescriptions.size(); i++) {
            if (guess < queueDescriptions.get(i).getPriorityCumulative()) {
                return i;
            }
        }

        throw new IllegalStateException("probability ranges are not calculated properly");
    }

    private void recalculatePrioritiesSum() {
        if (queueDescriptions.isEmpty()) {
            prioritiesSum = 0.0;
        }
        else {
            double priorityStart = queueDescriptions.get(0).getPriority();
            queueDescriptions.get(0).setPriorityCumulative(priorityStart);
            prioritiesSum = priorityStart;
            for (int i = 1; i < queueDescriptions.size(); i++) {
                double priorityCumulativePrev = queueDescriptions.get(i - 1).getPriorityCumulative();
                double priorityCurrent = queueDescriptions.get(i).getPriority();
                double priorityCumulativeCurrent = priorityCurrent + priorityCumulativePrev;
                queueDescriptions.get(i).setPriorityCumulative(priorityCumulativeCurrent);
                if (i == queueDescriptions.size() - 1) {
                    prioritiesSum = priorityCumulativeCurrent;
                }
            }
        }
    }

    private static class QueueDescription<T> {
        private final BlockingQueue<T> queue;
        private final double priority; //0.5
        private volatile double priorityCumulative; // 0.5

        private final long isEmptyTimeout;
        private final TimeUnit timeUnit;

        public QueueDescription(BlockingQueue<T> queue,
                                double priority,
                                long isEmptyTimeout,
                                TimeUnit timeUnit) {
            this.queue = queue;
            this.priority = priority;
            this.isEmptyTimeout = isEmptyTimeout;
            this.timeUnit = timeUnit;
        }

        public BlockingQueue<T> getQueue() {
            return queue;
        }

        public double getPriority() {
            return priority;
        }

        public long getIsEmptyTimeout() {
            return isEmptyTimeout;
        }

        public TimeUnit getTimeUnit() {
            return timeUnit;
        }

        public double getPriorityCumulative() {
            return priorityCumulative;
        }

        public void setPriorityCumulative(double priorityCumulative) {
            this.priorityCumulative = priorityCumulative;
        }
    }
}
