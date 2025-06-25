package DP;

import java.util.Scanner;

public class TilingWith21 {

    ///    In this problem,
    ///
    ///           1. You are given a number n representing the length of a floor space which is 2m wide. It's a 2 * n board.
    ///
    ///            2. You've an infinite supply of 2 * 1 tiles.
    ///
    ///            3. You are required to calculate and print the number of ways floor can be tiled using tiles.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }
}
