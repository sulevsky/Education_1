package com.courses.io_8.serializationtest;

import java.io.Serializable;

/**
 * Created by VSulevskiy on 02.07.2015.
 */
public class HolderTwo implements Serializable{

    private static final long serialVersionUID = 1L;
    private long name;

    public long getName() {
        return name;
    }

    public void setName(long name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

}
