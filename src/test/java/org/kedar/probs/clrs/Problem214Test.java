package org.kedar.probs.clrs;

import junit.framework.TestCase;

/**
 * Created by IntelliJ IDEA.
 * User: kedar
 * Date: Oct 25, 2009
 * Time: 7:16:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem214Test extends TestCase {
    public void testAddAsArray() {
        int a = 5345;
        int b = 4353;
        int c = Problem214.addAsArray(a, b);
        assertEquals(9698, c);
        a = 54120;
        b = 99234;
        c = Problem214.addAsArray(a, b);
        assertEquals(153354, c);
        a = -1;
        b = 5;
        c = Problem214.addAsArray(a, b);
        assertEquals(4, c);
        a = (Integer.MAX_VALUE - 100);
        b = 100;
        c = Problem214.addAsArray(a, b);
        assertEquals(Integer.MAX_VALUE, c);
        a = Integer.MIN_VALUE;
        b = Integer.MAX_VALUE;
        c = Problem214.addAsArray(a, b);
        assertEquals(-1, c);
        a = -100;
        b = -4256;
        c = Problem214.addAsArray(a, b);
        assertEquals(-4356, c);
    }
}
