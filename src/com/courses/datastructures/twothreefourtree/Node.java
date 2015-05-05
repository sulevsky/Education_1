package com.courses.datastructures.twothreefourtree;

/**
 * Created by Vladimir on 03.05.2015.
 */
public class Node {
    private static final int ORDER = 4;
    private Node[] childArray = new Node[ORDER];
    private DataItem[] itemArray =  new DataItem[ORDER-1];
    private int numItems;

    private Node parent;

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    private void connectChild(int childNum, Node child){
        childArray[childNum] = child;
        if(child!=null) {
            child.setParent(this);
        }
    }

    private Node disconnectChild(int childNum){
        Node result = childArray[childNum];
        childArray[childNum] = null;
        return result;
    }
    private Node getChild(int childNum){
        return childArray[childNum];
    }
    private boolean isLeaf(){
        return childArray[0]==null?true:false;
    }

    public int getNumItems() {
        return numItems;
    }
    public DataItem getItem(int index){
        return itemArray[index];
    }
    public boolean isFull(){
        return numItems == ORDER-1;
    }
    public int findItem(long key){
        int index=0;
        for (DataItem dataItem: itemArray){
            if(dataItem==null) {
                break;
            }
            else if(dataItem.getKey()==key){
                return index;
            }
            index++;
        }
        return -1;
    }
}
