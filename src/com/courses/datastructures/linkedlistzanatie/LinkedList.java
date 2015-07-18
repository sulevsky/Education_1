package com.courses.datastructures.linkedlistzanatie;

import java.util.Collection;
import java.util.Iterator;

public class LinkedList implements Collection{
    private Element first;

    //TODO optimize
    @Override
    public int size() {
        int size = 0;
        Element currentElement = first;
        while(currentElement!=null){
            currentElement = currentElement.getNext();
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public boolean contains(Object o) {
        Element currentElement = first;
        while(currentElement!=null){
            if(currentElement.getData().equals(o)){
                return true;
            }
            currentElement = currentElement.getNext();
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator(first);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        Element toAdd = new Element(null, o);
        Element lastElement = getLastElement();
        if(lastElement==null){
            first = toAdd;
        }else{
            lastElement.setNext(toAdd);
        }
        return true;
    }

    private Element getLastElement(){
        Element lastElement = first;
        if (lastElement == null) {
            return lastElement;
        }
        while (lastElement.getNext() != null) {
            lastElement = lastElement.getNext();
        }
        return lastElement;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        if(c==null || c.isEmpty()){
            return false;
        }
        for (Object o : c){
            add(o);
        }
        return true;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public String toString(){
        String result = "";
        Element currentElement = first;
        if(currentElement==null){
            return result;
        }
        while (currentElement != null) {
            result += currentElement.getData() + ", ";
            currentElement = currentElement.getNext();
        }
        return result;
    }

    private String printBackWards(Element start) {
//        if(start== null) System.out.printf("null");
        if (start.getNext() == null) return start.getData().toString();
        return printBackWards(start.getNext()) + ", " + start.getData();
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.add(2.5);
        double d  = 3.5;
        list1.add(d);
        list1.add(5.5);
        System.out.println(list1.printBackWards(list1.first));
    }
}
