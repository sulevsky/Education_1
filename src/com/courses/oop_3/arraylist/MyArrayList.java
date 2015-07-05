package com.courses.oop_3.arraylist;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by VSulevskiy on 09.06.2015.
 */
public class MyArrayList {
    private int[] list;
    private int size;

    public MyArrayList() {
        this.size = 0;
        this.list = new int[10];
    }

    public MyArrayList(int initialCapacity) {
        this.size = 0;
        if (initialCapacity >= 0) {
            this.list = new int[initialCapacity];
        } else {
            this.list = new int[10];//TODO warn
        }
    }

    public void add(int value) {
        int[] newList = new int[size + 1];
        for (int i = 0; i < size; i++) {
            newList[i] = list[i];
        }
        newList[size] = value;
        list = newList;
        size++;
    }

    public void remove(int index) {
        //TODO warn if index > size
        for(int i = index;i<size-1;i++){
            list[i]=list[i+1];
        }
        size--;
    }

    public boolean contains(int query){
        for (int el : list) {
            if(el==query){
                return true;
            }
        }
        return false;
    }
    public void addAll(MyArrayList input){
        for(int i=0;i<input.getSize();i++){
            this.add(input.get(i));
        }
    }

    public int get(int i) {
        if(i<size && i>=0)return list[i];
        else throw new IndexOutOfBoundsException();
    }

    public int getSize() {
        return size;
    }

    public void clear(){
        this.size = 0;//TODO discuss with students
    }

    public boolean equalToOtherList(MyArrayList otherList){
        if(otherList==null){
            return false;
        }
        if(this.getSize()!=otherList.getSize()){
            return false;
        }
        for(int i=0;i<getSize();i++){
            if(this.get(i)!=otherList.get(i)){
                return false;
            }
        }
        return true;
    }

    private void print(){
        System.out.print("List: ");
        for(int i=0;i<size;i++){
            System.out.print(list[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //simple testing
        MyArrayList list = new MyArrayList();

        //add
        list.add(3);
        list.add(4);
        list.print();

        //getSize
        System.out.println(list.getSize());//2

        //remove
        list.remove(0);
        list.print();

        //contains
        System.out.println(list.contains(4));
        System.out.println(list.contains(5));

        //addAll
        MyArrayList list2 = new MyArrayList(100);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list.addAll(list2);
        list.print();
        MyArrayList list3 = new MyArrayList(1000);//empty
        list.addAll(list3);
        list.print();

        //equalsToOtherList
        System.out.println(list.equalToOtherList(list3));//false
        MyArrayList list4 = new MyArrayList(100);
        list4.add(4);
        list4.add(5);
        list4.add(6);
        list4.add(7);
        System.out.println(list.equalToOtherList(list4));//true





    }
}
