package com.courses.basics_2_2;

/**
 * Created by VSulevskiy on 25.06.2015.
 */
public class AppXor {

    public static void main(String[] args) {
        char[] input = {'H','e','l','l','o'};
        char key = 'k';
        char in = 'l';
        System.out.println(Integer.toBinaryString(key));
        System.out.println(Integer.toBinaryString(in));
        System.out.println();

        System.out.println(Integer.toBinaryString(~key));
        System.out.println(Integer.toBinaryString(key&in));
        System.out.println(Integer.toBinaryString(key|in));
        System.out.println(Integer.toBinaryString(key^in));

    }
    public static char encode(char message, char key){
        char result;
        result = (char)(message^key);
        return result;
    }

}
