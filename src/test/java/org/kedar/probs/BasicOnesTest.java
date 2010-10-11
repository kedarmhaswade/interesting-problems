package org.kedar.probs;

import static org.junit.Assert.assertArrayEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;

import java.util.Arrays;

/**
 * @author &#2325;&#2375;&#2342;&#2366;&#2352 (km@dev.java.net)
 */
public class BasicOnesTest {
    private static final char[] A_Z = new char[26];
    @BeforeClass
    public static void setup() {
        setupA_Z();
    }

    private static void setupA_Z() {
        int a = 'a';
        int len = 26;
        for (int i = 0 ; i < len ; i++)
            A_Z[i] = (char) (a+i);
    }

    @Test
    public void rd1() {
        char[] str1 = "abcd".toCharArray();
        char[] str2 = BasicOnes.removeDuplicatesAndReturnCopy(str1);
        assertArrayEquals(str1, str2);
    }
    @Test
    public void rd2() {
        char[] str1 = "abca".toCharArray();
        char[] unik = "abc".toCharArray();

        char[] str2 = BasicOnes.removeDuplicatesAndReturnCopy(str1);
        assertArrayEquals(unik, str2);
    }
    @Test
    public void a_z() {
        char[] str = BasicOnes.removeDuplicatesAndReturnCopy(A_Z);
        assertArrayEquals(A_Z, str);
    }
    @Test
    public void same() {
        char[] str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb".toCharArray();
        assertArrayEquals(new char[]{'a', 'b'}, BasicOnes.removeDuplicatesAndReturnCopy(str));
    }
    @Test
    public void random() {
        char[] str = "aaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbcdefghijklmnopqrstuvwxyzaaaaaaaaaaaabbbbbbbbbbessssssssssssssssssssssssssssssssssssssrwerrrrrrrrfgfgfgdfgfgfgfkgfdk".toCharArray();
        char[] ret = BasicOnes.removeDuplicatesAndReturnCopy(str);
        assertArrayEquals(A_Z, ret);
    }
    @Test
    public void multiple() {
        int freq = 1000;
        int len = 26*freq;
        char[] a = new char[len];
        for (int i = 0 ; i < 26 ; i++) {
            for (int j = 0 ; j < freq ; j ++) {
                a[i*freq + j] = A_Z[i];
            }
        }
        assertArrayEquals(A_Z, BasicOnes.removeDuplicatesAndReturnCopy(a));
    }

    @Test
    public void rotate1() {
        char[] str = "abcd".toCharArray();
        BasicOnes.rightRotate(str, 0, 1);
        assertArrayEquals("dabc".toCharArray(), str);
    }
    @Test
    public void backToOriginal() {
        char[] str = "fdssssssssssssssss435rerfdfsdfdsfsdsdfdsfdsfsdfsdfsdfdsdsfsdfsdbvghdfghtyjyusrerererer".toCharArray();
        char[] copy = new char[str.length];
        System.arraycopy(str, 0, copy, 0, str.length);
        BasicOnes.rightRotate(str, 0, str.length);
        assertArrayEquals(copy, str);
    }
    @Test
    public void partial1() {
        char[] str = "abcd".toCharArray();
        BasicOnes.rightRotate(str, 1, 2);
        assertArrayEquals("acdb".toCharArray(), str);
    }
    @Test
    public void reverse() {
        char[] a_z = new char[26];
        char[] z_a = new char[26];
        for (int i = 0 ; i < 26 ; i++) {
            a_z[i] = (char) ('a' + i);
            z_a[25-i] = a_z[i];
        }
        for (int si = 24 ; si >= 0 ; si--)
            BasicOnes.rightRotate(a_z, si, 25-si);
        assertArrayEquals(z_a, a_z);
    }
    @Ignore
    @Test
    public void testPrimes1() {
        int n = Integer.MAX_VALUE >> 10;
        //int[] expp = {2, 3, 5, 7, 11, 13};
        int[] actp = BasicOnes.getPrimes(n);
        System.out.println(Arrays.toString(actp));
        //assertArrayEquals(expp, actp);
    }
}

