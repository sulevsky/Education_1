package com.courses.serializationtest;

import java.io.Serializable;

/**
 * Created by VSulevskiy on 02.07.2015.
 */
public class HolderOne implements Serializable{

    private static final long serialVersionUID = 1L;
    private String name;
    private int id;

    public HolderOne(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
