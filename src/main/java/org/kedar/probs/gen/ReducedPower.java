package org.kedar.probs.gen;

/**
 * Created by IntelliJ IDEA.
 * User: kedar
 * Date: Feb 4, 2010
 * Time: 4:32:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReducedPower {
    /* Implement a power function for integral arguments without
     * using * or / arithmetic operators (use only + and -)
     */
    static int power(int base, int exp) {
        //should really use the BigInteger, but what the heck ...
        if (exp == 0)
            return 1;
        int result = 0;
        for (int i = 0 ; i < base ; i++)
            result += power(base, exp-1);
        return result;
//        return (base * power(base, exp-1));
    }

    public static void main(String[] args) {
        System.out.println(power(3, 4));
    }
}
