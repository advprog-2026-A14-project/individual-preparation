package com.example.individualprep.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ArithmeticUtilityTest {

    private final ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

    @Test
    void testAdd() {
        assertEquals(5.0, arithmeticUtility.add(2.0, 3.0), 0.0001);
        assertEquals(1.0, arithmeticUtility.add(3.0, -2.0), 0.0001);
        assertEquals(5.5, arithmeticUtility.add(2.2, 3.3), 0.0001);
        assertEquals(0.0, arithmeticUtility.add(0.0, 0.0), 0.0001);

        assertEquals(-4.0, arithmeticUtility.add(-1.5, -2.5), 0.0001);
        assertEquals(2.5, arithmeticUtility.add(5.0, -2.5), 0.0001);

        double a = 7.25, b = -1.75;
        assertEquals(arithmeticUtility.add(a, b), arithmeticUtility.add(b, a), 0.0001);

        assertEquals(3.0000001, arithmeticUtility.add(3.0, 0.0000001), 1e-9);

        double infRes = arithmeticUtility.add(1e308, 1e308);
        assertTrue(Double.isInfinite(infRes) && infRes > 0);

        assertTrue(Double.isNaN(arithmeticUtility.add(Double.NaN, 1.0)));
        assertTrue(Double.isNaN(arithmeticUtility.add(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY)));
    }

    @Test
    void testExponent() {
        assertEquals(8.0, arithmeticUtility.exponent(2.0, 3), 0.0001);
        assertEquals(1.0, arithmeticUtility.exponent(5.0, 0), 0.0001);
        assertEquals(0.25, arithmeticUtility.exponent(2.0, -2), 0.0001);
        assertEquals(-8.0, arithmeticUtility.exponent(-2.0, 3), 0.0001);
        assertEquals(16.0, arithmeticUtility.exponent(-2.0, 4), 0.0001);
    }

    @Test
    void testMultiply() {
        assertEquals(6.0, arithmeticUtility.multiply(2.0, 3.0), 0.0001);
        assertEquals(-12.0, arithmeticUtility.multiply(-4.0, 3.0), 0.0001);
        assertEquals(-12.0, arithmeticUtility.multiply(4.0, -3.0), 0.0001);
        assertEquals(6.0, arithmeticUtility.multiply(-2.0, -3.0), 0.0001);

        assertEquals(11.0, arithmeticUtility.multiply(11.0, 1.0), 0.0001);
        assertEquals(0.0, arithmeticUtility.multiply(2.0, 0.0), 0.0001);
        assertEquals(0.0, arithmeticUtility.multiply(-2.0, 0.0), 0.0001);
        assertEquals(-0.0, arithmeticUtility.multiply(2.0, -0.0), 0.0001);
        assertEquals(0.0, arithmeticUtility.multiply(0.0, 0.0), 0.0001);

        assertEquals(Double.POSITIVE_INFINITY, arithmeticUtility.multiply(Double.POSITIVE_INFINITY, 3.0));
        assertEquals(Double.NEGATIVE_INFINITY, arithmeticUtility.multiply(Double.NEGATIVE_INFINITY, 3.0));
        assertEquals(Double.NEGATIVE_INFINITY, arithmeticUtility.multiply(Double.POSITIVE_INFINITY, -1.0));
        assertEquals(Double.NEGATIVE_INFINITY, arithmeticUtility.multiply(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY));
        assertEquals(Double.POSITIVE_INFINITY, arithmeticUtility.multiply(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY));
        assertTrue(Double.isNaN(arithmeticUtility.multiply(Double.NaN, 3.0)));
        assertTrue(Double.isNaN(arithmeticUtility.multiply(Double.POSITIVE_INFINITY, 0.0)));
        assertTrue(Double.isNaN(arithmeticUtility.multiply(Double.NEGATIVE_INFINITY, 0.0)));

        assertEquals(Double.POSITIVE_INFINITY, arithmeticUtility.multiply(Double.MAX_VALUE, 3.0));
        assertEquals(0.0, arithmeticUtility.multiply(Double.MIN_VALUE, 0.1));
    }

    @Test
    void testDividePositive() {
        assertEquals(5.0, arithmeticUtility.divide(10.0, 2.0), 1e-10);
        assertEquals(0.3333333333333333, arithmeticUtility.divide(1.0, 3.0), 1e-15);
    }

    @Test
    void testDivideNegative() {
        assertEquals(-4.0, arithmeticUtility.divide(-8.0, 2.0), 1e-10);

        assertEquals(2.0, arithmeticUtility.divide(-8.0, -4.0),1e-10);
    }

    @Test
    void testDivideByZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            arithmeticUtility.divide(10.0, 0.0);
        }, "Divide by zero exception");
    }

    @Test
    void testDivideZeroByNumber() {
        assertEquals(0.0, arithmeticUtility.divide(0.0, 5.0), 1e-10);
    }
}
