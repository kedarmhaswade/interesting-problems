package org.kedar.probs;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class BasicOnes
{
    /**
     * Problem: Design an algorithm and write code to remove the duplicate characters in a string without using
     * any additional buffer. 
     * @param str an array of characters
     * @return an array of unique characters from str
     */
    public static char[] removeDuplicatesAndReturnCopy(char[] str) {
        int lui = 0;
        for (int j = 1 ; j < str.length ; j++) {
            boolean found = false;
            for (int i = 0 ; i <= lui ; i++) {
                if (str[i] == str[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                lui++;
                str[lui] = str[j];
            }
        }
        char[] dest = new char[lui+1];
        System.arraycopy(str, 0, dest, 0, dest.length);
        return dest;
    }
                                                        
    public void oN2AlgorithmForLinearShuffle(char[] str) {
        if (str == null || 2 * (str.length/2) != str.length)
            throw new IllegalArgumentException("invalid array");
        System.out.println("orig: " + Arrays.toString(str));
        int len = str.length;
        int half = len/2;
        for (int i = 1, j = 0 ; i < len-1 ; i +=2, j++ ) {
            char t = str[i];
            str[i] = str[half+j];
            str[half+j] = t;
            rightRotate(str, i+1, half-i);
        }
        System.out.println("new: " + Arrays.toString(str));
    }

    public static void rightRotate(char[] str, int si, int times) {
        if (0 > si || si >= str.length)
            throw new IllegalArgumentException("starting index "+ si + " should be between 0 and " + str.length);
        if (times < 0)
            throw new IllegalArgumentException("times " + times + " is < 0");
        int len = str.length;
        for (int i = 0 ; i < times ; i++) {
            char last = '\0';
            int j;
            for (j = len-1 ; j >= si ; j--) {
                if (j+1 == len)
                    last = str[j];
                else
                    str[j+1] = str[j];
            }
            if (last != '\0')
                str[j+1] = last;
        }
    }

    public static int[] getPrimes(int N) {
        //implements sieve of eratosthenes
        if (N < 0)
            throw new IllegalArgumentException("Not a non-negative integer:" + N);
        boolean[] possible = new boolean[N];
        Arrays.fill(possible, true); //all numbers are prime
        for (int i = 2 ; i < N ; i++)
            if (possible[i])
                for (int j = i ; j*i < N ; j++) {
                    possible[j*i] = false;
                }
        List<Integer> ints = new ArrayList<Integer>();
        for (int i = 2 ; i < N ; i++)
            if (possible[i])
                ints.add(i);
        int[] ia = new int[ints.size()];
        int index = 0;
        for (Integer ii : ints)
            ia[index++] = ii;
        return ia;
    }

    public static String toEnglish(int i) {
        StringBuilder desc = new StringBuilder();
        if (i < 0) {
            desc.append("minus");
            i *= -1;
        }
        if (i == 0)
            return desc.append(" zero").toString();
        String[] stepNames  = {" billion", " million", " thousand", ""};
        int[] steps = {0, 0, 0, 0};  //billions, millions, thousands, hundreds e.g. 2,045,064,754 = two-billion-forty-five-million-sixty-four-thousand-seven-fifty-four.
        int bil  = 1000000000;
        int mil  = 1000000;
        int thou = 1000;

        int bils = i/bil;
        int rem = i%bil;
        steps[0] = bils;
        
        int mils = rem/mil;
        rem = rem%mil;
        steps[1] = mils;

        int thous = rem/1000;
        steps[2] = thous;
        rem = rem%1000;
        steps[3] = rem;
        
        for (int j = 0 ; j < 4 ; j++) {
            if (steps[j] > 0)
                desc.append(toEnglish1000(steps[j])).append(stepNames[j]);
        }
        return desc.toString();
    }
    public static String toEnglish1000(int i) {
        String[] f20  = {" zero", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"};
        String[] tens = {"ERR", "ERR", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety"};
        if (i >= 1000)
            throw new RuntimeException(i + ": not less than 1000");
        int hundreds = i/100;
        int l2 = i%100;
        if (hundreds == 0 && l2 == 0)
            return "zero";
        StringBuilder desc = new StringBuilder();
        if (hundreds > 0)
            desc.append(f20[hundreds]);
        if (l2 == 0)
            desc.append(" hundred");
        else {
            if (l2 < 20) {
                if (l2 < 10 && hundreds > 0) {
                    desc.append(f20[0]);
                }
                desc.append(f20[l2]);
            } else {
                int t = l2/10;
                int u = l2%10;
                desc.append(tens[t]);
                if (u != 0)
                    desc.append(f20[u]);
            }
        }
        return desc.toString();
    }
    public static void main(String[] args) {
        System.out.println(toEnglish(Integer.parseInt(args[0])));
    }
}