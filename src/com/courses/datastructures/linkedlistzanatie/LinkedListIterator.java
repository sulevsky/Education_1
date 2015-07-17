package com.courses.datastructures.linkedlistzanatie;

import java.util.Iterator;

/**
 * Created by VSulevskiy on 17.07.2015.
 */
public class LinkedListIterator implements Iterator {

    private Element currentElement;
    public LinkedListIterator(Element firstElement){
        this.currentElement = firstElement;
    }
    @Override
    public boolean hasNext() {
        return currentElement!=null;
    }

    @Override
    public Object next() {
        Object toReturn = currentElement.getData();
        currentElement = currentElement.getNext();
        return toReturn;
    }
}
