package com.calculator.ntesanovic.calc;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void test_add() {
        assertEquals(15, Operations.add(10, 5), 0.001);
    }

    @Test
    public void test_subtract() {
        assertEquals(5, Operations.subtract(10, 5), 0.001);
    }

    @Test
    public void test_multiply() {
        assertEquals(50, Operations.multiply(10, 5), 0.001);
    }

    @Test
    public void test_divide() {
        assertEquals(2, Operations.divide(10, 5), 0.001);
    }

}