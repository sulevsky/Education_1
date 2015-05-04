package com.courses.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Vladimir on 02.05.2015.
 */
public class Outputer {

    // путь к файлу который будем читать и записывать
    private String filePath;

    public Outputer(String filePath) {
        this.filePath = filePath;
    }

    // запись в файл используя OutputStream
    public void write(String st) throws IOException {
        // инициализируем поток для вывода данных
        // что позволит нам записать новые данные в файл
        OutputStream outputStream = new FileOutputStream(filePath);
        // передаем полученную строку st и приводим её к byte массиву.
        outputStream.write(st.getBytes());
        // закрываем поток вывода
        // только после того как мы закроем поток данные попадут в файл.
        outputStream.close();
    }
}

