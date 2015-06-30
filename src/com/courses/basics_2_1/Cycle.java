package com.courses.basics_2_1;

/**
 * Created by Vladimir Sulevskiy on 23.06.2015.
 */
public class Cycle {
    public static void main(String[] args) {
        double result;

        result = add(22.4,10);
        System.out.println(result);

    }
    public static double add(int first, double second){
        return 10000000;
    }

    public static double add(double first, int second){
        double sum = first + second;
        return sum;
    }
    public static void printHello(){
        printMessage("Hello");
    }
    public static void printMessage(String message){
        System.out.println(message);
    }
}
