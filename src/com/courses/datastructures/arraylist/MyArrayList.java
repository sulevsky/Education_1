package com.courses.datastructures.arraylist;

/**
 * Created by VSulevskiy on 09.06.2015.
 */
public class MyArrayList {
    private int[] list;
    private int size;
    public MyArrayList(){
        this.size = 0;
        this.list = new int[0];
    }
    public void add(int value){
        int[] newList = new int[size+1];
        for (int i = 0;i<size;i++){
            newList[i]= list[i];
        }
        newList[size]=value;
        list = newList;
        size++;
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(3);
//        list.add(3);

    }
}
