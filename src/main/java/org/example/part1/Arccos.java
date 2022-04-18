package org.example.part1;

public class Arccos {
    public static double arccos(double x) {
        if (Math.abs(x) >= 1) {
            return Double.NaN;
        }
        double res = Math.PI / 2 - x;
        long chisl = 1;
        long znam = 2;
        int n = 17;
        for (int i = 2; i < n; i++){
            res -= Math.pow(x, 2 * i - 1) * chisl / (znam * (2 * i - 1));
            chisl = chisl * (2L * i - 1);
            znam = znam * (2L * i);
        }
        return res;
    }
}

