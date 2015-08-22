package com.courses.enums;

import com.courses.oop_3.animals.Pair;

/**
 * Created by VSulevskiy on 26.05.2015.
 */
public class DayTest {

    public void tellItLikeItIs(Day day) {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad");
                break;
            case FRIDAY:
                System.out.println("Fridays are better");
                break;
            case SATURDAY:

            case SUNDAY:
                System.out.println("Weekends are best");
                break;
            default:
                System.out.println("Midweek days are so-so");
                break;
        }
    }

    public boolean isItBadDay(Day day) {
        if (day == Day.MONDAY) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        DayTest dayTest = new DayTest();
//        System.out.println(Day.FRIDAY.isItBadDay());
        System.out.println(Planet.EARTH == Planet.EARTH);

//        Day monday = Day.MONDAY;
//        dayTest.tellItLikeItIs(monday);
//
//        dayTest.tellItLikeItIs(Day.SATURDAY);
//        dayTest.tellItLikeItIs(Day.SUNDAY);
//
//        for(Day day : Day.valueOf()){
//            System.out.print(day.name() + " ");
//            dayTest.tellItLikeItIs(day);
//        }

    }
}
