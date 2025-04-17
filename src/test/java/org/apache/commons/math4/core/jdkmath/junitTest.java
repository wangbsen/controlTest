package org.apache.commons.math4.core.jdkmath;
import org.junit.Test;
import static org.junit.Assert.*;
public class junitTest {
    @Test
    public void testSplit() {
        double[] split = new double[2];
        AccurateMathCalc.split(2.0, split);
        assertEquals(2.0, split[0] + split[1], 1e-10);
    }

    @Test
    public void testSplitMult() {
        double[] a = new double[2], b = new double[2], result = new double[2];
        AccurateMathCalc.split(3.0, a);
        AccurateMathCalc.split(2.0, b);
        AccurateMathCalc.splitMult(a, b, result);
        assertEquals(6.0, result[0] + result[1], 1e-10);
    }

    @Test
    public void testSlowCosZero() {
        double[] result = new double[2];
        double cos = AccurateMathCalc.slowCos(0.0, result);
        assertEquals(1.0, cos, 1e-10);
    }
    @Test
    public void testSlowSinZero() {
        double[] result = new double[2];
        double sin = AccurateMathCalc.slowSin(0.0, result);
        assertEquals(0.0, sin, 1e-10);
    }

    @Test
    public void testSplitAdd() {
        double[] a = {1.0, 0.5}, b = {2.0, 0.5}, result = new double[2];
        AccurateMathCalc.splitAdd(a, b, result);
        assertEquals(4.0, result[0] + result[1], 1e-10);
    }

    @Test
    public void testSplitReciprocal() {
        double[] in = {2.0, 0.0}, result = new double[2];
        AccurateMathCalc.splitReciprocal(in, result);
        assertEquals(0.5, result[0] + result[1], 1e-10);
    }
    @Test
    public void testExpint() {
        double[] result = new double[2];
        double exp = AccurateMathCalc.expint(1, result);
        assertEquals(Math.E, exp, 1e-10);
    }

    @Test
    public void testSlowLog() {
        double[] logResult = AccurateMathCalc.slowLog(Math.E);
        double log = logResult[0] + logResult[1];
        assertEquals(1.0, log, 1e-10);
    }
}
