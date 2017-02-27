package com.courses.basics_2.basics_2_3;

public class CodingXor {
    public static void main(String[] args) {
        String message = "Hello ";
        String key = "this is a key";
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
    public static String encode(String message, String key) {
        char[] symbols = message.toCharArray();
        char[] keys = key.toCharArray();

        char[] codedArray = new char[message.length()];
        for(int i=0;i<symbols.length;i++){
            char codedSymbol = (char)
                    (symbols[i]^keys[i%keys.length]);
            codedArray[i]=codedSymbol;
        }
        String result = new String(codedArray);
        return result;
    }

}
