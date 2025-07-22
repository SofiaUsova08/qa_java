package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundWithMockShouldBeTwoStringsEquals() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound(), "Неверный звук котика!");
    }

    @Test
    void getFoodWithStubCallsEatMeat() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(cat.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood(), "Ожидаем что внутри вызвали метод eatMeat()");

    }

    /*
    // Реализация getFood без стаба
    @Test
    void getFoodReturnCorrectValue() throws Exception{
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> actual = cat.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual, "Ожидаем значение: Животные, Птицы, Рыба");
    }

    Реализация getSoundS без мока
    @Test
    public void getSoundShouldBeTwoStringsEqual() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        assertEquals("Мяу", actual, "Неверный звук котика!");

    }

     */
}