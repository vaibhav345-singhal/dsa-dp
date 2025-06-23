package DP;

import java.util.Scanner;

public class ClimbingStairsWithVariableJumps {
    ///        IP
    ///        13
    ///        5
    ///        5
    ///        2
    ///        4
    ///        1
    ///        5
    ///        9
    ///        8
    ///        6
    ///        3
    ///        8
    ///        9
    ///        1
    ///
    ///        Op
    ///        2044
    ///
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] jumps = new int[n];

        for (int i = 0; i < n; i++) {
            jumps[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        dp[n] = 1; // n se n jane ka 1 path

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= jumps[i] && (i + j < dp.length); j++) {
                dp[i] += dp[i + j];
            }
        }
        System.out.println(dp[0]);
    }
}
