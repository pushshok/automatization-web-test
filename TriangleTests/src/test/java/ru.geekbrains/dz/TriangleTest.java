package ru.geekbrains.dz;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

public class TriangleTest {

    @Nested
    class WhenOneOrMoreParamsEqualNullTests {
        @ParameterizedTest
        @DisplayName("Normal triangle test for count square")
        @MethodSource("triangleSidesDataProvider")
        void triangleSquareTest(TriangleSquare triangle, Double square) {
            Assertions.assertEquals(triangle.getSquare(), square);
        }

        private static Stream<Arguments> triangleSidesDataProvider() throws TriangleSideException {
            return Stream.of(
                    Arguments.of(new TriangleSquare(3, 4, 5), 6.0)
            );
        }
    }

    @Nested
    class WhenAllSidesEqualNullTests {

        @ParameterizedTest
        @DisplayName("Check for create triangle with all sides equal null")
        @MethodSource("triangleAllSidesEqualNullDataProvider")
        void exceptionWhenAllSidesEqualNullTest (TriangleSquare triangleSquare) {
            Assertions.assertThrows(TriangleSideException.class, (Executable) triangleSquare);
        }

        private static Stream<Arguments> triangleAllSidesEqualNullDataProvider() throws TriangleSideException {
            return Stream.of(
                    Arguments.of(new TriangleSquare(0, 0, 0))
            );
        }
    }


    @Nested
    class WhenOneSideLargerOrEqualTwoTests {

        @ParameterizedTest
        @DisplayName("Check for create triangle with one side larger two")
        @MethodSource("triangleSidesOneLargerTwoDataProvider")
        void exceptionWhenOneSideLargerOrEqualTwoTest (TriangleSquare triangleSquare) {
            Assertions.assertThrows(TriangleSideException.class, (Executable) triangleSquare);
        }

        private static Stream<Arguments> triangleSidesOneLargerTwoDataProvider() throws TriangleSideException {
            return Stream.of(
                    Arguments.of(new TriangleSquare(2, 2, 5))
            );
        }
    }
}
