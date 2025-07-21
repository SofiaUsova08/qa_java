package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LionParameterizedTests {

    @ParameterizedTest
    @CsvSource({
            "Самка, false",
            "Самец, true"
    })
    void ConstructorWithCorrectSexAndParamsCsv(String sex, boolean expectedResult) throws Exception {
        Lion lion = new Lion(sex);
        boolean actual = lion.hasMane;
        assertEquals(expectedResult, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Unknown", "", " ", "123", "User", "&&^%!"})
    @DisplayName("Вызов метода с неизвестным полом в конструкторе вызывает исключение Exception")
    void ConstructorWithUnknownSexAndValueSourceReturnException(String sex) throws Exception {
        Executable executable = () -> new Lion(sex);

        assertThrows(
                Exception.class,
                executable,
                "Конструктор выбросит Exception при неизвестном значении пола"
        );
    }

    @ParameterizedTest
    @CsvSource({
            "Самка, false",
            "Самец, true"
    })
    void doesHaveManeWithCorrectSexAndParamsCsv(String sex, boolean expectedResult) throws Exception {
        Lion lion = new Lion(sex);
        boolean actual = lion.doesHaveMane();
        assertEquals(expectedResult, actual);
    }

}

/*
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.List;


Реализация теста на контсруктор со spy
    @ParameterizedTest
    @CsvSource({
            "Самка, false",
            "Самец, true"
    })
    void ConstructorWithCorrectSexAndParamsCsv(String sex, boolean expectedResult) throws Exception {
        Lion lion = spy(new Lion(sex));
        assertEquals(expectedResult, lion.hasMane);

    }
*/
