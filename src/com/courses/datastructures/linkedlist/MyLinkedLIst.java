package com.courses.datastructures.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by Vladimir Sulevskiy on 07.07.2015.
 */
public class MyLinkedList {
    private Element firstElement;

    public MyLinkedList() {
        firstElement = null;
    }

    public int size() {
        int size = 0;
        Element currentElement = firstElement;
        while (currentElement != null) {
            currentElement = currentElement.next;
            size++;
        }
        return size;
    }

    public boolean isEmpty() {
        return firstElement == null;
    }

    public boolean contains(Object o) {
        return find(o) != -1;
    }

    /**
     * @param o object to find
     * @return index of the first occurrence of the
     * element, -1 if object is not present in list
     */
    public int find(Object o) {
        if (firstElement == null) {
            return -1;
        }
        Element pointerToCurrentElement = firstElement;
        int index = 0;
        while (pointerToCurrentElement != null) {
            if (pointerToCurrentElement.data.equals(o)) {
                return index;
            }
            index++;
            pointerToCurrentElement = pointerToCurrentElement.next;
        }
        return -1;
    }

    public boolean add(Object o) {
        append(o);
        return true;
    }

    public boolean addToIndex(Object o, int index) {
        if (index == 0) {
            Element toPut = new Element(firstElement, o);
            firstElement = toPut;
        } else if (index == size()) {
            //index of size is valid index therefore validation is in only one branch
            append(o);
        } else {
            validateIndex(index);
            Element before = get(index - 1);
            Element after = before.next;
            Element toPut = new Element(after, o);
            before.next = toPut;
        }
        return true;
    }

    private Element get(int index) {
        validateIndex(index);
        Element pointerToCurrentElement = firstElement;
        int currentElement = 0;
        while (currentElement < index) {
            pointerToCurrentElement = pointerToCurrentElement.next;
            currentElement++;
        }
        return pointerToCurrentElement;
    }

    private void validateIndex(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Element getLastElement() {
        if (size() == 0) {
            return null;
        } else {
            return get(size() - 1);
        }
    }

    private void append(Object o) {
        Element toAppend = new Element(null, o);
        append(toAppend);
    }

    private void append(Element element) {
        Element lastElement = getLastElement();
        if (lastElement == null) {
            firstElement = element;
        } else {
            lastElement.next = element;
        }
    }

    public boolean addAll(Collection c) {
        for (Object o : c) {
            append(o);
        }
        return true;
    }

    public void clear() {
        firstElement = null;
    }

    public boolean containsAll(Collection c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param index of removing element
     */
    public boolean remove(int index) {
        validateIndex(index);
        if (index == 0) {
            firstElement = firstElement.next;
        } else {
            Element before = get(index - 1);
            Element after = before.next.next;
            before.next = after;
        }
        return true;
    }

    public boolean remove(Object o) {
        int index = find(o);
        if (index == -1) {
            return false;
        } else {
            return remove(index);
        }
    }

    public boolean removeAll(Collection c) {
        boolean isRemoved = false;
        for (Object o : c) {
            boolean result = remove(o);
            if (result) {
                isRemoved = true;
            }
            while (!result){
                result = remove(o);//remove all other occurrences
            }
        }
        return isRemoved;
    }

    public boolean retainAll(Collection c) {
        boolean result = false;
        MyLinkedList temp = new MyLinkedList();
        Element currentElement = firstElement;

        while (currentElement != null) {
            if (c.contains(currentElement.data)) {
                temp.append(currentElement);
            } else {
                result = true;
            }
            currentElement = currentElement.next;
        }
        this.firstElement = temp.firstElement;
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        Element currentElement = firstElement;
        while (currentElement != null) {
            result += currentElement.data + " -> ";
            currentElement = currentElement.next;
        }
        return result;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
//        System.out.println(list);
//        System.out.println(list.size());
        list.add(2.5);
//        System.out.println(list);
//        System.out.println(list.size());
        list.add(3.5);
        list.add(4.5);
        list.add(2.5);
//        System.out.println(list);
//        System.out.println(list.size());
//        list.remove(2.5);
//        System.out.println(list);
//        System.out.println(list.size());
//        list.remove(2.5);
//        System.out.println(list);
//        System.out.println(list.size());
//        list.remove(2.5);
//        System.out.println(list);
//        System.out.println(list.size());
//        int index = list.find(4.5);
//        System.out.println(index);
//        System.out.println(list.isEmpty());
//        System.out.println(list.contains(3.5));
//        list.addToIndex(5.5, 0);
//        list.add(5.5);
        System.out.println(list);
        list.retainAll(Arrays.asList(2.5, 3.5, 4.5));
        System.out.println(list);

    }
}
