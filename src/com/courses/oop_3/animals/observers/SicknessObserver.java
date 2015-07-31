package com.courses.oop_3.animals.observers;

import com.courses.oop_3.animals.observable.Observer;

/**
 * Created by VSulevskiy on 31.07.2015.
 */
public class SicknessObserver implements Observer{
    @Override
    public void handle() {
        System.out.println("That's not my job");
    }
}
