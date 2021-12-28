package edu.csf.oop.java.geometry;

import edu.csf.oop.java.geometry.objects.Point;
import edu.csf.oop.java.geometry.objects.Polygon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PolygonTests {

    @Test
    public void testSquareForTriangle() {
        Point p1 = new Point(0.0F, 0.0F);
        Point p2 = new Point(0.0F, 4.0F);
        Point p3 = new Point(4.0F, 0.0F);

        List<Point> points = Arrays.asList(p1, p2, p3);

        Polygon triangle = new Polygon(points);

        float expectedSquare = 8.0F;
        float squareOfTriangle = triangle.squareOfPolygon();

        Assertions.assertEquals(expectedSquare, squareOfTriangle);
    }

    @Test
    public void testSquareForPolygon4() {
        Point p1 = new Point(0.0F, 0.0F);
        Point p2 = new Point(0.0F, 4.0F);
        Point p3 = new Point(4.0F, 4.0F);
        Point p4 = new Point(4.0F, 0.0F);

        List<Point> points = Arrays.asList(p1, p2, p3, p4);

        Polygon polygon4 = new Polygon(points);

        float expectedSquare = 16.0F;
        float squareOfPolygon = polygon4.squareOfPolygon();

        Assertions.assertEquals(expectedSquare, squareOfPolygon);
    }
}
