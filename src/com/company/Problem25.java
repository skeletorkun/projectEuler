package com.company;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be:
 *
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 *
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class Problem25 implements ProblemSolver {

    List<BigDecimal> fibos = new ArrayList<>();

    @Override
    public void run() {

        fibos.add(BigDecimal.ONE);
        fibos.add(BigDecimal.ONE);

        int digits = 1;
        int jumps = 0;

        for(long i = 1; i < Long.MAX_VALUE; i++ ){
            BigDecimal fibo = fibo(new BigDecimal(i));

            long fibiDigits = (long) String.valueOf(fibo).length();
            if( fibiDigits > digits){

                if(fibiDigits == 1000){
                    Main.println( i + " th el. digits: " + fibiDigits);
                    break;
                }

            }
        }
    }


    private BigDecimal fibo(BigDecimal x) {

        if(x.compareTo(BigDecimal.ONE) == 0) return BigDecimal.ONE;
        if(x.compareTo(new BigDecimal("2")) == 0) return BigDecimal.ONE;

        if(fibos.size() > x.intValue() && fibos.get(x.intValue() - 1)!=  null ) return  fibos.get(x.intValue()  - 1);

        BigDecimal fib1 = fibo(x.subtract(BigDecimal.ONE));
        BigDecimal fib2 = fibo(x.subtract(new BigDecimal("2")));

        BigDecimal result =  fib1.add(fib2);
        fibos.add(x.intValue() - 1, result);
        return result;
    }
}
