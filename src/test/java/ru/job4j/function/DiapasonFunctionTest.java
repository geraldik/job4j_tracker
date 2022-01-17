package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DiapasonFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        DiapasonFunction function = new DiapasonFunction();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        DiapasonFunction function = new DiapasonFunction();
        List<Double> result = function.diapason(5, 8, x -> x * x + 2);
        List<Double> expected = Arrays.asList(27D, 38D, 51D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSignificantFunctionThenSignificantResults() {
        DiapasonFunction function = new DiapasonFunction();
        List<Double> result = function.diapason(2, 6, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(4D, 8D, 16D, 32D);
        assertThat(result, is(expected));
    }
}