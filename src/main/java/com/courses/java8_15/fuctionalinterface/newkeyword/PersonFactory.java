package com.courses.java8_15.fuctionalinterface.newkeyword;

/**
 * Created by VSulevskiy on 09.10.2015.
 */
public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
