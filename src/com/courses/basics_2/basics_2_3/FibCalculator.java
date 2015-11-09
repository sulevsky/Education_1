package com.courses.basics_2.basics_2_3;

/**
 * Created by Vovka on 09.11.2015.
 */
public class FibCalculator {
    public static void main(String[] args) {
        System.out.println(calculateFib(50));
//        System.out.println(sumPreceding(15000));
    }

    public static long[] cache = new long[51];

    public static long calculateFib(int num) {
        if (cache[num] != 0) {
            return cache[num];
        } else if (num == 0 || num == 1) {
            cache[num] = 1;
            return 1;
        } else {
            long res = calculateFib(num - 2) + calculateFib(num - 1);
            cache[num]= res;
            return res;
        }
    }

    public static long sumPreceding(long peek) {
        long sum = 0;
        while (peek > 0) {
            sum += peek;
            peek--;
        }
        return sum;
    }

}
