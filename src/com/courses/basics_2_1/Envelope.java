package com.courses.basics_2_1;

import java.util.Scanner;

public class Envelope {
    public static void main(String[] args) {
//        System.out.println("Please write, please, size of your envelope: ");
//        Scanner scanner = new Scanner(System.in);
//        int envSize = scanner.nextInt();

//        for (int i = 1; i <= envSize; i++) {
//            System.out.print("*");
//            for (int j = 1; j <=envSize; j++) {
//                String str;
//                if (i == j || j == (envSize+1-i)) {
//                    str = "*";
//                } else if (i == 1 || i ==envSize){
//                    str = "*";
//                } else {
//                    str = " ";
//                }
//                System.out.print(str);
//            }
//            System.out.println("*");
//        }
//        for (int i = 0; i < envSize; i++) {
//            for (int j = 0; j < envSize; j++) {
//                if(i==0 || j==0 || i==envSize-1 || j ==envSize-1 || i==j || i+j==envSize-1){
//                    System.out.print("*");
//                }
//                else {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }


            System.out.println("Please write, please, size of your envelope: ");
            Scanner scanner = new Scanner(System.in);
            int envSize = scanner.nextInt();

            for (int i = 1; i <= envSize; i++) {

                for (int j = 1; j <=envSize; j++) {
                    String str;
                    if (i == j || j == (envSize+1-i)) {
                        str = "*";
                    } else if (i == 1 || i ==envSize) {
                        str = "*";
                    } else if (j == 1 || j ==envSize) {
                        str = "*";
                    } else {
                        str = " ";
                    }
                    System.out.print(str);
                }

                System.out.print("\n");

            }

    }
}