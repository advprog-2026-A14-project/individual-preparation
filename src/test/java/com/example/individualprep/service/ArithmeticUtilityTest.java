package com.example.individualprep.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ArithmeticUtilityTest {

    private final ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

    @Test
    void testSubtract() {
        assertEquals(1.0, arithmeticUtility.subtract(3.0, 2.0), 0.0001);
        assertEquals(-1.0, arithmeticUtility.subtract(2.0, 3.0), 0.0001);
        assertEquals(0.0, arithmeticUtility.subtract(0.0, 0.0), 0.0001);
        assertEquals(4.5, arithmeticUtility.subtract(2.0, -2.5), 0.0001);
        assertEquals(-4.0, arithmeticUtility.subtract(-1.5, 2.5), 0.0001);
        assertEquals(3.0000001, arithmeticUtility.subtract(3.0000001, 0.0), 1e-9);
        assertTrue(Double.isNaN(arithmeticUtility.subtract(Double.NaN, 1.0)));
        assertTrue(Double.isInfinite(arithmeticUtility.subtract(Double.POSITIVE_INFINITY, 1.0)));
    }
}