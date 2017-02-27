package com.courses.datastructures.linkedlisttest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Vovka on 08.12.2015.
 */
public class LinkedListTest {
    LinkedList linkedList;

    @Before
    public void setUp() {
        linkedList = new LinkedList();
    }

    @Test
    public void testSizeEmpty() {
        int size = linkedList.size();
        Assert.assertEquals("Expected empty collection",0, size);
    }

    @Test
    public void testSizeNotEmpty() {
        Integer first = 1;
        Integer second = 2;
        linkedList.add(first);
        linkedList.add(second);
        Assert.assertEquals(2, linkedList.size());
    }

    @Test
    public void testRemove() {
        Integer first = 1;
        Integer second = 2;
        linkedList.add(first);
        linkedList.add(second);

        boolean result = linkedList.remove(0);
        Assert.assertEquals(2, linkedList.size());
        Assert.assertFalse(result);

        result = linkedList.remove(1);
        Assert.assertEquals(1, linkedList.size());
        Assert.assertTrue(result);
        linkedList.remove(2);
        Assert.assertEquals(0, linkedList.size());
    }

}
