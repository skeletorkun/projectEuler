package com.company;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 * <p>
 * 1634 = 14 + 64 + 34 + 44
 * 8208 = 84 + 24 + 04 + 84
 * 9474 = 94 + 44 + 74 + 44
 * As 1 = 14 is not a sum it is not included.
 * <p>
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * <p>
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
public class Problem30 implements ProblemSolver {

    int POW95 = 59049; // Math.pow(9, 5)
    int maxWithAddition = 354294;

    @Override
    public void run() {
        List<Integer> numbers = findNumbers();
        Main.println(numbers);
        Main.println(numbers.stream().reduce(Math::addExact));

    }

    private List<Integer> findNumbers() {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 2; i < maxWithAddition; i++) {

            long additionByDigit = getAdditionByDigit(i);

            if (i == (int) additionByDigit) {

                Main.println("found ! " + i);
                numbers.add(i);
            }


        }
        return numbers;
    }

    private long getAdditionByDigit(int num) {
        String numStr = String.valueOf(num);

        long sum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            sum += Math.pow(Integer.valueOf(numStr.substring(i, i + 1)), 5);
        }
//        Main.println("num : " + num + " sum :" + sum);
        return sum;
    }

    private BigDecimal getMax() {

        String maxStr = "99";
        while (true) {
            char[] s = maxStr.toCharArray();
            BigDecimal maxYouCanGetWithAddition = new BigDecimal(POW95 * s.length);
            Main.println("maxStr : " + maxStr + " maxYouCanGetWithAddition :" + maxYouCanGetWithAddition);

            BigDecimal max = new BigDecimal(maxStr);
            if (max.compareTo(maxYouCanGetWithAddition) > 0) {
                return maxYouCanGetWithAddition;
            }
            maxStr = maxStr + "9";
        }
    }

}
