package com.courses.io;

import java.io.*;
/**
 * Created by Vladimir on 02.05.2015.
 */


public class Inputer {

    // путь к файлу который будем читать и записывать
    private String filePath;


    public Inputer(String filePath) {
        this.filePath = filePath;
    }

    // чтение файла использу€ InputStream
    public void read() throws IOException {
        // инициализируем поток на чтение
        InputStream inputstream = new FileInputStream(filePath);

        // читаем первый символ в байтах (ASCII)
        int data = inputstream.read();
        char content;
        // по байтово читаем весь файл
        while(data != -1) {
            // преобразуем полученный байт в символ
            content = (char) data;
            // выводим посимвольно
            System.out.print(content);
            data = inputstream.read();
        }
        // закрываем поток
        inputstream.close();
    }

    public int countNumOfSymbols() throws IOException {
        int numOfSymbols = 0;
        InputStream inputstream = new FileInputStream(filePath);

        int data;

         do {
            data = inputstream.read();
            numOfSymbols++;

        }while(data != -1);
        // закрываем поток
        inputstream.close();
        return numOfSymbols;
    }
}
