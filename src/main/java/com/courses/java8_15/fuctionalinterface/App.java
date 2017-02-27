package com.courses.java8_15.fuctionalinterface;

/**
 * Created by VSulevskiy on 09.10.2015.
 */
public class App {
    public static void main(String[] args) {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);

        Converter<String, Integer> converterSecond = Integer::valueOf;
        converted = converterSecond.convert("321123");
        System.out.println(converted);

        NumCharsCounter charsCounter = new NumCharsCounter();
        Converter<String, Integer> converterThird = charsCounter::count;
        converted = converterThird.convert("Hello");
        System.out.println(converted);
    }
}
