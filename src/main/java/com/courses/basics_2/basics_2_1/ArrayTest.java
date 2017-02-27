package com.courses.basics_2.basics_2_1;

/**
 * Created by Vovka on 09.11.2015.
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = new  int[]{1,2,3,4,5};
        int l = 5;
        int res = sum(arr, l);
        System.out.println(l);
        for (int el: arr) {
            System.out.println(el);
        }
    }

    public static int sum(int[] arr, int length){
        int sum = 0;
        for (int i=0;i<length;i++) {
            sum += arr[i];
        }


        length = 10;
        arr[0]= sum;
        return sum;
    }
}
