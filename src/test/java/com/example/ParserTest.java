package com.example;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class ParserTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        Assertions.assertTrue(true);
    }

    @Test
    public void parseTest() throws Exception {
        Parser p = new Parser();
        var bReader = new BufferedReader(new StringReader("aaaaabbbbbccccc"));

        var exp = new HashMap<Character, Integer>() {
            {
                put('a', 5);
                put('b', 5);
                put('c', 5);
            }
        };

        var got = p.read(bReader);

        Assertions.assertEquals(exp, got);
    }

    @Test
    public void parseEmptyTest() throws Exception {
        Parser p = new Parser();
        var bReader = new BufferedReader(new StringReader(""));

        var exp = new HashMap<Character, Integer>() {
        };

        var got = p.read(bReader);

        Assertions.assertEquals(exp, got);
    }
}
