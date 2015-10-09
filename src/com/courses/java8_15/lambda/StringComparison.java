package com.courses.java8_15.lambda;

import java.util.*;

/**
 * Created by VSulevskiy on 09.10.2015.
 */
public class StringComparison {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        //1
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        //2
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        //3
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        //4
        Collections.sort(names, (a, b) -> b.compareTo(a));

        System.out.println(names);

    }
}
