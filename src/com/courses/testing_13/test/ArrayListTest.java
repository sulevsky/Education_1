package com.courses.testing_13.test;

import com.courses.testing_13.SimpleArrayList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by VSulevskiy on 22.09.2015.
 */
public class ArrayListTest {
    @Test
    public void addTest(){
        SimpleArrayList arrayList = new SimpleArrayList();
        arrayList.add((Integer)4);
        assertEquals(arrayList.size(), 1);
        assertTrue(arrayList.size()==1);

    }
}
