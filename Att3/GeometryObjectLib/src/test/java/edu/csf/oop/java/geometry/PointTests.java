package edu.csf.oop.java.geometry;

import edu.csf.oop.java.geometry.objects.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointTests {

    @Test
    public void testGetCoords() {
        Point p = new Point(1.5F, 0.5F);

        Point expectedPoint = new Point(1.5F, 0.5F);

        Assertions.assertEquals(expectedPoint.getX(), p.getX(), "Error in method 'getX()'");
        Assertions.assertEquals(expectedPoint.getY(), p.getY(), "Error in method 'getY()'");
    }

    @Test
    public void testSetCoords() {
        Point p = new Point();

        p.setX(1.5F);
        p.setY(0.5F);

        Assertions.assertEquals(1.5F, p.getX(), "Error in method 'setX()'");
        Assertions.assertEquals(0.5F, p.getY(), "Error in method 'setY()'");
    }

    @Test
    public void testSetLocation() {
        Point p = new Point();
        p.setLocation(1.5F, 0.5F);

        Assertions.assertEquals(1.5F, p.getX(), "Error");
        Assertions.assertEquals(0.5F, p.getY(), "Error");
    }

    @Test
    public void testEquals() {
        Point p1 = new Point(1.5F, 0.5F);
        Point p2 = new Point(1.5F, 0.5F);
        Point p3 = new Point(0.0F, 0.0F);

        Assertions.assertTrue(p1.equals(p2), "Points don't have identical coordinates");
        Assertions.assertFalse(p1.equals(p3), "The points turned out to be the same");
    }

    @Test
    public void testDistance() {
        Point p1 = new Point(1.5F, 0.5F);
        Point p2 = new Point(0.0F, 0.0F);
        final float EPS = (float) 1e-9;

        float expectedResult = 1.58113883F;

        Assertions.assertTrue(Math.abs(expectedResult - Point.distance(p1, p2)) < EPS,
                "Distances between points are different");
        Assertions.assertTrue(Math.abs(expectedResult - p1.distance(p2)) < EPS,
                "Distances between points are different");
        Assertions.assertTrue(Math.abs(expectedResult - Point.distance(p1.getX(), p1.getY(), p2.getX(), p2.getY())) < EPS,
                "Distances between points are different");
        Assertions.assertTrue(Math.abs(expectedResult - p1.distance(p2.getX(), p2.getY())) < EPS,
                "Distances between points are different");
    }
}
