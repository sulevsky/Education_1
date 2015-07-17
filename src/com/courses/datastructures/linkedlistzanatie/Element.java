package com.courses.datastructures.linkedlistzanatie;

/**
 * Created by VSulevskiy on 17.07.2015.
 */
public class Element {

    private Element next;
    private Object data;

    public Element(Element next, Object data) {
        this.next = next;
        this.data = data;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
