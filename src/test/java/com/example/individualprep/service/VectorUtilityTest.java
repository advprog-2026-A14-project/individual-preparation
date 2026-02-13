package com.example.individualprep.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class VectorUtilityTest {

    private final VectorUtility vectorUtility = new VectorUtility();

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
    void testSubtractPositiveValue() {
        double[] v1 = {3.0, 4.0, 1.0};
        double[] v2 = {1.0, 2.0, 7.0};
        double[] expected1 = {2.0, 2.0, -6.0};

        assertArrayEquals(expected1, vectorUtility.subtract(v1, v2), 1e-10);

        double[] v3 = {0.3, 0.4, 0.1};
        double[] v4 = {0.2, 0.1, 0.2};
        double[] expected2 = {0.1, 0.3, -0.1};

        assertArrayEquals(expected2, vectorUtility.subtract(v3, v4), 1e-10);
    }

    @Test
    void testSubtractNegativeValue() {
        double[] v1 = {-3.0, -4.0, -1.0};
        double[] v2 = {-1.0, -2.0, -7.0};
        double[] expected1 = {-2.0, -2.0, 6.0};

        assertArrayEquals(expected1, vectorUtility.subtract(v1, v2), 1e-10);

        double[] v3 = {-0.3, -0.4, -0.1};
        double[] v4 = {-0.2, -0.1, -0.2};
        double[] expected2 = {-0.1, -0.3, 0.1};

        assertArrayEquals(expected2, vectorUtility.subtract(v3, v4), 1e-10);
    }

    @Test
    void testSubtractMixedSign() {
        double[] v1 = {-0.3, -0.4, 0.1};
        double[] v2 = {0.2, -0.1, -0.2};
        double[] expected1 = {-0.5, -0.3, 0.3};

        assertArrayEquals(expected1, vectorUtility.subtract(v1, v2), 1e-10);
    }

    @Test
    void testSubtractPrecision() {
        double[] v1 = {1_000_000.0, 0.0000001};
        double[] v2 = {1.0, 0.00000005};
        double[] expected = {999_999.0, 0.00000005};

        assertArrayEquals(expected, vectorUtility.subtract(v1, v2), 1e-10);
    }
}
