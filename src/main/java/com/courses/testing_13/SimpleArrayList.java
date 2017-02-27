package com.courses.testing_13;


/**
 * Created by VSulevskiy on 22.09.2015.
 */
public class SimpleArrayList {

    private int[] data = new int[10];
    private int size = 0;
    public boolean add(int i) {
        if(i<0)throw new IndexOutOfBoundsException("HEllo");
        if(data.length>size){
            data[size] = i;
            size++;
            return true;
        }
        else{
            int[] newData = new int[data.length*2];
            System.arraycopy(data,0,newData,0,data.length);
            data = newData;
            data[size] = i;
            size++;
            return true;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }
}
