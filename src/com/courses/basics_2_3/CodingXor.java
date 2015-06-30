package com.courses.basics_2_3;

public class CodingXor {
    public static void main(String[] args) {
        String message = "Hello";
        char key = 'a';
        System.out.println(message);
        String encodedMessage = encode(message,key);
        System.out.println(encodedMessage);

        String decodedMessage = encode(encodedMessage,key);
        System.out.println(decodedMessage);
    }

    public static String encode(String message, char key) {
        char[] symbols = message.toCharArray();
        char[] codedArray = new char[message.length()];
        for(int i=0;i<symbols.length;i++){
            char codedSymbol = (char) (symbols[i]^key);
            codedArray[i]=codedSymbol;
        }
        String result = new String(codedArray);
        return result;
    }

}
