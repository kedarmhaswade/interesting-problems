package org.kedar.probs.clrs;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: kedar
 * Date: Oct 25, 2009
 * Time: 5:33:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem214 {
    /**
     *
     */
    public static int addAsArray(int a, int b) {
        int[] a1 = toTwosComplementArray(a);
        int[] a2 = toTwosComplementArray(b);
        int[] a3 = add(a1, a2);
        int r    = numberWithOverflow(a3);
        System.out.println("r = " + r);
        return r;
    }

    private static int[] toTwosComplementArray(int a) {
        int[] ints = new int[32];
        for (int i = 0 ; i < 32 ; i++)
            ints[i] = 0;
        int i = 31;
        while (i >= 1) {
            ints[i--] = a & 1;
            a = a >> 1;
        }
        ints[i] = a & 1;
        System.out.println(Arrays.toString(ints));
        return ints;
    }

    private static int[] add(int[] a1, int[] a2) {
        int[] a3 = new int[a1.length];
        int carry = 0;
        for (int i = 31 ; i >= 0 ; i--) {
            if (a1[i] == a2[i]) {
                a3[i] = carry;
                carry = a1[i];
            } else {
                a3[i] = (carry == 0 ? 1 : 0);
            }
        }
        System.out.println(Arrays.toString(a3));        
        return a3;
    }

    private static int numberWithOverflow(int[] a) {
        int pot = 1;
        int number = 0;
        for (int i = 31 ; i >= 0 ; i--) {
            number += (a[i] * pot);
            pot *=  2;
            System.out.println("numberWithOverflow: " + number);
        }
        return number;
    }
}
