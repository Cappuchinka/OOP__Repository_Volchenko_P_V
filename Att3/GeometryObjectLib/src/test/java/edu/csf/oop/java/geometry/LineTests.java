package edu.csf.oop.java.geometry;

import edu.csf.oop.java.geometry.objects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LineTests {

    @Test
    public void testGetCoords() {
        Line line = new Line(new Point(0.0F, 0.0F), new Point(2.5F, 5.0F));

        Point expectedStart = new Point(0.0F, 0.0F);
        Point expectedFinish = new Point(2.5F, 5.0F);

        Assertions.assertTrue(expectedStart.equals(line.getStart()));
        Assertions.assertTrue(expectedFinish.equals(line.getFinish()));
    }

    @Test
    public void testSetCoords() {
        Point start = new Point(0.0F, 0.0F);
        Point finish = new Point(2.5F, 5.0F);

        Line line = new Line();

        line.setStart(start);
        line.setFinish(finish);

        Assertions.assertTrue(new Point(0.0F, 0.0F).equals(line.getStart()));
        Assertions.assertTrue(new Point(2.5F, 5.0F).equals(line.getFinish()));
    }

    @Test
    public void testSetLocation() {
        Line line = new Line();

        line.setLocation(new Point(0.0F, 0.0F), new Point(2.5F, 5.0F));

        Line expectedLine = new Line(new Point(0.0F, 0.0F), new Point(2.5F, 5.0F));

        Assertions.assertTrue(expectedLine.getStart().equals(line.getStart()));
        Assertions.assertTrue(expectedLine.getFinish().equals(line.getFinish()));
    }

    @Test
    public void testEquals() {
        Line l1 = new Line(0.0F, 0.0F, 2.5F, 5.0F);
        Line l2 = new Line(new Point(0.0F, 0.0F), new Point(2.5F, 5.0F));
        Line l3 = new Line(new Point(2.5F, 5.0F), new Point(0.0F, 0.0F));

        Assertions.assertTrue(l1.equals(l2));
        Assertions.assertTrue(l1.equals(l3));
        Assertions.assertTrue(l2.equals(l3));
    }

    @Test
    public void testGetLength() {
        Line line = new Line(0.0F, 0.0F, 2.5F, 5.0F);

        float expectedLength = 5.59016994F;
        float length = line.getLength();

        final float EPS = (float) 1e-9;

        Assertions.assertTrue(Math.abs(expectedLength - length) < EPS);
    }
}
