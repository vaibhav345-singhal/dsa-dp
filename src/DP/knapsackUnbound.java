package DP;

import java.util.Arrays;
import java.util.Scanner;

public class knapsackUnbound {

    /// here we have multiple choices like we can take one item multiple times

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = s.nextInt();
        }
        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = s.nextInt();
        }
        int capacity = s.nextInt();

        int[] dp = new int[capacity + 1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (wt[j] <= i) {
                    int bagval = val[j];
                    int rcap = i - wt[j];
                    if (dp[rcap] + bagval > max) {
                        max = dp[rcap] + bagval;
                    }
                }
            }
            dp[i] = max;
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[capacity]);
    }
}
