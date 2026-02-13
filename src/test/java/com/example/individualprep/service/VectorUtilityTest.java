package com.example.individualprep.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class VectorUtilityTest {

    private final VectorUtility vectorUtility = new VectorUtility();

    @Test
    void testDotProduct() {
        double[] v1 = {1.0, 2.0, 3.0};
        double[] v2 = {4.0, 5.0, 6.0};
        assertEquals(32.0, vectorUtility.dotProduct(v1, v2), 0.0001);
    }

    @Test
    void testDotProductZeroVector() {
        double[] v1 = {0.0, 0.0, 0.0};
        double[] v2 = {4.0, 5.0, 6.0};
        assertEquals(0.0, vectorUtility.dotProduct(v1, v2), 0.0001);
    }

    @Test
    void testDotProductNullThrows() {
        double[] v = {1.0, 2.0};
        assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(null, v));
        assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(v, null));
    }

    @Test
    void testDotProductDifferentLengthThrows() {
        double[] v1 = {1.0, 2.0};
        double[] v2 = {1.0, 2.0, 3.0};
        assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(v1, v2));
    }
    
    @Test
    void testAdd() {
        double[] v1 = {1.0, 2.0, 3.0};
        double[] v2 = {4.0, 5.0, 6.0};
        assertArrayEquals(new double[] {5.0, 7.0, 9.0}, vectorUtility.add(v1, v2), 0.0001);
    }

    @Test
    void testAddNullThrows() {
        double[] v = {1.0, 2.0};
        assertThrows(IllegalArgumentException.class, () -> vectorUtility.add(v, null));
        assertThrows(IllegalArgumentException.class, () -> vectorUtility.add(null, v));
    }

    @Test
    void testAddDifferentLengthThrows() {
        double[] v1 = {1.0, 2.0};
        double[] v2 = {3.0};
        assertThrows(IllegalArgumentException.class, () -> vectorUtility.add(v1, v2));
    }

    @Test
    void testAddDoesNotModifyInputs() {
        double[] v1 = {1.0, 2.0};
        double[] v2 = {3.0, 4.0};
        double[] copyV1 = v1.clone();
        double[] copyV2 = v2.clone();

        vectorUtility.add(v1, v2);

        assertArrayEquals(copyV1, v1, 0.0);
        assertArrayEquals(copyV2, v2, 0.0);
    }
    
    @Test
    void testNorm() {
        double[] v1 = {3.0, 4.0};
        assertEquals(5.0, vectorUtility.norm(v1), 0.0001);

        double[] v2 = {1.0, 2.0, 2.0};
        assertEquals(3.0, vectorUtility.norm(v2), 0.0001);
    }

    @Test
    void testNormEmpty() {
        double[] v = {};
        assertEquals(0.0, vectorUtility.norm(v), 0.0001);
    }

    @Test
    void testNormSingleNegative() {
        double[] v = {-5.0};
        assertEquals(5.0, vectorUtility.norm(v), 0.0001);
    }

    @Test
    void testNormNullThrows() {
        assertThrows(IllegalArgumentException.class, () -> vectorUtility.norm(null));
    }

    @Test
    void testNormDoesNotModifyInput() {
        double[] v = {3.0, 4.0};
        double[] copy = v.clone();
        vectorUtility.norm(v);
        assertArrayEquals(copy, v, 0.0);
    }

    @Test
    void testMultiplyPositiveValue() {
        double[] v1 = {0.2, 0.3};
        int x1 = 4;
        double[] expected1 = {0.8, 1.2};
        assertArrayEquals(expected1, vectorUtility.multiply(v1, x1), 1e-9);

        double[] v2 = {0.4, 0.5, 0.6};
        int x2 = 10;
        double[] expected2 = {4.0, 5.0, 6.0};
        assertArrayEquals(expected2, vectorUtility.multiply(v2, x2), 1e-9);
    }

    @Test
    void testMultiplyNegativeValue() {
        double[] v1 = {0.2, -0.3};
        int x1 = -4;
        double[] expected1 = {-0.8, 1.2};
        assertArrayEquals(expected1, vectorUtility.multiply(v1, x1), 1e-9);
    }

    @Test
    void testMultiplyByZero() {
        double[] v1 = {0.2, -0.3};
        int x1 = 0;
        double[] expected1 = {0, 0};
        assertArrayEquals(expected1, vectorUtility.multiply(v1, x1), 1e-9);

        double[] v2 = {0.0, 0.0, 0.0};
        int x2 = 10;
        double[] expected2 = {0.0, 0.0, 0.0};
        assertArrayEquals(expected2, vectorUtility.multiply(v2, x2), 1e-9);
    }

    @Test
    void testMultiplyEmpty() {
        double[] v1 = {};
        int x1 = 4;
        double[] expected1 = {};
        assertArrayEquals(expected1, vectorUtility.multiply(v1, x1), 1e-9);
    }

    @Test
    void testMultiplyNullThrows() {
        double[] v1 = null;
        int x1 = 5;
        assertThrows(IllegalArgumentException.class, () -> vectorUtility.multiply(v1, x1));
    }

    @Test
    void testMultiplyDoesNotModifyInput() {
        double[] v1 = {3.0, 4.0};
        int x1 = 5;
        double[] copy = v1.clone();
        vectorUtility.multiply(v1, x1);
        assertArrayEquals(copy, v1, 0.0);
    }
}
