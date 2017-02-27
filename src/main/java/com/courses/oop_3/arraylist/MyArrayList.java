package com.courses.oop_3.arraylist;

/*
Container for int only
for implementation of container for Objects
see com.courses.datastructures.arraylist.MyArrayList.java
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
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("error");
        }

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

    public void sort(){
        list = mergeSort(list);
    }
    private int[] mergeSort(int[] listOne){
        if(listOne.length<=1) return listOne;
        else {
            int[] fpart = new int[listOne.length/2];
            int fpartIt =0;
            int[] spart = new int[listOne.length/2+listOne.length%2];
            int spartIt =0;
            for(int i = 0;i<listOne.length;i++){
                if(i<listOne.length/2){
                    fpart[fpartIt]=listOne[i];
                    fpartIt++;
                }else {
                    spart[spartIt]=listOne[i];
                    spartIt++;

                }
            }
            fpart = mergeSort(fpart);
            spart = mergeSort(spart);
            int[] result = merge(fpart,spart);
            return result;

        }
    }

    private int[] merge(int[] listOne,int[] listTwo) {
        int[] rez = new int[listOne.length+listTwo.length];
        int firstIt = 0;
        int secondIt = 0;
        int count=0;
        while(firstIt<listOne.length || secondIt<listTwo.length ){
            if(firstIt<listOne.length && (secondIt==listTwo.length || listOne[firstIt]<listTwo[secondIt]) ){
                rez[count] = listOne[firstIt];
                firstIt++;
            }else if(secondIt<listTwo.length  && (firstIt==listOne.length || listOne[firstIt]>=listTwo[secondIt]) ){
                rez[count] = listTwo[secondIt];
                secondIt++;
            }
            count++;
        }
        return rez;
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
        list2.add(7);
        list2.add(5);
        list2.add(6);
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

//        int[] toMergeOne = {1,2,3,4};
//        int[] toMergeTwo = {2,5,7};
//        int[] r= list.merge(toMergeOne,toMergeTwo);
//        int[] sorted = list.mergeSort(new int[]{8,4,5,77,8,2,7,0,-1});
//        System.out.println(Arrays.toString(sorted));

        //sort
        list.sort();
        list.print();

    }
}
