package edu.csf.oop.java.geometry.objects;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.max;

public class ConvexPolygonsAlgorithms {

    private static final float EPS = 0.000000001F;

    /** Сравнение по модулю. */
    public static boolean equal(final double d1, final double d2) {
        return abs(d1-d2) <= EPS;
    }

    /** Проверка, находится ли точка на линии. */
    public static boolean isPointOnLine(final Line l, final float x, final float y) {
        return (min(l.getStart().getX(), l.getFinish().getX()) < x
                || equal(min(l.getStart().getX(), l.getFinish().getX()), x))
                && (max(l.getStart().getX(), l.getFinish().getX()) > x
                || equal(max(l.getStart().getX(), l.getFinish().getX()), x))
                && (min(l.getStart().getY(), l.getFinish().getY()) < y
                || equal(min(l.getStart().getY(), l.getFinish().getY()), y))
                && (max(l.getStart().getY(), l.getFinish().getY()) > y
                || equal(max(l.getStart().getY(), l.getFinish().getY()), y));
    }

    /** Метод add, для добавления точек, исключающий их дублирование. */
    public static void addPoints(final List<Point> pool, final List<Point> newPoints) {
        for (Point np : newPoints) {
            boolean found = false;
            for (Point p : pool) {
                if (equal(np.getX(), p.getX()) && equal(np.getY(), p.getY())) {
                    found = true;
                    break;
                }
            }
            if(!found) pool.add(np);
        }
    }

    /** Проверка на нахождение Точки в Полигоне.
     * Если Точка внутри него - true. Иначе - false. */
    public static boolean isPointInsidePolygon(final Point pt, final Polygon pn) {
        boolean res = false;
        List<Point> pointOfPolygon = pn.getVertices();
        for (int i = 0, j = pn.length - 1; i < pn.length; j = i++) {
            if (
                    (pointOfPolygon.get(i).getY() > pt.getY()) != (pointOfPolygon.get(j).getY() > pt.getY()) &&
                    (pt.getX() < (pointOfPolygon.get(j).getX() - pointOfPolygon.get(i).getX()) *
                            (pt.getY() - pointOfPolygon.get(i).getY())
                            / (pointOfPolygon.get(j).getY() - pointOfPolygon.get(i).getY()) + pointOfPolygon.get(i).getX()))
            {
                res = !res;
            }
        }
        return res;
    }

    /** Проверка на пересечение линии и ребра полигона.
     * Возвращается лист точек. */
    public static List<Point> getIntersectionPoints(final Line l, final Polygon p) {
        List<Point> intersectionPoints = new ArrayList<Point>();
        int lengthPolygon = p.length;
        List<Point> pointsOfPolygon = p.getVertices();
        for (int i = 0; i < lengthPolygon; i++) {
            int next = (i + 1 == lengthPolygon) ? 0 : i + 1;
            Point ip = l.getIntersectionPoint(new Line(pointsOfPolygon.get(i), pointsOfPolygon.get(next)));

            if (ip != null) intersectionPoints.add(ip);
        }
        return intersectionPoints;
    }
}
