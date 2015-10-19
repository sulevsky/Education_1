package com.courses;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.LineSegment;

/**
 * Created by VSulevskiy on 13.10.2015.
 */
public class TestDistance
{
    public static void main(String[] args) {
        Coordinate coordinateLineStart = new Coordinate(0.0, 0.0);
        Coordinate coordinateLineEnd = new Coordinate(1.0, 1.0);
        LineSegment lineSegment1 = new LineSegment(coordinateLineStart, coordinateLineEnd);

        Coordinate coordinateLineStart2 = new Coordinate(1.0, 1.0);
        Coordinate coordinateLineEnd2 = new Coordinate(0.0, 2.0);
        LineSegment lineSegment2 = new LineSegment(coordinateLineEnd2, coordinateLineStart2);
        Coordinate coordinateLineTest = new Coordinate(3.0, 1.0);

        System.out.println(lineSegment1.distance(coordinateLineTest));
        System.out.println(lineSegment2.distance(coordinateLineTest));


    }
}
