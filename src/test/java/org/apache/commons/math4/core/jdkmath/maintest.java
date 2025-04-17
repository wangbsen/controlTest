package org.apache.commons.math4.core.jdkmath;

public class maintest {
    public static void main(String[] args) {
        testSplit();
        testSplitMult();
        testSlowCosZero();
        testSlowSinZero();
        testSplitAdd();
        testSplitReciprocal();
        testExpint();
        testSlowLog();
    }

    private static void testSplit() {
        double[] split = new double[2];
        AccurateMathCalc.split(2.0, split);
        assertEqual(2.0, split[0] + split[1], "testSplit");
    }

    private static void testSplitMult() {
        double[] a = new double[2], b = new double[2], result = new double[2];
        AccurateMathCalc.split(3.0, a);
        AccurateMathCalc.split(2.0, b);
        AccurateMathCalc.splitMult(a, b, result);
        assertEqual(6.0, result[0] + result[1], "testSplitMult");
    }
    private static void testSlowCosZero() {
        double[] result = new double[2];
        double cos = AccurateMathCalc.slowCos(0.0, result);
        assertEqual(1.0, cos, "testSlowCosZero");
    }

    private static void testSlowSinZero() {
        double[] result = new double[2];
        double sin = AccurateMathCalc.slowSin(0.0, result);
        assertEqual(0.0, sin, "testSlowSinZero");
    }

    private static void testSplitAdd() {
        double[] a = {1.0, 0.5}, b = {2.0, 0.5}, result = new double[2];
        AccurateMathCalc.splitAdd(a, b, result);
        assertEqual(4.0, result[0] + result[1], "testSplitAdd");
    }

    private static void testSplitReciprocal() {
        double[] in = {2.0, 0.0}, result = new double[2];
        AccurateMathCalc.splitReciprocal(in, result);
        assertEqual(0.5, result[0] + result[1], "testSplitReciprocal");
    }
    private static void testExpint() {
        double[] result = new double[2];
        double exp = AccurateMathCalc.expint(1, result);
        assertEqual(Math.E, exp, 1e-10, "testExpint");
    }

    private static void testSlowLog() {
        double[] logResult = AccurateMathCalc.slowLog(Math.E);
        double log = logResult[0] + logResult[1];
        assertEqual(1.0, log, 1e-10, "testSlowLog");
    }

    private static void assertEqual(double expected, double actual, String testName) {
        assertEqual(expected, actual, 1e-10, testName);
    }

    private static void assertEqual(double expected, double actual, double delta, String testName) {
        if (Math.abs(actual - expected) > delta) {
            System.out.println(testName + " FAILED. Expected: " + expected + ", Actual: " + actual);
        } else {
            System.out.println(testName + " PASSED.");
        }
    }
}
