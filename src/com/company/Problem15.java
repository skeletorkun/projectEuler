package com.company;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 * How many such routes are there through a 20×20 grid?
 */
public class Problem15 implements ProblemSolver {

    private BigDecimal counter = BigDecimal.ZERO;

    private final int size = 20;

    @Override
    public void run() {

        int x = 0, y = 0;
        choose(x, y);
        Main.println(counter);
    }


    private void choose(int x, int y) {

//        if (x == 10 && y == 10) {
//            Main.println("reached! " + counter);
//        }


        if (x == size && y == size) {
            counter = counter.add(BigDecimal.ONE);
            return;
        }

        if (x < size) {
            choose(x + 1, y);
        }

        if (y < size) {
            choose(x, y + 1);
        }
    }
}
