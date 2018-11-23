package com.company;

import java.util.HashMap;
import java.util.Map;

import static com.company.Main.println;

public class Problem2 implements ProblemSolver {

    private static Map<Long, Long> fibos = new HashMap<>();

    public void run() {
        long x = 1;
        long result = 0;

        long sumOfEvenValuedTerms = 0;
        while (result < 4000000) {
            result = fibo(x++);
            if (result % 2 == 0 && result < 4000000) {
                sumOfEvenValuedTerms += result;
            }
        }

        println(sumOfEvenValuedTerms);
    }

    private static long fibo(long x) {
        if (x == 1) return 1;
        if (x == 2) return 2;

        if (fibos.containsKey(x)) {
            return fibos.get(x);
        }

        long result = fibo(x - 2) + fibo(x - 1);
        fibos.put(x, result);

        return result;
    }

    private static void getSumUpto() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        println("sum " + sum);
    }
}
