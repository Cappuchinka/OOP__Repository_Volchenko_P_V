import edu.csf.oop.java.geometry.objects.Point;
import edu.csf.oop.java.geometry.objects.Polygon;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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

        Polygon intersectionOfPolygons = square.getIntersectionOfPolygons(triangle);
        Polygon unionPolygons = square.getUnionOfPolygons(triangle);

        float squareOfIntersectionOfPolygons = intersectionOfPolygons.squareOfPolygon();
        float squareOfUnionOfPolygons = square.getSquareOfUnionOfPolygons(triangle);
        float squareOfSubtractionOfPolygons = square.getSquareOfSubtractionOfPolygons(triangle);

        System.out.printf("Square of first polygon: %.3f; " +
                "\nSquare of second polygon: %.3f\n",
                square.squareOfPolygon(), triangle.squareOfPolygon());

        System.out.println("\n=====================================================\n");

        System.out.printf("Square of intersection of polygons: %.3f; " +
                "\nSquare of union of polygons: %.3f; " +
                "\nSquare of subtraction of polygons: %.3f;\n",
                squareOfIntersectionOfPolygons, squareOfUnionOfPolygons, squareOfSubtractionOfPolygons);

        System.out.println("\n=====================================================\n");

        List<Point> verticesOfIntersectionOfPolygons = intersectionOfPolygons.getVertices();
        List<Point> verticesOfUnionOfPolygons = unionPolygons.getVertices();

        Point[] arrayVerticesIntersection = verticesOfIntersectionOfPolygons.toArray(new Point[0]);
        Point[] arrayVerticesUnion = verticesOfUnionOfPolygons.toArray(new Point[0]);

        String verticesIntersection = getArray(arrayVerticesIntersection);
        String verticesUnion = getArray(arrayVerticesUnion);

        System.out.println("Points of intersectionOfPolygons: " + verticesIntersection);
        System.out.println("Point of unionOfPolygons: " + verticesUnion);

    }

    public static String getArray(Point[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i].getString());
            stringBuilder.append(i != arr.length - 1 ? ", " : ";");
        }
        return stringBuilder.toString();
    }
}
