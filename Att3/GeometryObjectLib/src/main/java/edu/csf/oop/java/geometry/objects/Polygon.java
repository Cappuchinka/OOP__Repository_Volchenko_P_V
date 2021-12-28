package edu.csf.oop.java.geometry.objects;

import java.util.ArrayList;
import java.util.List;

import static edu.csf.oop.java.geometry.objects.ConvexPolygonsAlgorithms.*;
import static java.lang.Math.abs;

public class Polygon {
    private final List<Point> vertices;
    public final int length;

    public Polygon(final List<Point> vertices) {
        this.vertices = vertices;
        this.length = vertices.size();
    }

    public List<Point> getVertices() {
        return vertices;
    }

    public float squareOfPolygon() {
        float v0 = vertices.get(0).getX() * (vertices.get(1).getY() - vertices.get(length - 1).getY());
        float vl = vertices.get(length - 1).getX() * (vertices.get(0).getY() - vertices.get(length - 2).getY());
        float vsum = 0;
        for (int i = 1; i < length - 1; i++) {
            vsum += vertices.get(i).getX() * (vertices.get(i + 1).getY() - vertices.get(i-1).getY());
        }
        return abs(v0 + vsum + vl) / 2;
    }

    public Point findCenterInPolygon(final List<Point> points) {
        int x = 0;
        int y = 0;
        for (Point p : points) {
            x += p.getX();
            y += p.getY();
        }
        x /= points.size();
        y /= points.size();
        return new Point(x, y);
    }

    public void orderClockwise() {
        Point p = findCenterInPolygon(vertices);
        vertices.sort((a, b) -> {
            float a1 = (float) (Math.toDegrees(Math.atan2(a.getX() - p.getX(), a.getY() - p.getY())) + 360) % 360;
            float a2 = (float) (Math.toDegrees(Math.atan2(b.getX() - p.getX(), b.getY() - p.getX())) + 360) % 360;
            return (int) (a1 - a2);
        });
    }

    /** Возвращает пересечение двух полигонов. */
    public Polygon getIntersectionOfPolygons(final Polygon pn2) {
        List<Point> verticesOfNewPolygon = new ArrayList<>();
        int sizeP1 = this.length;
        int sizeP2 = pn2.length;

        List<Point> pointsOfPolygon1 = this.getVertices();
        List<Point> pointsOfPolygon2 = pn2.getVertices();

        for (Point p1 : pointsOfPolygon1) {
            if (isPointInsidePolygon(p1, pn2)) {
                addPoints(verticesOfNewPolygon, new ArrayList<>(List.of(p1)));
            }
        }
        for (Point p2 : pointsOfPolygon2) {
            if (isPointInsidePolygon(p2, this)) {
                addPoints(verticesOfNewPolygon, new ArrayList<>(List.of(p2)));
            }
        }
        for (int i = 0, next = 1; i < sizeP1; i++, next = (i + 1 == sizeP1) ? 0 : i + 1)
        {
            addPoints(verticesOfNewPolygon, getIntersectionPoints(new Line(pointsOfPolygon1.get(i), pointsOfPolygon1.get(next)), pn2));
        }
        Polygon newPolygon = new Polygon(verticesOfNewPolygon);
        newPolygon.orderClockwise();
        return newPolygon;
    }

    /** Возвращает новый полигон, который является объединением двух.
     * Верно будет только для выпуклых полигонов. */
    public Polygon getUnionOfPolygons(final Polygon pn2) {
        List<Point> pointsOfPn1 = this.getVertices();
        List<Point> pointsOfPn2 = pn2.getVertices();

        Polygon intersectionOfPolygons = this.getIntersectionOfPolygons(pn2);
        List<Point> pointsOfIntersectOfPns = intersectionOfPolygons.getVertices();

        List<Point> pointsOfNewPolygon = new ArrayList<Point>();
        addPoints(pointsOfNewPolygon, pointsOfPn1);
        addPoints(pointsOfNewPolygon, pointsOfPn2);
        addPoints(pointsOfNewPolygon, pointsOfIntersectOfPns);

        for(Point p : pointsOfIntersectOfPns) {
            if ((isPointInsidePolygon(p, this) && isPointInsidePolygon(p, pn2))) {
                pointsOfNewPolygon.remove(p);
            }
        }

        Polygon newPolygon = new Polygon(pointsOfNewPolygon);
        newPolygon.orderClockwise();

        return newPolygon;
    }

    /** Возвращает площадь двух объединённых полигонов. Вне зависимости от выпуклости полигона. */
    public float getSquareOfUnionOfPolygons(final Polygon pn2) {
        float square1 = this.squareOfPolygon();
        float square2 = pn2.squareOfPolygon();
        float squareOfIntersectionPolygons = this.getIntersectionOfPolygons(pn2).squareOfPolygon();

        return (square1 + square2) - squareOfIntersectionPolygons;
    }

    /** Возвращает площадь разности полигонов. */
    public float getSquareOfSubtractionOfPolygons(final Polygon pn2) {
        return this.squareOfPolygon() - this.getIntersectionOfPolygons(pn2).squareOfPolygon();
    }
}
