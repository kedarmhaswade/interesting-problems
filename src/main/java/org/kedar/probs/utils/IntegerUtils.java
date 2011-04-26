package org.kedar.probs.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.BitSet;
import java.util.Random;

/**
 * Provides some utilities that have to do with integers.
 */
public final class IntegerUtils {

    public final static long NUMBER_OF_32_BIT_NUMBERS = 1L << 32;

    public void generateUniqueRandomIntegers(long n, File f) throws IOException {
        if (n > NUMBER_OF_32_BIT_NUMBERS || n < 1)
            throw new IllegalArgumentException(n + " : out of range [1, " + NUMBER_OF_32_BIT_NUMBERS +"]");
        if (!f.canWrite())
            throw new IllegalArgumentException("File not writable: " +f.getAbsolutePath());
        Random r = new Random(n);
        Bitmap bm = new Bitmap(NUMBER_OF_32_BIT_NUMBERS);
        int num_done = 0;
        while (num_done < n) {
            int next = r.nextInt();
            long indexInBitmap = next + (2 << 31); // a number 10 is located at 10 + 2<<31 in the Bitmap
            if (!bm.test(indexInBitmap)) { //this bit is not set, which should be the normal case
                bm.set(indexInBitmap);
                num_done++;
            }
        }
        //now we have exactly n bits set in the bitmap
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        for(long i = 0 ; i < n ; i++) {
            if (bm.test(i)) {
                bw.write((int)i - (2 << 31));
            }
        }
        if (bw != null)
            bw.close();
    }

    public void generateUniqueFourBillionRandomIntegers(File f) throws IOException {
        generateUniqueRandomIntegers(4000000000L, f);
    }

    public static void main(String[] args) {
        System.out.println(4000000000L);
        System.out.println(1L << 32);
    }
}

class OffsetBitmap {
    private final Bitmap bm;
    private final int offset;
    private final long size;
    public OffsetBitmap(int offset, long size) {
        this.offset = offset;
        this.size   = size;
        this.bm     = new Bitmap(size);
    }
}

class Bitmap {
    private final long size;
    private final int[] words;

    public Bitmap(long size) {
        this.size = size;
        words = new int[(int)(size/64)];
        for (int i = 0 ; i < words.length ; i++)
            words[i] = 0;
    }

    public void set(long idx) {
        words[index(idx)] |= (1 << offset(idx));
    }
    public void clear(long idx) {
        words[index(idx)] &= ~(1<< offset(idx));
    }
    public boolean test(long idx) {
        int off = offset(idx);
        int thatBit = (words[index(idx)] & (1<< off)) >> off;
        if (thatBit == 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Bitmap bm = new Bitmap(1L<<33);
        bm.set(4000000000L);
        System.out.println(bm.test(4000000000L));
        bm.clear(4000000000L);
        System.out.println(bm.test(4000000000L));
        for (int p = 0 ; p < 33 ; p++)
            bm.set(1L<<p);
        for (int p = 0 ; p < 33 ; p++)
            System.out.println(bm.test(1L<<p));
    }
    private int index(long idx) {
        System.out.println("bucket: " + (int) (idx/64));
        return (int) (idx / 64);
    }
    private int offset(long idx) {
        System.out.println("offset: " + (int) (idx%64));
        return (int) (idx % 64);
    }
}
