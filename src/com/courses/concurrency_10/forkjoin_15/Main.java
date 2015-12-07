package com.courses.concurrency_10.forkjoin_15;

import java.util.Collection;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by VSulevskiy on 07.12.2015.
 */
public class Main {
    public static void main(String[] args) {
        Node root = createTestTree(0, 4, 6);
        long sum = new ForkJoinPool().invoke(new ValueSumCounter(root));
        System.out.println(sum);
//        System.out.println(root);
    }

    private static Node createTestTree(int startValue, int numOfChildren, int depth) {

        Node node = new NodeImpl(startValue);
        for (int i = 0; i < numOfChildren; i++) {
            startValue++;
            Node child;
            if (depth == 0) {
                child = new NodeImpl(startValue);
            }else{
                child = createTestTree(startValue, numOfChildren, depth - 1);
            }
            node.getChildren().add(child);
        }
        return node;

    }
}
