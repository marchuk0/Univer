package com.marchuk0.lab1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.marchuk0.lab1.utils.SpreadSheetHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SpreedSheetHelperTest {

    @ParameterizedTest
    @CsvSource(value = {
            "=1;1",
            "=-123123;-123123",
            " = 2  +2*     2 + 3  ^ 2     ;15",
            "=mmax(0, -13+12, mmin(100, 101), 2^2+2);100",
            "=mmin(0, -13+12, mmin(100, 101), 2^2+2);-1"

    },
            delimiter = ';')
    public void evalCorrectExpression(String input, String expected) {
        var result = SpreadSheetHelper.evalExpression(input);
        assertEquals(expected, result);
    }


    @ParameterizedTest
    @CsvSource(value = {
            "123+123*123^123+mmax(123, 980, 111);123+123*123^123+mmax(123, 980, 111)",
            "R987C123;R987C123"
    },
            delimiter = ';')
    public void doNotEvalExpression(String input, String expected) {
        var result = SpreadSheetHelper.evalExpression(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "=(((1+1))",
            "=",
            "=123+54^"
    })
    public void whenExpressionIsIncorrect_ThrowException(String input) {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            SpreadSheetHelper.evalExpression(input);
        });
    }
}
