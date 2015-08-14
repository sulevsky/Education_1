package com.courses.exceptions_7;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by VSulevskiy on 11.08.2015.
 */
public class IoUtils {
    private IoUtils(){}
    public static void closeWriter(FileWriter writer){
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new PrintException("not closed", e);
        }
    }
}

