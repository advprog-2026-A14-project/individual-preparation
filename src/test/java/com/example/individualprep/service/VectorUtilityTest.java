package com.example.individualprep.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class VectorUtilityTest {

    private final VectorUtility vectorUtility = new VectorUtility();

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
}
