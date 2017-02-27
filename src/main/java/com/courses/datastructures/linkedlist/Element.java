package com.courses.datastructures.linkedlist;

/**
 * Created by Vladimir Sulevskiy on 07.07.2015.
 */
public class Element {
    Element next;
    Object data;

    public Element(Element next, Object data) {
        this.next = next;
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        return data.equals(((Element)obj).data);
    }
}
