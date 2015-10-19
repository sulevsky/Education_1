package com.courses.apachecommons.comparetobuilder;

import java.util.Random;

/**
 * Created by VSulevskiy on 13.10.2015.
 */
public class Holder {
    private int id;

    private int linkId;

    private int shapePointVertexIndex;

    private int relativeIndex;

    public Holder() {
    }
    public static Holder createRandomHolder(){
        Holder holder = new Holder();
        Random random = new Random();
        holder.setId(random.nextInt());
        holder.setLinkId(random.nextInt());
        holder.setRelativeIndex(random.nextInt());
        holder.setShapePointVertexIndex(random.nextInt());

        return holder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public int getShapePointVertexIndex() {
        return shapePointVertexIndex;
    }

    public void setShapePointVertexIndex(int shapePointVertexIndex) {
        this.shapePointVertexIndex = shapePointVertexIndex;
    }

    public int getRelativeIndex() {
        return relativeIndex;
    }

    public void setRelativeIndex(int relativeIndex) {
        this.relativeIndex = relativeIndex;
    }
}
