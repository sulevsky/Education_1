package com.courses.apachecommons.comparetobuilder;

import java.util.Comparator;

/**
 * Created by VSulevskiy on 13.10.2015.
 */
public class PrimitiveBasedComparator implements Comparator<Holder> {

    @Override
    public int compare(Holder o1, Holder o2) {
        if (o1.getLinkId()> o2.getLinkId()) {
            return 1;
        }else if(o1.getLinkId()< o2.getLinkId()){
            return -1;
        }

        if (o1.getShapePointVertexIndex()> o2.getShapePointVertexIndex())
        {
            return 1;
        }else if(o1.getShapePointVertexIndex()< o2.getShapePointVertexIndex()){
            return -1;
        }

        if (o1.getRelativeIndex()> o2.getRelativeIndex()) {
            return 1;
        }else if(o1.getRelativeIndex()< o2.getRelativeIndex()){
            return -1;
        }
        return 0;

    }
}
