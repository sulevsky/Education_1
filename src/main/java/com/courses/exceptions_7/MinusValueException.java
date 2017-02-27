package com.courses.exceptions_7;

/**
 * Created by VSulevskiy on 11.08.2015.
 */
public class MinusValueException extends RuntimeException
{
    public MinusValueException(){
        super();
    }
    public MinusValueException(String message){
        super(message);
    }


}
