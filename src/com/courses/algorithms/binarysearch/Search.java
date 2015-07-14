package com.courses.algorithms.binarysearch;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by VSulevskiy on 13.07.2015.
 */
public class Search {

    public static final int ARRAY_SIZE = 1000;
    public static final int NUMBER_TO_FIND = ARRAY_SIZE/2;//middle element

    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];
        fillRandomNumbers(array);
        Arrays.sort(array);

        System.out.println("---------\nFirst test - sequence search");
        System.out.println("Find number " + NUMBER_TO_FIND);
        long start = System.currentTimeMillis();
        int index = sequenceSearch(array, NUMBER_TO_FIND);
        long duration = System.currentTimeMillis() - start;
        System.out.println("Index is " + index);
        System.out.println("Duration is " + duration + " ms");

        System.out.println("---------\nSecond test - binary search");
        System.out.println("Find number " + NUMBER_TO_FIND);
        start = System.currentTimeMillis();
        index = binarySearch(array, NUMBER_TO_FIND);
        long optimizedDuration = System.currentTimeMillis() - start;
        System.out.println("Index is " + index);
        System.out.println("Duration is " + optimizedDuration + " ms");

        System.out.println("Performance increased " + duration / (double) optimizedDuration + " times ");


    }

    public static int binarySearch(int[] array, int numberToFind) {
        return binarySearch(array, numberToFind, 0, array.length - 1);
    }

    public static int binarySearch(int[] array, int numberToFind, int low, int high) {
        int index = (low + high) / 2;
        if (low > high || low == high) {
            return -1;
        } else if (isEquals(array[index], numberToFind)) {
            return index;
        } else if (isBigger(array[index], numberToFind)) {
            return binarySearch(array, numberToFind, low, index - 1);

        } else if (isSmaller(array[index], numberToFind)) {
            return binarySearch(array, numberToFind, index + 1, high);
        }
        return -1;
    }

    public static void fillRandomNumbers(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomNumber = random.nextInt(array.length);
            array[i] = randomNumber;
        }
    }

    public static int sequenceSearch(int[] array, int query) {
        int result = -1;
        for (int i = 0; i < array.length; i++) {
            if (isEquals(array[i], query)) {
                result = i;
                return result;
            }
        }
        return result;
    }

    //JVM is too fast method is craeted for comparison slowness
    public static boolean isEquals(int first, int second) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return first == second;
    }

    public static boolean isBigger(int first, int second) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return first > second;
    }

    public static boolean isSmaller(int first, int second) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return first < second;
    }
}
