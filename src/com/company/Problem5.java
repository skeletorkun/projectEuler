package com.company;


import java.math.BigDecimal;
import java.util.Arrays;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * <p>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * <p>
 * OKEK:
 */
public class Problem5 implements ProblemSolver {


    @Override
    public void run() {

        Integer[] numbers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

//        String s = Arrays.stream(numbers).map(BigDecimal::new).reduce(BigDecimal::multiply).toString();
//        Main.println(s);

        boolean found = false;
        BigDecimal result = new BigDecimal("20");
        while (!found) {

            result = result.add(BigDecimal.ONE);
            final BigDecimal resFinal = result;
            found = Arrays.stream(numbers).allMatch(n -> resFinal.remainder(new BigDecimal(n)).compareTo(BigDecimal.ZERO) == 0);

        }
        Main.println(result);
    }
}
