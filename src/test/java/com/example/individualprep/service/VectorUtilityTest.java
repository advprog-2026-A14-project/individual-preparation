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
}