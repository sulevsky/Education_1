package com.courses.datastructures.arraylist;

public class MyArrayList {
    private Object[] list;
    private int size;
    public MyArrayList() {
        this.size = 0;
        this.list = new Object[10];
    }

    public MyArrayList(int initialCapacity) {
        this.size = 0;
        if (initialCapacity >= 0) {
            this.list = new Object[initialCapacity];
        } else {
            this.list = new Object[10];//TODO warn
        }
    }

    public void add(Object object) {
        Object[] newList = new Object[size + 1];
        for (int i = 0; i < size; i++) {
            newList[i] = list[i];
        }
        newList[size] = object;
        list = newList;
        size++;
    }
    /**
    removes by index
     */
    public void remove(int index) {
        //TODO warn if index > size
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        list[size-1]=null;
        size--;
    }
    public int find(Object object){
        for(int i=0;i<size;i++){
            if(list[i].equals(object)){
                return i;
            }
        }
        return -1;//not found
    }
    /**
    removes first occurence
     */
    public void remove(Object object) {
        int index = find(object);
        if(index!=-1){
            remove(index);
        }
    }

    public boolean contains(Object object) {
        return find(object)!=-1;
    }

    public void addAll(MyArrayList input) {
        for (int i = 0; i < input.getSize(); i++) {
            this.add(input.get(i));
        }
    }

    public Object get(int i) {
        if (i < size && i >= 0) return list[i];
        else throw new IndexOutOfBoundsException();
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        this.size = 0;//TODO discuss with students
    }

    public boolean equalToOtherList(MyArrayList otherList) {
        if (otherList == null) {
            return false;
        }
        if (this.getSize() != otherList.getSize()) {
            return false;
        }
        for (int i = 0; i < getSize(); i++) {
            if (!this.get(i).equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }


    private void print() {
        System.out.print("List: ");
        for (int i = 0; i < size-1; i++) {
            System.out.print(list[i] + ", ");
        }
        System.out.print(list[size-1]);
        System.out.println();
    }

    public static void main(String[] args) {
        //simple testing
        MyArrayList list = new MyArrayList();
//
//        //add
//        list.add(3);
//        list.add(4);
//        list.print();
//
//        //getSize
//        System.out.println(list.getSize());//2
//
//        //remove
//        list.remove(0);
//        list.print();
//
//        //contains
//        System.out.println(list.contains(4));
//        System.out.println(list.contains(5));
//
//        //addAll
        MyArrayList list2 = new MyArrayList(100);
//        list2.add(7);
//        list2.add(5);
//        list2.add(6);
//        list.addAll(list2);
//        list.print();
        MyArrayList list3 = new MyArrayList(1000);//empty
//        list.addAll(list3);
//        list.print();
//
//        //equalsToOtherList
//        System.out.println(list.equalToOtherList(list3));//false
//        MyArrayList list4 = new MyArrayList(100);
//        list4.add(4);
//        list4.add(5);
//        list4.add(6);
//        list4.add(7);
//        System.out.println(list.equalToOtherList(list4));//true

//        int[] toMergeOne = {1,2,3,4};
//        int[] toMergeTwo = {2,5,7};
//        int[] r= list.merge(toMergeOne,toMergeTwo);
//        int[] sorted = list.mergeSort(new int[]{8,4,5,77,8,2,7,0,-1});
//        System.out.println(Arrays.toString(sorted));

//        list.print();

    }

}
