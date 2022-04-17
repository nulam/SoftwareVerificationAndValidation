import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SWE 202 - homework 2
 * id - B211202801
 * Tomas Halama
 */
class CalculatorTest {

    static String templateDivideError = "The result of Calculator.divide method for %f/%f is incorrect. Expected %f, got %f";

    private static String formatDivideError(double input1, double input2, double expected, double output) {
        return String.format(templateDivideError, input1, input2, expected, output);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @CsvFileSource(resources = "divide_test_vals.csv")
    void dataDrivenAdd(double a, double b, double expectedValue) {
        double res = Calculator.divide(a, b);
        assertEquals(expectedValue, res, formatDivideError(a, b, expectedValue, res));
    }

    @Test
    void testDivisionException() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Calculator.divide(12.5, 0),
                "IllegalArgumentException expected."
        );

    }
}