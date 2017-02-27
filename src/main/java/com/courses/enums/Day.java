package com.courses.enums;

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
