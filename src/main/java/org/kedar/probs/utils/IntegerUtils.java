package org.kedar.probs.utils;

import java.io.*;
import java.util.Random;

/**
 * Provides some utilities that have to do with integers.
 */
public final class IntegerUtils {


    public static void generateUniqueRandomIntegers(long n, File f) throws IOException {
        f.createNewFile();
        if (!f.canWrite())
            throw new IllegalArgumentException("File not writable: " +f.getAbsolutePath());
        Random r = new Random(n);
        Bitmap bm = new Bitmap();
        int num_done = 0;
        while (num_done < n) {
            int next = r.nextInt();
            long indexInBitmap = next + (1L << 31); // a number 10 is located at 10 + 1<<31 in the Bitmap
            if (!bm.test(indexInBitmap)) { //this bit is not set, which should be the normal case
                //System.out.println("bit#" + indexInBitmap);
                bm.set(indexInBitmap);
                num_done++;
            }
        }
        System.out.println("num_done setting bits : " + num_done);
        //now we have exactly n bits set in the bitmap
        PrintWriter p = new PrintWriter(new FileWriter(f));
        num_done = 0;
        for(long i = 0 ; i < bm.capacity(); i++) {
            if (bm.test(i)) {
                //System.out.println("bit#" + i);
                p.println((int) (i - (1L << 31)));
                num_done++;
          }
        }
        System.out.println("num_done writing: " + num_done);
        p.close();
    }

    public static void generateUniqueFourBillionRandomIntegers(File f) throws IOException {
        generateUniqueRandomIntegers(4000000000L, f);
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(4000000000L);
//        System.out.println(1L << 32);
        generateUniqueRandomIntegers(1<<20, new File("/tmp", "4b.txt"));
    }
}

class OffsetBitmap {
    private final Bitmap bm;
    private final int offset;
    private final long size;
    public OffsetBitmap(int offset, long size) {
        this.offset = offset;
        this.size   = size;
        this.bm     = new Bitmap();
    }
}

class Bitmap {
    private final int[] ints;
    public static final long BITMAP_CAP = 1L << 32;

    public Bitmap() {
        this.ints = new int[(int) (BITMAP_CAP/32L)];
        System.out.println("capacity: " + ints.length);
        for (int i = 0 ; i < ints.length ; i++)
            ints[i] = 0;
    }

    public void set(long idx) {
        ints[bucket(idx)] |= (1 << offset(idx));
    }
    public void clear(long idx) {
        ints[bucket(idx)] &= ~(1<< offset(idx));
    }
    public boolean test(long idx) {
        int off = offset(idx);
        return (ints[bucket(idx)] & (1<< off)) != 0;
    }

    public long capacity() {
        return BITMAP_CAP;
    }

    public static void main(String[] args) {
        Bitmap bm = new Bitmap();
        bm.set(4000000000L);
        System.out.println(bm.test(4000000000L));
        bm.clear(4000000000L);
        System.out.println(bm.test(4000000000L));
        for (int p = 0 ; p < 32 ; p++)
            bm.set(1L<<p);
        for (int p = 0 ; p < 32 ; p++)
            System.out.println(bm.test(1L<<p));
    }
    private int bucket(long idx) {
//        System.out.println("bucket: " + (int) (idx/64));
        return (int) (idx / 32L);
    }
    private int offset(long idx) {
//        System.out.println("offset: " + (int) (idx%64));
        return (int) (idx % 32);
    }
}
