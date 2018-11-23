package com.company;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.company.Main.println;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p>
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem3 implements ProblemSolver {

    private static Map<Long, Long> primes = new HashMap<>();

    Map<Long, Boolean> numbers = new HashMap<>();

    @Override
    public void run() {

        long target = 600851475143L;
        List<Long> primeFactors = getPrimeFactors(target);

        long sumOfPrimeFactors = primeFactors.stream().reduce((x, y) -> x + y).get();
        println(primeFactors);
        println(sumOfPrimeFactors);

    }


    List<Long> getPrimeFactors(long x) {

        List<Long> primeFactors = new ArrayList<>();

        for (long i = 2; i <= x; i++) {
            if (x % i == 0 && isPrime(i)) {
                primeFactors.add(i);
                x /= i;
            }
        }
        return primeFactors;
    }

    boolean isPrime(long x) {

        if (x == 1) return false;
        if (x == 2) return true;

        if (numbers.containsKey(x)) {
            return numbers.get(x);
        }
        for (long i = 2; i < x; i++) {
            if (x % i == 0) {
                numbers.put(x, false);
                return false;
            }
        }

        numbers.put(x, true);
        return true;

    }
}
