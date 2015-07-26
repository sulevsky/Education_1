package com.courses.datastructures.tree;

/**
 * Created by VSulevskiy on 24.07.2015.
 */
public class Tree {
    private Node root;

    public void add(Object object){
        Node node = new Node(object);
        add(node);
    }


    private void add(Node newNode){
        if(root==null){
            root = newNode;
        }
        add(root, newNode);
    }

    private void add(Node addTo, Node newNode){
        Object addTooObj = addTo.getData();
        Object newNodeObj = newNode.getData();
        Comparable addToComparable = (Comparable)addTooObj;
        Comparable newNodeComparable = (Comparable)newNodeObj;
        if(addToComparable.compareTo(newNodeComparable)>0){
            if(addTo.getLeft()==null){
                addTo.setLeft(newNode);
            }else {
                add(addTo.getLeft(), newNode);
            }
        } else if(addToComparable.compareTo(newNodeComparable)<0){
            if(addTo.getRight()==null){
                addTo.setRight(newNode);
            }
            else {
                add(addTo.getRight(), newNode);
            }
        }

    }



    @Override
    public String toString() {
        return null;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node node = new Node(1);
        tree.add(3);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        System.out.println(tree);
    }
    private static class Node {
        private Object data;
        private Node left;
        private Node right;

        public Node(Object data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Object getData() {
            return data;
        }
    }
}
