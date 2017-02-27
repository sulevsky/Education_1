package com.courses.concurrency_10.countdownlatch_14;

/**
 * Created by VSulevskiy on 23.09.2015.
 */
public class RandomGenerator {
    public static long getRandom(long min, long max) {
        long result = min + (long)(Math.random()*(max - min +1));
        return result;
    }
}
