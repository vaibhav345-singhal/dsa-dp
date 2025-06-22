package DP;

import java.util.Arrays;
import java.util.Scanner;

public class ClimbingStairsWithVariableMinJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] jumps = new int[n];

        for (int i = 0; i < n; i++) {
            jumps[i] = sc.nextInt();
        }

        Integer[] dp = new Integer[n + 1];
        dp[n] = 0; // n se n jane ka path 1 pr moves lge jane m 0 weird right just remember !!

        for (int i = n - 1; i >= 0; i--) {
            int curr = Integer.MAX_VALUE;
            for (int j = 0; j <= jumps[i] && i + j < dp.length; j++) {
                curr = Math.min(curr, dp[i + j] == null ? Integer.MAX_VALUE : dp[i + j]);
            }
            dp[i] = curr == Integer.MAX_VALUE ? null : curr + 1;
        }
        System.out.println(dp[0]);
        System.out.println(Arrays.toString(dp));
    }
}

// IP

//        10
//        1
//        1
//        1
//        4
//        9
//        8
//        1
//        1
//        10
//        1

//OP      5