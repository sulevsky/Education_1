package com.courses.generics;

import java.io.Serializable;

/**
 * Created by VSulevskiy on 24.06.2015.
 */
public class Interval <T> implements Serializable{
    private T lower;
    private T upper;
    public Interval(T first, T second){
        if(1<=0){
//        if(first.compareTo(second)<=0){
            lower =first;
            upper = second;
        }
        else{
            lower = second;
            upper = first;
        }

    }

}
