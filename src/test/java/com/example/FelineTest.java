package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void eatMeatWithSpyReturnCorrectResult() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    void getFamilyReturnCorrectResult() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        assertEquals("Кошачьи", actual, "Ожидаем значение: Кошачьи!");
    }

    @Test
    void getKittensWithoutParameterCallsGetKittensWithParameterOne() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

}

/*
Реализация без Spy
    @Test
    void eatMeatReturnCorrectResult() throws Exception {
        Feline feline = new Feline();
        List<String> actual = feline.eatMeat();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual, "Ожидаем значение: Животные, Птицы, Рыба");
    }

Реализация без Spy
@Test
void getKittensWithoutParameterReturnOne() {
    Feline feline = new Feline();
    int actual = feline.getKittens();
    assertEquals(1, actual, "Ожидаем значение 1!");
}

Реализация без переметризированного теста
@Test
void getKittensWithPositiveParameterReturnPositiveResult() {
    Feline feline = new Feline();
    int actual = feline.getKittens(1);
    assertEquals(1, actual, "Ожидаем значение 1!");
    }
Реализация проверяющая что ответ не конкретная стррка а просто не NULL
@Test
    void getFamilyReturnNotNull() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        assertNotNull(actual, "Значение не должно быть null");
    }

 */