package com.courses.algorithms.sort;

import com.courses.algorithms.binarysearch.Search;

import java.util.Arrays;

/**
 * Created by VSulevskiy on 13.07.2015.
 */
public class Sort {
    public static final int ARRAY_SIZE = 10;
    public static final int NUMBER_TO_FIND = ARRAY_SIZE/2;//middle element

    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];
        Search.fillRandomNumbers(array);

//        System.out.println("---------\nFirst test - bubble sort");
        int[] copyArray = copyArray(array);
        long start = System.currentTimeMillis();
//        System.out.println(Arrays.toString(copyArray));
//        bubbleSort(copyArray);
//        System.out.println(Arrays.toString(copyArray));
        long duration = System.currentTimeMillis() - start;
//        System.out.println("Bubble sort duration is " + duration + " ms");

//        System.out.println("---------\nSecond test - selection sort");
//        copyArray = copyArray(array);
//        start = System.currentTimeMillis();
//        System.out.println(Arrays.toString(copyArray));
//        selectionSort(copyArray);
//        System.out.println(Arrays.toString(copyArray));
//        duration = System.currentTimeMillis() - start;
//        System.out.println("Selection sort duration is " + duration + " ms");

        System.out.println("---------\nThird test - insertion sort");
        copyArray = copyArray(array);
        start = System.currentTimeMillis();
        System.out.println(Arrays.toString(copyArray));
//        insertionSort(copyArray);//TODO
        System.out.println(Arrays.toString(copyArray));
        duration = System.currentTimeMillis() - start;
        System.out.println("Insertion sort duration is " + duration + " ms");



    }

//    private static void insertionSort(int[] array) {
//        for (int i = 1; i < array.length; i++) {
//
//        }
//
//    }
//    private static void slideInsert(int[] array,int index){
//        int indexTo = index-1;
//        int element = array[index];
//        while(isBigger(array[indexTo],array[index])){
//            indexTo--;
//        }
//
//
//
//    }

    private static void selectionSort(int[] array) {
        for(int i=0;i<array.length-1;i++){
            int minIndex =i+1;
            for(int j=i+1;j<array.length;j++){
                if(isBigger(array[minIndex],array[j])){
                    minIndex = j;
                }
            }
            swap(array,i,minIndex);
        }
    }

    private static void bubbleSort(int[] array) {
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(isBigger(array[i],array[j])){
                    swap(array,i,j);
                }
            }
        }
    }

    public static int[] copyArray(int[] array){
        int[] copy = new int[array.length];
        System.arraycopy(array,0,copy,0,array.length);
        return copy;
    }

    //slowness methods
    public static boolean isBigger(int first, int second){
        slow();
        return first>second;
    }
    public static void swap(int[] array, int first, int second){
        slow();
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
    public static void slow(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
