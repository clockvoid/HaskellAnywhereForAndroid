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
        manager.input("let test = \"test\""); // input function
        manager.input("let hello = putStrLn \"hello, new world!!!\""); // input function
        manager.input("let ifState n m = n == m"); // function has input values
        manager.input("let hello = print \"hello, new world!!!\""); // rewrite function

        String list = manager.input(":list").getDocumentString();
        String clear = manager.input(":c").getDocumentString();

        assertEquals("test = \"test\"\nifState n m = n == m\nhello = print \"hello, new world!!!\"\n", list);
        assertEquals("clear\n", clear);
        assertEquals("", manager.downInputList());
        assertEquals(":c", manager.upInputList());
        assertEquals(":list", manager.upInputList());
        assertEquals(":c", manager.downInputList());
        assertEquals(":c", manager.downInputList());
    }
}
