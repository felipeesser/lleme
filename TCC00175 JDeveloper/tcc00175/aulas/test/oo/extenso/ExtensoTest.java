package oo.extenso;

import junit.framework.TestCase;


import org.junit.Test;


public class ExtensoTest extends TestCase {
    public ExtensoTest() {
    }

    public void setUp() {

    }

    @Test
    public void testExtensoNegativo() {
        assertEquals((new Extenso()).extenso(-10), "");
    }

    @Test
    public void testExtensoZero() {
        assertEquals((new Extenso()).extenso(0), "zero");
    }

    @Test
    public void testExtensoOnze() {
        assertEquals((new Extenso()).extenso(11), "onze");
    }

    @Test
    public void testExtensoDoze() {
        assertEquals((new Extenso()).extenso(12), "doze");
    }

    /**
     * @see Extenso#extenso(long)
     */
    @Test
    public void testExtenso345() {
        assertEquals((new Extenso()).extenso(345), "quarenta e cinco");
    }

    @Test
    public void testExtenso58() {
        assertEquals((new Extenso()).extenso(58), "cinquenta e oito");
    }

    @Test
    public void testExtenso99() {
        assertEquals((new Extenso()).extenso(99), "noventa e nove");
    }
}
