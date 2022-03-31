package ru.geekbrains.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static ru.geekbrains.lesson4.Functions.isPalindrome;
import static ru.geekbrains.lesson4.Functions.isPrime;

public class FunctionsTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Выполняется перед началом всех тестов, например, авторизация. Объявить драйвер, " +
                "создать пост для редактирования во всех остальных тестах.");
    }

    @BeforeEach
    void beforeEach() {
        //Webdriver driver = new Webdriver();
        System.out.println("Выполняется перед каждым тестом.");
    }

    @Test // GivEn - что нам дано / When - когда что происходит / Then - тогда что делаем
    @DisplayName("Check for simple number")
    void givenPrimeNumberWhenCallisPrimeThenTrue(){
        boolean result = isPrime(7);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Check number is palindrome")
    void givenNumberisPalindromeThenTrue(){
        Assertions.assertTrue(isPalindrome("123321"));
    }

    @Test
    @DisplayName("Check number is not palindrome")
    void givenNumberisNotPalindromeThenTrue(){
        Assertions.assertFalse(isPalindrome("12"));
    }


    @Test
    @DisplayName("Simple check number is palindrome 2")
    void givenNumberisPalindromeThenTrue2(){
        Assertions.assertTrue(isPalindrome("1235321"));
    }

    @Test
    @DisplayName("Twiced check number is palindrome 2")
    void commonIsPalindromeThenTrue(){
        Assertions.assertEquals(false, isPalindrome("123"));
        Assertions.assertEquals(true, isPalindrome("121"));
    }

    @ParameterizedTest
    @DisplayName("Tables check number is palindrome 2")
    @CsvSource({"true, 1221", "false, 12"})
    void tablesNumberIsPalindromeThenTrue(boolean exectedResult, String word){
        Assertions.assertEquals(exectedResult, isPalindrome(word));
    }

    @ParameterizedTest
    @DisplayName("Check params number is palindrome")
    @ValueSource(strings = {"12344321", "1237321"})
    void givenParamsNumberisPalindromeThenTrue(String word){
        Assertions.assertTrue(isPalindrome(word));
    }

    @ParameterizedTest
    @DisplayName("Cat test")
    @MethodSource("catAndAgeDataProvider")
    void catTest(Cat cat, Integer age) {
        Assertions.assertEquals(age, cat.getAge());
    }

    private static Stream<Arguments> catAndAgeDataProvider() {
        return Stream.of(
                Arguments.of(new Cat("Barsik", 10), 10),
                Arguments.of(new Cat("Murzik", 10), 11)

        );
    }

    @AfterEach
    void afterEach(){
        System.out.println("Выполняется после каждого теста.");
        //driver.quit;
    }


    @AfterAll
    static void afterAll() {
        System.out.println("Выполняется после всех тестов, в случае возникновения исключения всё равно" +
                " запустится в любом случае. Например, удаление статей, вновь созданных данных.");
    }
}
