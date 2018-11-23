package com.company;


import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Problem6 implements ProblemSolver {


    @Override
    public void run() {

        BigDecimal sumSquares = BigDecimal.ZERO;
        for (int i = 1; i <= 100; i++) {
            sumSquares = sumSquares.add(new BigDecimal(i));
        }
        sumSquares = sumSquares.multiply(sumSquares);
        Main.println(sumSquares);

        BigDecimal squareSum = BigDecimal.ZERO;
        for (int i = 0; i < 101; i++) {
            squareSum = squareSum.add(new BigDecimal(i * i));
        }
        Main.println(squareSum);

        Main.println(squareSum.subtract(sumSquares));

    }
}
