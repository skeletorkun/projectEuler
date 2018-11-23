package com.company;


import static com.company.Main.println;

/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 implements ProblemSolver {


    @Override
    public void run() {


//        boolean result = isPalindrome(10109);
//        println(result);

        long max = 0;
        for (int i = 999; i > 0; i--) {
            for (int j = 999; j > 0; j--) {
                if (isPalindrome(i * j) && i > 100 && j > 100) {
                    max = Math.max(max, i * j);
                }
            }
        }
        println(max);

    }


    boolean isPalindrome(long x) {

        String str = String.valueOf(x);

        for (int i = 0; i < str.length() / 2; i++) {
            char charFromReverse = str.charAt(str.length() - (i + 1));
            if (str.charAt(i) != charFromReverse) {
                return false;
            }
        }
        return true;
    }


}
