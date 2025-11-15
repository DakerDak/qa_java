package com.example;

import org.junit.Test;
import org.junit.Before;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void testGetKittensWithoutParameters() {
        assertEquals(1, feline.getKittens());
    }


    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testEatMeatReturnsNotNull() throws Exception {
        List<String> result = feline.eatMeat();
        assertNotNull(result);

    }
    @Test
    public void testEatMeatReturnsNonEmptyList() throws Exception {
        List<String> result = feline.eatMeat();
        assertFalse(result.isEmpty());
    }

    @Test
    public void testEatMeatNoException() throws Exception {

        feline.eatMeat();
        assertTrue(true);
    }
}