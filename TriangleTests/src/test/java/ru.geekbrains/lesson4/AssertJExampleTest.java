package ru.geekbrains.lesson4;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExampleTest {
    @Test
    void AssertJExample() {
        AssertJExample();
        assertThat(Functions.isPrime(5)).isTrue();
        List<String> strings = new ArrayList<>(Arrays.asList("test1", "test", "test2"));
        assertThat(strings).containsAnyOf("testz", "test2");
    }

}
