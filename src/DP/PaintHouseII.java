package DP;

import java.util.Arrays;
import java.util.Scanner;

public class PaintHouseII {
    ///                In this problem,
    ///
    ///                        1. You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
    ///
    ///                        2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
    ///
    ///                        3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();

        int[][] cost = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                cost[i][j] = s.nextInt();
            }
        }

        n3Solution(k, n, cost);
        n2Solution(n, k, cost);
    }

    private static void n2Solution(int n, int k, int[][] cost) {
        int[][] dp = new int[n][k];
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            dp[0][i] = cost[0][i];

            if (dp[0][i] <= least) {
                sleast = least;
                least = dp[0][i];
            } else if (dp[0][i] <= sleast) {
                sleast = dp[0][i];
            }
        }

        for (int i = 1; i < n; i++) {
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {

                if (least != dp[i - 1][j]) {
                    dp[i][j] = least + cost[i][j];
                } else {
                    dp[i][j] = sleast + cost[i][j];
                }


                if (dp[i][j] <= nleast) {
                    nsleast = nleast;
                    nleast = dp[i][j];
                } else if (dp[i][j] <= nsleast) {
                    nsleast = dp[i][j];
                }
            }
            least = nleast;
            sleast = nsleast;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println(least);
    }

    private static void n3Solution(int k, int n, int[][] cost) {
        int[][] dp = new int[n][k];
        for (int i = 0; i < k; i++) {
            dp[0][i] = cost[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;

                for (int l = 0; l < k; l++) {
                    if (l != j) {
                        min = Math.min(min, dp[i - 1][l]);
                    }
                }
                dp[i][j] = cost[i][j] + min;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(ans);
    }
}

// IP
//        4
//        3
//        1
//        5
//        7
//        5
//        8
//        4
//        3
//        2
//        9
//        1
//        2
//        4

// OP     8