package com.courses.basics_2.basics_2_1;

/**
 * Created by Vovka on 09.11.2015.
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = new  int[]{1,2,3,4,5};
        int res = sum(arr);
        System.out.println(res);
    }
    public static int sum(int[] arr){
        int sum = 0;
        for (int el : arr) {
            sum += el;
        }
        return sum;
    }
}
