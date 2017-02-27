package com.courses.datastructures.linkedlisttest;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Vovka on 08.12.2015.
 */
public class LinkedList implements Collection {
    private Node first;

    public LinkedList() {
    }

    @Override
    public int size() {
        int size = 0;
        Node currentElement = first;
        while (currentElement != null) {
            currentElement = currentElement.getNext();
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        Node last = getLast();

        Node addedNode = new Node(o, null);
        if (last == null) {
            first = addedNode;
        } else {
            last.setNext(addedNode);
        }
        return true;
    }

    private Node getLast() {
        if (first == null) {
            return null;
        }
        Node currentNode = first;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }


    @Override
    public boolean remove(Object o) {
        Node nodeToRemove = findFirstNode(o);
        if(nodeToRemove == null){
            return false;
        }
        Node previousNode = findPreviousNode(nodeToRemove);


        return false;
    }

    private Node findPreviousNode(Node nodeToRemove) {
        if(first.equals(nodeToRemove)){
            return null;
        }
        Node currentNode = first;
        if (currentNode == null) {
            return null;
        }
        while (currentNode.getNext() != null && !currentNode.getNext().equals(nodeToRemove)) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    private Node findFirstNode(Object o) {
        Node currentNode = first;
        if (currentNode == null) {
            return null;
        }
        while (currentNode != null &&
                !currentNode.getData().equals(o)
                ) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }


    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        first = null;
    }
}
