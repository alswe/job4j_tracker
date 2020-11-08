package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class FunctionDiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionDiapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = FunctionDiapason.diapason(5, 8, x -> 3 * x * x + 1);
        List<Double> expected = Arrays.asList(76D, 109D, 148D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = FunctionDiapason.diapason(5, 8, x -> 2 * x * x * x * x - 1);
        List<Double> expected = Arrays.asList(1249D, 2591D, 4801D);
        assertThat(result, is(expected));
    }
}