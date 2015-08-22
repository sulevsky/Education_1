package com.courses.enums;

import com.courses.oop_3.oop_1.Student;

/**
 * Created by VSulevskiy on 26.05.2015.
 */
public enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;



    public boolean isItBadDay() {
        if (this == Day.MONDAY) {
            return true;
        } else {
            return false;
        }
    }

    }
