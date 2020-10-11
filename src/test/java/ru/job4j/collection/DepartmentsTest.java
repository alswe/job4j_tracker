package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void sortAscTest() {
        List<String> myDepartments = Arrays.asList("K1/SK1/SSK2", "K1/SK2", "K2/SK1/SSK2",
                "K2/SK1/SSK1", "K1/SK1/SSK1");
        List<String> result = Departments.fillGaps(myDepartments);
        Departments.sortAsc(result);
        List<String> expected = Arrays.asList("K1", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2",
                "K1/SK2", "K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2");
        assertThat(result, is(expected));
    }

    @Test
    public void sortDescTest() {
        List<String> myDepartments = Arrays.asList("K1/SK1/SSK2", "K1/SK2", "K2/SK1/SSK2",
                "K2/SK1/SSK1", "K1/SK1/SSK1");
        List<String> result = Departments.fillGaps(myDepartments);
        System.out.println(result.toString());
        Departments.sortDesc(result);
        List<String> expected = Arrays.asList("K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2",
                "K1", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2");
        assertThat(result, is(expected));
    }
}