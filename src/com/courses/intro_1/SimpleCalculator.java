package com.courses.intro_1;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created by VSulevskiy on 22.06.2015.
 */
public class SimpleCalculator {
    public static void main(String[] args) {
        double firstNumber;
        double secondNumber;
        System.out.println("Please input first number: ");
        Scanner scanner = new Scanner(System.in);
//        scanner.useLocale(Locale.ENGLISH);
        firstNumber = scanner.nextDouble();
        System.out.print("Your input ");
        System.out.print(firstNumber);
        System.out.println(" as a first number.");

        System.out.println("Please input second number: ");
        secondNumber = scanner.nextDouble();
        System.out.print("Your input ");
        System.out.print(secondNumber);
        System.out.println(" as a second number.\n");

        double sum = firstNumber + secondNumber;
        System.out.println("Sum is " + sum);
        double diff = firstNumber - secondNumber;
        System.out.println("Difference is " + diff);
        double mult = firstNumber * secondNumber;
        System.out.println("Multiplication is " + mult);
        double div = firstNumber / secondNumber;
        System.out.println("Division is " + div);
    }
}
