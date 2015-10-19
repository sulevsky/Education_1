package com.courses.apachecommons.comparetobuilder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by VSulevskiy on 13.10.2015.
 */
public class PerformanceTest {

    public static List<Long> acResults =  new ArrayList<>();
    public static List<Long> prResults =  new ArrayList<>();
    public static List<Long> smResults =  new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < 30; i++) {
            System.out.println("Test #: " + i);
            test();
            System.out.println();
        }
        printStatistics();
    }

    private static void printStatistics() {
        System.out.println("Averarage time of execution (Apache commons): " +acResults.stream().mapToDouble(a -> a).average());
        System.out.println("Averarage time of execution (Primitive): "+prResults.stream().mapToDouble(a -> a).average());
        System.out.println("Averarage time of execution (Static method): " + smResults.stream().mapToDouble(a->a).average());
    }

    public static void test() {
        List<Holder> randomHolders = createMillionRandomHolders();

        long startObj = System.currentTimeMillis();
        Collections.sort(randomHolders, new ApacheCommonsComparator());
        long durObj = System.currentTimeMillis() - startObj;
        System.out.println("Object based comparator took ms: " + durObj);
        acResults.add(durObj);
        randomHolders = null;


        randomHolders = createMillionRandomHolders();
        long startPrim = System.currentTimeMillis();
        Collections.sort(randomHolders, new PrimitiveBasedComparator());
        long durPrim = System.currentTimeMillis() - startPrim;
        System.out.println("Primitive based comparator took ms: " + durPrim);
        prResults.add(durPrim);
        randomHolders = null;

        randomHolders = createMillionRandomHolders();
        long startSm = System.currentTimeMillis();
        Collections.sort(randomHolders, new StaticMethodComparator());
        long durSm = System.currentTimeMillis() -startSm;
        System.out.println("Static method based comparator took ms: " + durSm);
        smResults.add(durSm);

    }

    public static List<Holder> createMillionRandomHolders() {
        List<Holder> holders = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            Holder holder = Holder.createRandomHolder();
            holders.add(holder);
        }
        return holders;
    }
}
