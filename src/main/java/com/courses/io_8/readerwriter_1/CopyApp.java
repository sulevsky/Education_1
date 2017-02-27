package com.courses.io_8.readerwriter_1;

import java.io.*;

/**
 * Created by VSulevskiy on 10.08.2015.
 */
public class CopyApp {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader("resourses/io_test.txt");
            fileWriter = new FileWriter("resourses/io_test_out.txt");
//            InputStreamReader reader = new InputStreamReader(new FileInputStream("resourses/io_test.txt"));
            int character;
            while((character = fileReader.read())!=-1){
                System.out.println((char)character+" : "+ character);
                fileWriter.write(character);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileReader!=null){
                fileReader.close();
            }
            if(fileWriter!=null){
                fileWriter.close();
            }
        }
    }
}
