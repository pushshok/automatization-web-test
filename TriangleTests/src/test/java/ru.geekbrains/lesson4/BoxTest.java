package ru.geekbrains.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BoxTest {
    Box box;

    @Nested
    class WhenEmptyTest {
        @BeforeEach
        void createEmptyBox() {
            box = new Box();
        }

        @Test
        void exceptionWhenTryToShuffleBoxTest() {
            Assertions.assertThrows(NullPointerException.class, ()->box.shuffleBalls());
        }

    }
}
