package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private Feline feline = new Feline();

    @Parameterized.Parameters(name = "Kittens count: {0}")
    public static Object[][] getKittensData() {
        return new Object[][] {
                {1},
                {3},
                {5},
                {0},
                {10},
                {100},
                {3}
        };
    }

    private int kittensCount;

    public FelineParameterizedTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }

    @Test
    public void testGetKittensWithCount() {

        int result = feline.getKittens(kittensCount);

        assertEquals(kittensCount, result);
    }
}
