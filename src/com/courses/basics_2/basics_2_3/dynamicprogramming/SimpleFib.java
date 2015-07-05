package com.courses.basics_2.basics_2_3.dynamicprogramming;

import java.time.Duration;
import java.time.Instant;

/**
 * Created by VSulevskiy on 28.06.2015.
 */
public class SimpleFib {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " :\t " + getFibNumber(i));
        }

        int loadTestNumber = 46; //45 - 10 sec, 46 - 15 sec

        //first test
        Instant start1 = Instant.now();
        System.out.println(loadTestNumber + " :\t " + getFibNumber(loadTestNumber));
        Instant end1 = Instant.now();
        Duration duration1 = Duration.between(start1,end1);
        System.out.println("Calculation of " + loadTestNumber + " took " + duration1.toString());

        //second test
        long[] cache = new long[loadTestNumber];
        long start = System.currentTimeMillis();
        System.out.println(loadTestNumber + " :\t " + getFibNumberDynamic(loadTestNumber, cache));
        long duration = System.currentTimeMillis() - start;
        System.out.println("Calculation of " + loadTestNumber + " took " + (double) duration / 1000 + " seconds");


    }

    public static long getFibNumber(int index) {
        if (index == 1 || index == 2) {
            return 1;
        } else {
            return getFibNumber(index - 1) + getFibNumber(index - 2);
        }
    }

    public static long getFibNumberDynamic(int index, long[] cache) {
        long result;
        if (cache[index - 1] != 0) {
            result = cache[index - 1];
        } else if (index == 1 || index == 2) {
            result = 1;
            cache[index - 1] = result;
        } else {
            result = getFibNumberDynamic(index - 1, cache) + getFibNumberDynamic(index - 2, cache);
            cache[index - 1] = result;
        }
        return result;
    }
}
