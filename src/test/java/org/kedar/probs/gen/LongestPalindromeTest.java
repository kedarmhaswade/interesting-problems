package org.kedar.probs.gen;

import junit.framework.TestCase;

/**
 * Created by IntelliJ IDEA.
 * User: kedar
 * Date: Oct 11, 2010
 * Time: 12:32:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestPalindromeTest extends TestCase {
    public void testSimpleOnes() {
        String s = "abcdde";
        String lp = new LongestPalindrome(s).get();
        assertEquals("dd", lp);
        s = "abcba";
        lp = new LongestPalindrome(s).get();
        assertEquals(s, lp);
        s = "abcbabcdcba";
        lp = new LongestPalindrome(s).get();
        assertEquals("abcdcba", lp);
    }
}
