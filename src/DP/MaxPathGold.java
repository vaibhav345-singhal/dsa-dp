package DP;

import java.util.Arrays;
import java.util.Scanner;

public class MaxPathGold {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();

        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.nextInt();
            }
        }

        // directions in that miner can move

//                  /
//                  --
//                  \


        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = grid[i][n - 1]; // miner cant go beyond last column
        }

        // not moving like this moving column wise from last
//        for (int i = 0; i < m; i++) {
//            for (int j = n - 2; j >= 0; j--) {
//                if (i == 0) {
//                    dp[i][j] = grid[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
//                } else if (i == m - 1) {
//                    dp[i][j] = grid[i][j] + Math.max(dp[i - 1][j + 1], dp[i][j + 1]);
//                } else {
//                    dp[i][j] = grid[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
//                }
//            }
//        }

        for (int j = n - 2; j >= 0; j--) {
            for (int i = 0; i < m; i++) { // doesn't matter if we solve from up to down or down to up
                if (i == 0) {
                    dp[i][j] = grid[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else if (i == m - 1) {
                    dp[i][j] = grid[i][j] + Math.max(dp[i - 1][j + 1], dp[i][j + 1]);
                } else {
                    dp[i][j] = grid[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, dp[i][0]);
        }
        System.out.println(max);

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}

//        6
//        6
//        0
//        1
//        4
//        2
//        8
//        2
//        4
//        3
//        6
//        5
//        0
//        4
//        1
//        2
//        4
//        1
//        4
//        6
//        2
//        0
//        7
//        3
//        2
//        2
//        3
//        1
//        5
//        9
//        2
//        4
//        2
//        7
//        0
//        8
//        5
//        1

// OP     32