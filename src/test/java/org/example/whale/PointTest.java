package org.example.whale;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @Test
    void testConstructorWithDoubleArray() {
        double[] coords = {1.0, 2.0, 3.0};
        Point point = new Point(coords);

        assertEquals(3, point.dim);
        assertArrayEquals(coords, point.p);
    }

    @Test
    void testConstructorWithIntArray() {
        int[] coords = {1, 2, 3};
        Point point = new Point(coords);

        assertEquals(3, point.dim);
        assertArrayEquals(coords, point.ip);
    }

    @Test
    void testConstructorWithDim() {
        int dim = 4;
        Point point = new Point(dim);

        assertEquals(dim, point.dim);
        assertArrayEquals(new double[dim], point.p);
    }

    @Test
    void testNorm() {
        double[] coords = {3.0, 4.0};
        Point point = new Point(coords);

        assertEquals(5.0, point.norm(), 1e-9);
    }

    @Test
    void testDist() {
        double[] coordsA = {1.0, 2.0};
        double[] coordsB = {4.0, 6.0};
        Point pointA = new Point(coordsA);
        Point pointB = new Point(coordsB);

        assertEquals(5.0, pointA.dist(pointB), 1e-9);
    }

    @Test
    void testAdd() throws Exception {
        double[] coordsA = {1.0, 2.0};
        double[] coordsB = {3.0, 4.0};
        Point pointA = new Point(coordsA);
        Point pointB = new Point(coordsB);

        Point result = Point.add(pointA, pointB);
        double[] expected = {4.0, 6.0};

        assertArrayEquals(expected, result.p);
    }

    @Test
    void testAddWithDifferentDimensions() {
        double[] coordsA = {1.0, 2.0, 3.0};
        double[] coordsB = {4.0, 5.0};
        Point pointA = new Point(coordsA);
        Point pointB = new Point(coordsB);

        assertThrows(IllegalArgumentException.class, () -> {
            Point.add(pointA, pointB);
        });
    }

    @Test
    void testMid() throws Exception {
        double[] coordsA = {1.0, 2.0};
        double[] coordsB = {3.0, 4.0};
        Point pointA = new Point(coordsA);
        Point pointB = new Point(coordsB);

        Point result = Point.mid(pointA, pointB);
        double[] expected = {2.0, 3.0};

        assertArrayEquals(expected, result.p);
    }

    @Test
    void testMidWithDifferentDimensions() {
        double[] coordsA = {1.0, 2.0, 3.0};
        double[] coordsB = {4.0, 5.0};
        Point pointA = new Point(coordsA);
        Point pointB = new Point(coordsB);

        assertThrows(IllegalArgumentException.class, () -> {
            Point.mid(pointA, pointB);
        });
    }

    @Test
    void testMull() {
        double[] coords = {1.0, 2.0, 3.0};
        Point point = new Point(coords);

        Point result = point.mull(2.0);
        double[] expected = {2.0, 4.0, 6.0};

        assertArrayEquals(expected, result.p);
    }

    @Test
    void testToStringWithIntArray() {
        int[] coords = {1, 2, 3};
        Point point = new Point(coords);

        String expected = "Ponto: [1,2,3]";
        assertEquals(expected, point.toString());
    }


    @Test
    void testToStringWithDoubleArray() {
        double[] coords = {1.0, 2.0, 3.0};
        Point point = new Point(coords);

        String expected = "Ponto: [1.0,2.0,3.0]";
        assertEquals(expected, point.toString());
    }


}
