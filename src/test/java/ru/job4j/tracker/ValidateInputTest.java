package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(List.of("one", "two", "three", "1"));
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(List.of("0"));
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(0));
    }

    @Test
    public void outputCheck() {
        Output out = new StubOutput();
        Input in = new StubInput(List.of("two", "0"));
        ValidateInput input = new ValidateInput(out, in);
        input.askInt("Enter menu:");
        assertThat(out.toString(), is(
                "Please enter validate data again." + System.lineSeparator()));
    }
}