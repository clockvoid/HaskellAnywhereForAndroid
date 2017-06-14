package com.lucciola.haskellanywhereforandroid;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hiden on 2017/06/13.
 */

public class ProgramControllerTest {
    @Test
    public void addition_inCorrect() throws Exception {
        ProgramCollector collector = new ProgramCollector();
        collector.input("test = \"test\"");
        collector.input("hello = putStrLn \"hello, new world!!!\"");
        collector.input("ifState n m = n == m");

        String list = collector.getProgramList();

        assertEquals("test = \"test\"\nifState n m = n == m\nhello = putStrLn \"hello, new world!!!\"\n", list);
    }
}
