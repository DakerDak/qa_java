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
    private Feline felineMock;

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        when(felineMock.getKittens()).thenReturn(1);
        lion = new Lion("Самец", felineMock);
    }

    @Test
    public void testGetKittensReturnsCorrectValue() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);
        int result = lion.getKittens();
        assertEquals(3, result);

    }
    @Test
    public void testGetKittensCallsFelineMethodOnce() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);
        lion.getKittens();
        verify(felineMock, times(1)).getKittens();
    }
    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        List<String> result = lion.getFood();
        assertEquals(expectedFood, result);
    }

    @Test(expected = Exception.class)
    public void testLionConstructorWithInvalidSex() throws Exception {
        new Lion("Неизвестный", felineMock);
    }
}
