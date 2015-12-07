package com.courses.concurrency_10.forkjoin_15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Created by VSulevskiy on 07.12.2015.
 */
public class ValueSumCounter extends RecursiveTask<Long> {
    private final Node node;

    public ValueSumCounter(Node node) {
        this.node = node;
    }

    @Override
    protected Long compute() {
        long sum = node.getValue();
        List<ValueSumCounter> subTasks = new ArrayList<>();
        for (Node child : node.getChildren()) {
            ValueSumCounter task = new ValueSumCounter(child);
            task.fork();
            subTasks.add(task);
        }
        for (ValueSumCounter subTask : subTasks) {
            sum += subTask.join();

        }
        return sum;
    }
}
