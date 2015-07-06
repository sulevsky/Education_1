package com.courses.basics_2.basics_2_1;

import java.util.Scanner;

public class Envelope {
    public static void main(String[] args) {
        System.out.println("Please write, please, size of your envelope: ");
        Scanner scanner = new Scanner(System.in);
//        int envSize = scanner.nextInt();
        int envSizeY = 41;
        int envSizeX = 20;

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
//        for (int i = 0; i < envSizeY; i++) {
//            for (int j = 0; j < envSizeX; j++) {
//                if (i == 0 || j == 0 || i == envSizeY - 1 || j == envSizeX - 1) {
//                    System.out.print("*");
//                } else
////                System.out.println(i-j*(double)envSizeY/envSizeX);
//                    if (Math.abs(i - j * (double) (envSizeY - 1) / (envSizeX - 1)) < 0.2 || Math.abs(j - i * (double) (envSizeX - 1) / (envSizeY - 1)) < 0.2) {
//                        System.out.print("*");
//                    } else {
//                        System.out.print(" ");
//                    }
//            }
//            System.out.println();
//        }
            int verSize = 21;
            int horSize = 41;
            for (int i = 1; i <= verSize; i++) {
                for (int j = 1; j <= horSize; j++) {
                    if ((i == verSize) || (j == 1) ||
                            (j == horSize) || (i == 1) ||
                            (j == i) || (i + j == 1 + verSize)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.print("\n");
            }
    }
}