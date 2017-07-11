package com.lucciola.haskellanywhereforandroid;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hiden on 2017/06/13.
 */

public class ProgramManagerTest {
    @Test
    public void addition_inCorrect() throws Exception {
        ProgramManager manager = new ProgramManager();
        int one = manager.input("let test = \"test\"").getMode(); // input function
        int two = manager.input("let hello = putStrLn \"hello, new world!!!\"").getMode(); // input function
        int three = manager.input("let ifState n m = n == m").getMode(); // function has input values
        int four = manager.input("let hello = print \"hello, new world!!!\"").getMode(); // rewrite function

        assertEquals(Action.MODE_FUNCTION, one);

        /*String list = manager.input(":list").getDocumentString();
        String clear = manager.input(":c").getDocumentString();*/

        /*assertEquals("test = \"test\"\nifState n m = n == m\nhello = print \"hello, new world!!!\"\n", list);
        assertEquals("clear\n", clear);
        assertEquals("", manager.downInputList());
        assertEquals(":c", manager.upInputList());
        assertEquals(":list", manager.upInputList());
        assertEquals(":c", manager.downInputList());
        assertEquals(":c", manager.downInputList()); */
    }
}
