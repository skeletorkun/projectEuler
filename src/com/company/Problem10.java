package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * <p>
 * Find the sum of all the primes below two million.
 */
public class Problem10 implements ProblemSolver {

    private List<Long> primes = new ArrayList<>();

    @Override
    public void run() {

        primes.add(2L);

        long sum = 0;
        for (int i = 2; i < 2000000; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        Main.println(sum);
    }


    private boolean isPrime(long num) {

        if (num == 1) return false;
        if (num == 2) return true;

        for (int i = 0; i < primes.size(); i++) {
            if (num % primes.get(i) == 0) {
                return false;
            }
        }
        primes.add(num);
        return true;
    }
}
