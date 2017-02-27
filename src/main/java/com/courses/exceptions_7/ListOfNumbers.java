package com.courses.exceptions_7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers {
    private List<Integer> list;
    private int numOfDigits;

    public ListOfNumbers() {
    }


    public void init(int numOfDigits) {
        if (numOfDigits < 0) {
            throw new MinusValueException("Please input positive value");
        }
        this.numOfDigits = numOfDigits;
        list = new ArrayList<Integer>();
        for (int i = 0; i < numOfDigits; i++) {
            list.add(i);
        }
    }

    //    public void writeList(){
//        PrintWriter outWriter = new PrintWriter(new FileWriter("out.txt"));
//        for(int i= 0 ; i<SIZE; i++){
//            outWriter.println("Value at i " + i + " = " + list.get(i));
//        }
//        outWriter.close();
//    }
    public void writeList() {
        FileWriter outWriter = null;
        try {
            outWriter = new FileWriter("out.txt");
            for (int i = 0; i < numOfDigits; i++) {
                outWriter.write("Value at i " + i + " = " + list.get(i));
            }
        } catch (IOException e) {
            throw new PrintException("can't print", e);

        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace(System.out);
        } finally {
            IoUtils.closeWriter(outWriter);
        }

    }


    public static void main(String[] args) {
        ListOfNumbers listOfNumbers = new ListOfNumbers();
        listOfNumbers.init(20);

        listOfNumbers.writeList();
//
//        System.out.println(Arrays.toString(arr));
    }

}
