package com.courses.java8_15.fuctionalinterface;

/**
 * Created by VSulevskiy on 09.10.2015.
 */
@FunctionalInterface
public interface Converter<F,T> {
    T convert(F from);
}
