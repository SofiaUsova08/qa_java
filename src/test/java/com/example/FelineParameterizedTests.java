package com.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FelineParameterizedTests {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "-1, -1",
            "0, 0",
            "10000000, 10000000",
            "-10000000, -10000000",
    })
    void getKittensWithParamAndCsvSource(int a, int result) {
        Feline feline = new Feline();
        assertEquals(result, feline.getKittens(a), "Ожидаем что совпадет возвращаемое значение с передаваемым!");
    }
}
