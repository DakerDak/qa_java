package com.example;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Mock
    private Predator predatorMock;

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        when(predatorMock.getKittens()).thenReturn(1);
        lion = new Lion("Самец", predatorMock);
    }

    @Test
    public void testGetKittens() throws Exception {
        when(predatorMock.getKittens()).thenReturn(3);
        int result = lion.getKittens();
        assertEquals(3, result);
        verify(predatorMock, times(1)).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(expectedFood);
        List<String> result = lion.getFood();
        assertEquals(expectedFood, result);
    }

    @Test(expected = Exception.class)
    public void testLionConstructorWithInvalidSex() throws Exception {
        new Lion("Неизвестный", predatorMock);
    }
}
