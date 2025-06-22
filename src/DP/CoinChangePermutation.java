package DP;

import java.util.Scanner;

public class CoinChangePermutation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = s.nextInt();
        }
        int amount = s.nextInt();

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        /*
        this will generate permutations kyuki hum ek sath sare coins check kr rhe h
        at a given time for all i's
        agr dhyan s dekho to for every dp[i] we are checking out every coins[j] together not like combinations
        bss yhi change h combinations s
        */
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= coins[j]) {
                    dp[i] += dp[i - coins[j]];
                }
            }
        }
        System.out.println(dp[amount]);
    }
}
