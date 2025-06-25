package DP;

import java.util.Scanner;

public class TilingWithM1 {

    ///                In this problem,
    ///
    ///                        1. You are given a number n and a number m separated by line-break representing the length and breadth of a n * m floor.
    ///
    ///                        2. You've an infinite supply of m * 1 tiles.
    ///
    ///                        3. You are required to calculate and print the number of ways floor can be tiled using tiles.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i < m) {
                dp[i] = 1;
            } else if (i == m) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }
        System.out.println(dp[n]);
    }
}
