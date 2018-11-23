package com.company;


import java.math.BigDecimal;

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 */
public class Problem20 implements ProblemSolver {

    @Override
    public void run() {

        BigDecimal num = new BigDecimal("100");
        BigDecimal result = factorial(num);
        Main.println(result);

        int sum = 0;
        char[] chars = result.toString().toCharArray();
        Main.println(chars.length);


        for(int i = 0; i< chars.length; i++){
            sum += Integer.valueOf(String.valueOf(chars[i]));
        }


        Main.println(sum);
    }


    private BigDecimal factorial(BigDecimal x) {

        if(x.compareTo(BigDecimal.ONE) == 0) return BigDecimal.ONE;

        return x.multiply(factorial(x.subtract(BigDecimal.ONE)));
    }
}
