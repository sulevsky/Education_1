package com.courses.datastructures.hashtable;

import com.courses.oop_3.oop_1.Student;

import java.util.Arrays;
import java.util.LinkedList;

public class HashTable {
    private static final int DEFAULT_TABLE_SIZE = 10;
    private LinkedList[] table = new LinkedList[DEFAULT_TABLE_SIZE];
    public void put(Object key, Object value){
        int index = Math.abs(key.hashCode())%DEFAULT_TABLE_SIZE;

        LinkedList linkedList = table[index];
        if(linkedList==null){
            linkedList = new LinkedList();
        }
        Entry entryToAdd = new Entry(key,value);
        if(!linkedList.contains(entryToAdd)) {
            linkedList.add(entryToAdd);
        }
        table[index]=linkedList;
    }

    public Object get(Object key){
        int index = Math.abs(key.hashCode())%DEFAULT_TABLE_SIZE;
        LinkedList list= table[index];
        if(list==null) return null;
        for(Object entryFromList : list){
            Entry entry = (Entry)entryFromList;
            if(entry.getKey().equals(key)){
                return entry.getValue();
            }
        }
        return null;
    }


    public static class Entry{
        private Object key;
        private Object value;
        public Entry(Object key, Object value){
            this.key = key;
            this.value = value;
        }
        public Object getKey() {
            return key;
        }
        public Object getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Entry entry = (Entry) o;

            if (key != null ? !key.equals(entry.key) : entry.key != null) return false;
            return !(value != null ? !value.equals(entry.value) : entry.value != null);

        }

    }

    @Override
    public String toString() {
        return "HashTable{" +
                "table=" + Arrays.toString(table) +
                '}';
    }

    public static void main(String[] args) {
        Student ivanov =
                new Student(2, "Ivanov", new int[]{5,5,4});
        HashTable table = new HashTable();
        table.put(ivanov, 100);

        System.out.println(table);
        ivanov.getMarks()[0]=2;
//        Object gotFromTable = table.get(ivanov);
        table.put(ivanov, 100);
        System.out.println(table);





    }








}
