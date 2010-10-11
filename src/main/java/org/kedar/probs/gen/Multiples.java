package org.kedar.probs.gen;

/**
 * http://projecteuler.net/index.php?section=problems&id=1
 */
public class Multiples {

    public static void main(String[] args) throws Exception {
        int i = Integer.parseInt(args[0]);
        System.out.println("sum is: " + sumMultiples(i));
        System.out.println("sum is: " + sumMultiplesUsingFormula(i));
    }

    private static int sumMultiples(int limit) {
        int i = 3;
        int sum = 0;
        while (i < limit) {
            if (i % 3 == 0 || i % 5 == 0)
                sum += i;
            i++;
        }
        return sum;
    }
    private static int sumMultiplesUsingFormula(int limit) {
        int sum = 333*501+ 199*500 - 33*1005;
        return sum;
    }
}
