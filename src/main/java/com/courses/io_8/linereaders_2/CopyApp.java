package com.courses.io_8.linereaders_2;

import java.io.*;

/**
 * Created by VSulevskiy on 10.08.2015.
 */
public class CopyApp {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try{
            bufferedReader = new BufferedReader(new FileReader("resourses/io_test.txt"));
            printWriter = new PrintWriter(new FileWriter("resourses/io_test_out.txt"));
            String s;
            while ((s=bufferedReader.readLine())!=null){
                System.out.println(s);
                printWriter.write(s);
                printWriter.write("\n");
                printWriter.println(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedReader!=null){
                bufferedReader.close();
            }
            if (printWriter!=null){
                printWriter.close();
            }
        }
    }
}
