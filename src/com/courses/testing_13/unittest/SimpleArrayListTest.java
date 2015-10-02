package com.courses.testing_13.unittest;

import com.courses.testing_13.SimpleArrayList;
import org.junit.*;

import static org.junit.Assert.*;

public class SimpleArrayListTest {

    SimpleArrayList arrayList;

    @BeforeClass
    public static void setUpAll(){
        System.out.println("set up all");
    }

    @Before
    public void setUp() {
        System.out.println("B1");
        arrayList = new SimpleArrayList();
    }
    @Test
    public void additionTest() {
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        assertEquals(4, arrayList.size());
    }
    @Test
    public void isEmptyTest(){
        assertEquals(true, arrayList.isEmpty());
        arrayList.add(1);
        assertFalse(arrayList.isEmpty());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void nullAdditionTest(){

        arrayList.add(-1);
    }
    @After
    public void tearDown(){
        System.out.println("Complete");
    }

    @AfterClass
    public static void tearDownAll(){
        System.out.println("Tear down all");
    }
}
