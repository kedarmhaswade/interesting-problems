package org.kedar.probs.gen;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: kedar
 * Date: Jan 2, 2010
 * Time: 12:01:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class EfficientMode {
    static int findmode(int[] p, int n) {
        int count[] = new int[32];
        for(int i = 0; i < 32; i++)
            count[i] = 0;
        for (int i = 0; i < n; i++)
             for (int j = 0; j < 32; j++)
                   if ((p[i] & (1 << j)) > 0) // if bit j is on
                        count[j]++;
                   else
                        count[j]--;
        System.out.println("bit array is: " + Arrays.toString(count));
        int x = 0;
        for (int i = 0; i < 32; i++)
            if (count[i] > 0)
                x = x | (1 << i);
        return x;
    }
    public static void main(String... args) {
        //int[] a = array(10);
        System.out.println(Integer.bitCount(-6));
        int[] a = almostOpposites(10);
        System.out.println("x is : " + findmode(a, a.length));
    }

    private static int[] array(int n) {
        int[] a = new int[n];
        for (int i = 0 ; i < n ; i++)
            a[i] = 0;
        for (int i = 0 ; i < n/2-2; i++)
            a[i] = 100;
        a[n/2-2] = n;
        for(int i = n/2-1 ; i < n ; i++)
            a[i] = 5;
        System.out.println(Arrays.toString(a));
        return a;
    }
    private static int[] almostOpposites(int n) {
        int[] a = new int[n];
        for (int i = 0 ; i < n ; i++)
            a[i] = 0;
        for (int i = 0 ; i < n/2-1 ; i++)
            a[i] = ~5;
        for (int i = n/2-1 ; i < n ; i++)
            a[i] = 5;
        System.out.println(Arrays.toString(a));
        return a;
    }
}
