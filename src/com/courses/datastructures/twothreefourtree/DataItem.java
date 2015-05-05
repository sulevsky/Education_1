package com.courses.datastructures.twothreefourtree;

/**
 * Created by Vladimir on 03.05.2015.
 */
public class DataItem {
    private long key;

    public DataItem(long key) {
        this.key = key;
    }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "/" + key;
    }
}
