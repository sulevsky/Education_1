package com.courses.exceptions_7;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VSulevskiy on 03.06.2015.
 */
public class ListOfNumbers {
    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers() {
        list = new ArrayList<Integer>();
        for (int i = 0; i < SIZE; i++) {
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
        try {
            PrintWriter outWriter = new PrintWriter(new FileWriter("out.txt"));
            for (int i = 0; i < SIZE + 1; i++) {
                outWriter.println("Value at i " + i + " = " + list.get(i));
            }
            outWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());//bad
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
//            System.out.println(e.toString());//very bad
            e.printStackTrace(System.out);
//            System.exit(1);
        }
        finally {
            System.out.println("Finally");
        }
    }

    public static void main(String[] args) throws MalformedURLException {
        ListOfNumbers listOfNumbers = new ListOfNumbers();
        listOfNumbers.writeList();
//        System.out.println(Arrays.toString(arr));
    }

}
