package com.courses.apachecommons.comparetobuilder;

import org.apache.commons.lang3.builder.CompareToBuilder;

import java.util.Comparator;

/**
 * Created by VSulevskiy on 13.10.2015.
 */
public class ApacheCommonsComparator implements Comparator<Holder> {
    @Override
    public int compare(Holder o1, Holder o2) {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(o1.getLinkId(),o2.getLinkId());
        builder.append(o1.getShapePointVertexIndex(),o2.getShapePointVertexIndex());
        builder.append(o1.getRelativeIndex(),o2.getRelativeIndex());

        return builder.toComparison();
    }
}
