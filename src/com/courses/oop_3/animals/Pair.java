package com.courses.oop_3.animals;

/**
 * Created by VSulevskiy on 04.08.2015.
 */
public class Pair<T,K> {
    public T first;
    public T second;
    public K third;

    public Pair(T first, T second, K third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

}
