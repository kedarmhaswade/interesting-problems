package org.kedar.probs.utils;

import org.junit.Test;
import junit.framework.TestCase;

/**
 * This is a test for the Bitmap that allows more than 1<<31 entries.
 *
 */
public class BitmapTest extends TestCase {

    @Test
    public void testBasics() {
        Bitmap bm = new Bitmap(1L<<33);
        bm.set(4000000000L);
        assertTrue(bm.test(4000000000L));
        assertFalse(bm.test(13L));
        bm.clear(4000000000L);
        assertFalse(bm.test(128L));
        for (int p = 0 ; p < 33 ; p++)
            bm.set(1L<<p);
        for (int p = 0 ; p < 33 ; p++)
            assertTrue(bm.test(1L<<p));
    }
}
