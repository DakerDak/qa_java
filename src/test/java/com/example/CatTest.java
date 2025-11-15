package com.example;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CatTest {

    @Mock
    private Feline felineMock;

    private Cat cat;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cat = new Cat(felineMock);
    }

    @Test
    public void testGetSound() {

        String result = cat.getSound();
        assertEquals("Мяу", result);
    }

    @Test
    public void testGetFoodReturnsCorrectList() throws Exception {

        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        List<String> result = cat.getFood();

        assertEquals(expectedFood, result);

    }
    @Test
    public void testGetFoodCallsEatMeatOnce() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        cat.getFood();
        verify(felineMock, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testGetFoodWithException() throws Exception {

        when(felineMock.eatMeat()).thenThrow(new Exception("Ошибка получения еды"));

        cat.getFood();
    }
}
