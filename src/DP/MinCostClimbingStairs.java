package DP;

import java.util.Arrays;
import java.util.Scanner;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }

        int s0 = helperRecursion(0, cost);
        int s1 = helperRecursion(1, cost);

        System.out.println("Recursion ans " + Math.min(s0, s1));

        Integer[] memo = new Integer[n + 1];

        int m1 = memo(1, cost, memo);
        int m0 = memo(0, cost, memo);

        System.out.println("Memoization ans " + Math.min(m0, m1) + " " + Arrays.toString(memo));

        int[] dp = new int[n + 1];

        tabulation(cost, dp, n);
        System.out.println("Tabulation ans " + Math.min(dp[0], dp[1]) + " " + Arrays.toString(dp));
    }

    public static void tabulation(int[] cost, int[] dp, int n) {
        dp[n] = 0;
        dp[n - 1] = cost[n - 1];

        for (int i = n - 2; i >= 0 && i + 2 < dp.length; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
    }

    public static int memo(int s, int[] cost, Integer[] dp) {
        if (s >= cost.length) return 0;
        if (dp[s] != null) {
            return dp[s];
        }

        int oneStep = memo(s + 1, cost, dp);
        int twoStep = memo(s + 2, cost, dp);

        dp[s] = cost[s] + Math.min(oneStep, twoStep);
        return dp[s];
    }

    public static int helperRecursion(int s, int[] cost) {
        if (s == cost.length - 1) return cost[s];
        if (s >= cost.length) return 0;

        int oneStep = helperRecursion(s + 1, cost);
        int twoStep = helperRecursion(s + 2, cost);

        return cost[s] + Math.min(oneStep, twoStep);

    }
}
