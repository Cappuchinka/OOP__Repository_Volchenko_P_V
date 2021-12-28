package edu.csf.oop.java.geometry.objects;

import static edu.csf.oop.java.geometry.objects.ConvexPolygonsAlgorithms.*;

public class Line {
    private Point start, finish;

    public Line() {}

    public Line(final Point start, final Point finish) {
        this.start = start;
        this.finish = finish;
    }

    public Line(final float x1, final float y1, final float x2, final float y2) {
        this.start = new Point(x1, y1);
        this.finish = new Point(x2, y2);
    }

    public void setLocation(final Point start, final Point finish) {
        this.start = start;
        this.finish = finish;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(final Point start) {
        this.start = start;
    }

    public Point getFinish() {
        return finish;
    }

    public void setFinish(final Point finish) {
        this.finish = finish;
    }

    public float getLength() {
        return Point.distance(start, finish);
    }

    public boolean equals(final Line l) {
        if (this == l) return true;
        return this.start.equals(l.start) && this.finish.equals(l.finish) || this.start.equals(l.finish) && this.finish.equals(l.start);
    }

    public Point getIntersectionPoint(final Line l2) {
        float a1 = this.getFinish().getY() - this.getStart().getY();
        float b1 = this.getStart().getX() - this.getFinish().getX();
        float c1 = a1 * this.getStart().getX() + b1 * this.getStart().getY();

        float a2 = l2.getFinish().getY() - l2.getStart().getY();
        float b2 = l2.getStart().getX() - l2.getFinish().getX();
        float c2 = a2 * l2.getStart().getX() + b2 * l2.getStart().getY();

        float det = a1 * b2 - a2 * b1;
        if (equal(det, 0F)) {
            return null;
        } else {
            float x = (b2 * c1 - b1 * c2) / det;
            float y = (a1 * c2 - a2 * c1) / det;

            boolean onLine1 = isPointOnLine(this, x, y);

            boolean onLine2 = isPointOnLine(l2, x, y);
            if (onLine1 && onLine2)
                return new Point(x, y);
        }
        return null;
    }
}
