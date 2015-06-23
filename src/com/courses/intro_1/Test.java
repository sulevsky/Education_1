package com.courses.intro_1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        System.out.println("mySimpleCalc: Welcome!");

        Scanner scanner = new Scanner(System.in);

        BigDecimal num1 = null;
        BigDecimal num2 = null;

        do {
            System.out.println("Please, input the first number");
            if (scanner.hasNextBigDecimal()) {
                num1 = scanner.nextBigDecimal();
                System.out.println("Your input " + num1.toPlainString() + " as the first number");
            } else {
                System.out.println("Incorrect entry, exception " + scanner.nextLine() + ". You must enter numbers. Try again.");
            }
        }
        while (num1!=null);

        do {
            System.out.println("Please, input the second number.");
            if (scanner.hasNextBigDecimal()) {
                num2 = scanner.nextBigDecimal();
                System.out.println("Your input " + num2.toPlainString() + " as the second number.");
            } else {
                System.out.println("Incorrect entry, exception " + scanner.nextLine() + ". You must enter numbers. Try again.");
            }
        }
        while (num2!=null);

        BigDecimal sum = (num1.add(num2));
        sum = sum.setScale(8, RoundingMode.HALF_DOWN);

        BigDecimal dif = (num1.subtract(num2));
        dif = dif.setScale(8, RoundingMode.HALF_DOWN);

        BigDecimal mul = (num1.multiply(num2));
        mul = mul.setScale(8, RoundingMode.HALF_DOWN);

        String divOutput;
        if(num2.intValue()!=0){
            divOutput = (num1.divide(num2, 8, RoundingMode.HALF_DOWN)).toPlainString();
        } else{
            divOutput = "You can't divide by zero";
        }

        System.out.println("Results:");
        System.out.println("Sum is: " + sum.toPlainString());
        System.out.println("Difference is: " + dif.toPlainString());
        System.out.println("Multiplication is: " + mul.toPlainString());
        System.out.println("Division is: " + divOutput);

        scanner.close();
        System.exit(0);
    }
}