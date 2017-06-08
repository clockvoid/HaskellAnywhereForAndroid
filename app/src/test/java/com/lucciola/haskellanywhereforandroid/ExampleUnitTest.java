package com.lucciola.haskellanywhereforandroid;

import org.junit.Test;
import core.HaskellAnywhere;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        HaskellAnywhere haskell = new HaskellAnywhere();
        assertEquals("\"Hello, world\"\n", haskell.input("\"Hello, world\"").getMessage());
        assertEquals(4, 2 + 2);
    }
}