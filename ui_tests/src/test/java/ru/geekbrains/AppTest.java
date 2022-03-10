package ru.geekbrains;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( 1 != 1 );
    }

    @Test
    public void shouldAnswerWithTrue1()
    {
        assertTrue( true );
    }

    @Test
    public void shouldAnswerWithTrue2() {
        assertNotNull(0);
    }

    @Test
    public void shouldAnswerWithTrue3() {
        System.out.println("Fourth test!");
    }
}
