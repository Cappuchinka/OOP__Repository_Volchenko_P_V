package edu.csf.oop.java.geometry.objects;

public class Point {
    private float x, y;

    public Point() {}

    public Point(final float x, final float y) {
        this.x = x;
        this.y = y;
    }

    public void setLocation(final float x, final float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(final float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(final float y) {
        this.y = y;
    }

    public static float distance(final float x1, final float y1, final float x2, final float y2) {
        return (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    public static float distance(final Point p1, final Point p2) {
        return (float) Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }

    public float distance(final float x, final float y) {
        return (float) Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
    }

    public float distance(final Point p) {
        return (float) Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
    }

    public boolean equals(final Point p) {
        if (this == p) return true;
        return Float.compare(this.x, p.x) == 0 && Float.compare(this.y, p.y) == 0;
    }
}
