package DP;

import java.util.Scanner;

public class MinPathSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] grid = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(recursionMethod(0, 0, grid, row, col));

        Integer[][] memo = new Integer[row][col];
        memoizationMethod(0, 0, grid, row, col, memo);
        System.out.println(memo[0][0]);

        Integer[][] dp = new Integer[row][col];
        tabulationMethod(grid, dp, row, col);
        System.out.println(dp[0][0]);
    }

    public static void tabulationMethod(int[][] grid, Integer[][] dp, int row, int col) {

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) {
                    dp[i][j] = grid[i][j];
                } else {
                    if (i == row - 1) {
                        dp[i][j] = grid[i][j] + dp[i][j + 1];
                    } else if (j == col - 1) {
                        dp[i][j] = grid[i][j] + dp[i + 1][j];
                    } else {
                        dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }
        }
    }

    public static int memoizationMethod(int x, int y, int[][] grid, int row, int col, Integer[][] memo) {
        if (x >= row || y >= col) {
            return Integer.MAX_VALUE;
        }

        if (memo[x][y] != null) {
            return memo[x][y];
        }

        int rightSum = memoizationMethod(x, y + 1, grid, row, col, memo);
        int downSum = memoizationMethod(x + 1, y, grid, row, col, memo);
        int min = Math.min(rightSum, downSum);
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        memo[x][y] = grid[x][y] + min;
        return memo[x][y];
    }


    public static int recursionMethod(int x, int y, int[][] grid, int row, int col) {
        if (x >= row || y >= col) {
            return Integer.MAX_VALUE;
        }

        int rightSum = recursionMethod(x, y + 1, grid, row, col);
        int downSum = recursionMethod(x + 1, y, grid, row, col);

        int min = Math.min(rightSum, downSum);
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        return grid[x][y] + min;
    }
}

// IP
//        2
//        3
//        1
//        2
//        3
//        4
//        5
//        6
// OP     12