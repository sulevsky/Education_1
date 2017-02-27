package com.courses.apachecommons.comparetobuilder;

import java.util.Comparator;

/**
 * Created by VSulevskiy on 13.10.2015.
 */
public class StaticMethodComparator implements Comparator<Holder> {

    @Override
    public int compare(Holder o1, Holder o2) {
        if ( Integer.compare(o1.getLinkId(), o2.getLinkId())!=0 ) {
            return Integer.compare(o1.getLinkId(), o2.getLinkId());
        }
        if(Integer.compare(o1.getShapePointVertexIndex(), o2.getShapePointVertexIndex())!=0 ){
            return Integer.compare(o1.getShapePointVertexIndex(), o2.getShapePointVertexIndex());
        }
        if(Integer.compare(o1.getRelativeIndex(), o2.getRelativeIndex())!=0 ){
            return Integer.compare(o1.getRelativeIndex(), o2.getRelativeIndex());
        }
        return 0;

    }
}
