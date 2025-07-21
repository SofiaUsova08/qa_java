package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class LionTest {

    @Spy
    Feline felineSpy = new Feline();

    @Test
    void getKittensReturnOne() {
        Felines felines = new Feline();
        Lion lion = new Lion(felines);
        assertEquals(1, lion.getKittens(), "Ожидаем одного котёнка");
    }

    @Test
    void getFoodShouldCallFelineGetFood() throws Exception {
        Lion lion = new Lion("Самка");
        lion.feline = felineSpy;
        lion.getFood();
        verify(felineSpy).getFood("Хищник");
    }


/*

    Реализация теста без параметризации
    @Test
        void doesHaveManeWithFemaleSexReturnFalse() throws Exception {
            Lion lion = new Lion("Самка");
            assertFalse(lion.hasMane);
    }

    @Test
    void doesHaveManeWithMaleSexReturnTrue() throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue(lion.hasMane);
    }
 */


}