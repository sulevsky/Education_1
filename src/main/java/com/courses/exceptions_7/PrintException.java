package com.courses.exceptions_7;

/**
 * Created by VSulevskiy on 11.08.2015.
 */
public class PrintException extends RuntimeException {
    public PrintException(){
        super();
    }
    public PrintException(String message){
        super(message);
    }
    public PrintException(String message, Throwable throwable){
        super(message, throwable);
    }
}
