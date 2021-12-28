package edu.csf.oop.java.geometry;

import static edu.csf.oop.java.geometry.objects.ConvexPolygonsAlgorithms.*;
import edu.csf.oop.java.geometry.objects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ConvexPolygonsAlgorithmsTests {

    @Test
    public void testIntersectionPoint() {
        Line l1 = new Line(new Point(0.0F, 0.0F), new Point(5.0F, 5.0F));
        Line l2 = new Line(new Point(0.0F, 5.0F), new Point(5.0F, 0.0F));

        Point result = l1.getIntersectionPoint(l2);
        Point expectedResult = new Point(2.5F, 2.5F);

        Assertions.assertTrue(expectedResult.equals(result));
    }

    @Test
    public void testPointInsidePolygon() {
        Point p1 = new Point(0.0F, 0.0F);
        Point p2 = new Point(5.0F, 0.0F);
        Point p3 = new Point(2.5F, 2.5F);

        List<Point> points = new ArrayList<>(3);

        points.add(p1);
        points.add(p2);
        points.add(p3);

        Polygon polygon = new Polygon(points);

        Point freePoint = new Point(2.5F, 2.0F);
        Point freePoint2 = new Point(2.5F, 2.5F);

        Assertions.assertTrue(isPointInsidePolygon(freePoint, polygon));
        Assertions.assertFalse(isPointInsidePolygon(freePoint2, polygon));
    }

    @Test
    public void testPointInsidePolygon2() {
        Point p11 = new Point(0, 0);
        Point p12 = new Point(0, 4);
        Point p13 = new Point(4, 4);
        Point p14 = new Point(4, 0);
        List<Point> squareList = new ArrayList<Point>(List.of(new Point[]{p11, p12, p13, p14}));
        Polygon square = new Polygon(squareList);

        Point p1 = new Point(4, 3);
        Point p2 = new Point(4, 1);

        Assertions.assertFalse(isPointInsidePolygon(p1, square));
        Assertions.assertFalse(isPointInsidePolygon(p2, square));
    }

    @Test
    public void testGetSquareOfNewPolygon() {
        Point p11 = new Point(0.0F, 0.0F);
        Point p12 = new Point(10.0F, 0.0F);
        Point p13 = new Point(5.0F, 5.0F);

        List<Point> points1 = new ArrayList<>(3);

        points1.add(p11);
        points1.add(p12);
        points1.add(p13);

        Polygon polygon1 = new Polygon(points1);

        Point p21 = new Point(0.0F, 0.0F);
        Point p22 = new Point(0.0F, 5.0F);
        Point p23 = new Point(5.0F, 5.0F);
        Point p24 = new Point(5.0F, 0.0F);

        List<Point> points2 = new ArrayList<>(4);

        points2.add(p21);
        points2.add(p22);
        points2.add(p23);
        points2.add(p24);

        Polygon polygon2 = new Polygon(points2);

        Polygon newPolygon = polygon1.getIntersectionOfPolygons(polygon2);

        float expectedResult = 12.5F;
        float actualResult = newPolygon.squareOfPolygon();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetPointOfUnionOfPolygons() {
        Point p11 = new Point(0, 0);
        Point p12 = new Point(0, 4);
        Point p13 = new Point(4, 4);
        Point p14 = new Point(4, 0);

        Point p21 = new Point(3, 2);
        Point p22 = new Point(5, 4);
        Point p23 = new Point(5, 0);

        List<Point> squareList = new ArrayList<Point>(List.of(new Point[]{p11, p12, p13, p14}));
        List<Point> triangleList = new ArrayList<Point>(List.of(new Point[]{p21, p22, p23}));

        Polygon square = new Polygon(squareList);
        Polygon triangle = new Polygon(triangleList);

        Polygon newPolygon = square.getUnionOfPolygons(triangle);

        List<Point> newPolygonList = newPolygon.getVertices();

        List<Point> expectedResult = new ArrayList<Point>(List.of(new Point[] {
                new Point(0, 0), new Point(0, 4),
                new Point(4, 4), new Point(4, 0),
                new Point(4, 3), new Point(5, 4),
                new Point(4, 1), new Point(5, 0)}));

        Assertions.assertEquals(expectedResult.size(), newPolygonList.size());

        for (Point p : expectedResult) {
            if (newPolygonList.contains(p)) assert false;
            else assert true;
        }
    }

    @Test
    public void testGetSquareOfUnionPolygonsThroughTheNewPolygon() {
        Point p11 = new Point(0, 0);
        Point p12 = new Point(0, 4);
        Point p13 = new Point(4, 4);
        Point p14 = new Point(4, 0);

        Point p21 = new Point(3, 4);
        Point p22 = new Point(5, 2);
        Point p23 = new Point(3, 0);

        List<Point> squareList = new ArrayList<Point>(List.of(new Point[]{p11, p12, p13, p14}));
        List<Point> triangleList = new ArrayList<Point>(List.of(new Point[]{p21, p22, p23}));

        Polygon square = new Polygon(squareList);
        Polygon triangle = new Polygon(triangleList);

        Polygon newPolygon = square.getUnionOfPolygons(triangle);

        float expectedResult = 17.0F;
        float actualResult = newPolygon.squareOfPolygon();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetSquareOfUnionPolygons() {
        Point p11 = new Point(0, 0);
        Point p12 = new Point(0, 4);
        Point p13 = new Point(4, 4);
        Point p14 = new Point(4, 0);

        Point p21 = new Point(3, 2);
        Point p22 = new Point(5, 4);
        Point p23 = new Point(5, 0);

        List<Point> squareList = new ArrayList<Point>(List.of(new Point[]{p11, p12, p13, p14}));
        List<Point> triangleList = new ArrayList<Point>(List.of(new Point[]{p21, p22, p23}));

        Polygon square = new Polygon(squareList);
        Polygon triangle = new Polygon(triangleList);

        float expectedResult = 19.0F;
        float actualResult = square.getSquareOfUnionOfPolygons(triangle);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetSquareOfSubtractionOfPolygons() {
        Point p11 = new Point(0, 0);
        Point p12 = new Point(0, 4);
        Point p13 = new Point(4, 4);
        Point p14 = new Point(4, 0);

        Point p21 = new Point(3, 4);
        Point p22 = new Point(5, 2);
        Point p23 = new Point(3, 0);

        List<Point> squareList = new ArrayList<Point>(List.of(new Point[]{p11, p12, p13, p14}));
        List<Point> triangleList = new ArrayList<Point>(List.of(new Point[]{p21, p22, p23}));

        Polygon square = new Polygon(squareList);
        Polygon triangle = new Polygon(triangleList);

        float expectedResult = 13.0F;
        float actualResult = square.getSquareOfSubtractionOfPolygons(triangle);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
