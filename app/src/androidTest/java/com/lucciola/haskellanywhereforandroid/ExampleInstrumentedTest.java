package com.lucciola.haskellanywhereforandroid;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.lucciola.haskell.Haskell;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.lucciola.haskellanywhereforandroid", appContext.getPackageName());

        Haskell haskell = new Haskell();
        haskell.setProgram("main = putStrLn \"Hello, world\"");
        assertEquals("Hello, world\n", haskell.run().getMessage());
        assertEquals(4, 2 + 2);
    }
}
