package com.courses.basics_2_1;

public class Gr {

    //        �. ������� �������������
    public static void square(int horSize, int verSize) {

        for (int i = 1; i <= verSize; i++) {
            for (int j = 1; j <= horSize; j++) {
                if ((i == verSize) || (j == 1) || (j == horSize) || (i == 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

    //        �. �������
    public static void cross(int horSize, int verSize) {
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

    //          CHESS
    public static void chess(int horSize, int verSize) {
        for (int i = 1; i <= verSize; i++) {
            for (int j = 1; j <= horSize; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }


    public static void main(String... f) {

        System.out.print("Please input horizontal size: ");
        int horSize = 23; //in.getInputInt();
        System.out.println("Your input " + horSize + " as a vertical size \n");

        System.out.print("Please input vertical size: ");
        int verSize = 44;//Main.getInputInt();
        System.out.println("Your input " + verSize + " as a horizontal size \n");

        square(horSize, verSize);
        System.out.println("\n\n");
        cross(horSize, verSize);
        System.out.println("\n\n");
        chess(horSize, verSize);
    }
}
