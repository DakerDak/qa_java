package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Mock
    private Feline felineMock;

    private String sex;
    private boolean expectedHasMane;

    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters(name = "Sex: {0}, HasMane: {1}")
    public static Object[][] getSexData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void testLionConstructorWithValidSex() throws Exception {

        Lion lion = new Lion(sex, felineMock);
        assertEquals("Неправильное значение hasMane для пола: " + sex,
                expectedHasMane, lion.doesHaveMane());
    }
}
