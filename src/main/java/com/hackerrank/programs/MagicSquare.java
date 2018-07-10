package com.hackerrank.programs;

import java.util.HashMap;

public class MagicSquare {

    private static int n = 3;
    private static final int MAGIC_NUMBER = 15;
    private static int[][] indexes;
    private static final int MAX_VALUE = 9;
    private static HashMap<Integer, Boolean> numbers = new HashMap<>();

    private enum Direction {
        CENTRE, CORNER, EDGES
    }

    /*
     * private static class IndexNumber { int num; boolean isUsed;
     * 
     * IndexNumber(int num, boolean isUsed) { this.num = num; this.isUsed =
     * isUsed; } }
     */
    static int formingMagicSquare(int[][] s) {

        return countPosibilies(s);
    }

    static int countPosibilies(int[][] s) {
        indexes = s;
        int count = 0;

        for (int i = 1; i <= MAX_VALUE; i++) {
            numbers.put(i, Boolean.FALSE);
        }

        count += computeIndex(Direction.CENTRE, 1, 1);

        for (int i = 0; i < n; i += 2) {
            for (int j = 0; j < n; j += 2) {
                count += computeIndex(Direction.CORNER, i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = (i == 1 ? 0 : 1); j < n; j += 2) {
                count += computeIndex(Direction.EDGES, i, j);
            }
        }
        return count;
    }

    public static int computeIndex(Direction direction, int row, int col) {
        int diff = 0;
        switch (direction) {
        case CENTRE:
            diff = 5 - indexes[row][col];
            numbers.put(5, true);
            break;

        case CORNER:
            System.out.println("corner value " + indexes[row][col]);
            if (indexes[row][col] % 2 != 0 || numbers.get(indexes[row][col])) {
                for (int i = 2; i < MAX_VALUE; i += 2) {
                    if (!numbers.get(i)) {
                        diff = i - indexes[row][col];
                        numbers.put(i, true);
                        break;
                    }

                }
            } else
                numbers.put(indexes[row][col], true);
            break;

        case EDGES:
            System.out.println("edges value " + indexes[row][col]);

            int value = 0;
            for (int j = 0; j < n; j++) {
                value += indexes[row][j];
            }

            if (value > MAGIC_NUMBER || (indexes[row][col] % 2 == 0
                    || numbers.get(indexes[row][col]))) {

                value = MAGIC_NUMBER - (value - indexes[row][col]);

                numbers.put(value, true);
                diff = Math.abs(indexes[row][col] - value);

                if (indexes[row][col] > value)
                    diff *= -1;
            } else
                numbers.put(indexes[row][col], true);
            break;
        }

        if (diff != 0) {
            indexes[row][col] += diff;
        }
        return Math.abs(diff);
    }

    public static void main(String[] args) {
        int[][] s = { { 2, 9, 8 }, { 4, 2, 7 }, { 5, 6, 7 } };

        formingMagicSquare(s);
    }

}
