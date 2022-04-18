package org.example;

import org.example.part1.Arccos;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ArccosTest extends Assert {
    double eps = 0.01;
    @ParameterizedTest
    @ValueSource(doubles = {-3.0, -30.5})
    public void CheckNegativeUndefined(double value) {
        Assertions.assertEquals(Math.acos(value), Arccos.arccos(value), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.85, -0.9})
    public void CheckNegativeCloseToMinusOne(double value) {
        Assertions.assertEquals(Math.acos(value), Arccos.arccos(value), eps);
    }
    @ParameterizedTest
    @ValueSource(doubles = {-0.15, -0.1})
    public void CheckNegativeCloseToZero(double value) {
        Assertions.assertEquals(Math.acos(value), Arccos.arccos(value), eps);
    }
    @ParameterizedTest
    @ValueSource(doubles = {0.1, 0.15})
    public void CheckPositiveCloseToZero(double value) {
        Assertions.assertEquals(Math.acos(value), Arccos.arccos(value), eps);
    }
    @ParameterizedTest
    @ValueSource(doubles = {0.85, 0.9})
    public void CheckPositiveCloseToOne(double value) {
        Assertions.assertEquals(Math.acos(value), Arccos.arccos(value), eps);
    }
    @ParameterizedTest
    @ValueSource(doubles = {3.0, 30.5})
    public void CheckPositiveUndefined(double value) {
        Assertions.assertEquals(Math.acos(value), Arccos.arccos(value), eps);
    }
    @ParameterizedTest
    @ValueSource(doubles = {0.0, 0.001, -0.001})
    public void CheckZero(double value) {
        Assertions.assertEquals(Math.acos(value), Arccos.arccos(value), eps);
    }
    @ParameterizedTest
    @ValueSource(doubles = {1.0, 1.0+0.001})
    public void CheckOne(double value) {
        Assertions.assertEquals(Double.NaN, Arccos.arccos(value), eps);
    }
    @ParameterizedTest
    @ValueSource(doubles = {-1.0, -1.0-0.001})
    public void CheckMinusOne(double value) {
        Assertions.assertEquals(Double.NaN, Arccos.arccos(value), eps);
    }
}

