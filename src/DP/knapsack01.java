package DP;

import java.util.Scanner;

public class knapsack01 {
    /**
     * main point h ek val ek bar hi use kr skte h multiple bar ni like coin change ,
     * its like target sum subset
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] val = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            weight[i] = s.nextInt();
        }
        int capacity = s.nextInt();

        // similar h almost target sum subset ki trh . hmare pas single choice h to choose each element
        // so hum 2d array dp bna rhe h row represents val and weight and
        // column represents capacity we need to miximize
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // agr j bda h current weight s to use allowed h using i-1 kyoki
                // i-1 corresponds to actual index of val and weight
                if (j >= weight[i - 1]) {
                    // agr current val aur uske bad bche weight p pichle result ko add krke
                    // bina val use kiye agr previous result bda nhi h to val[i - 1] + dp[i - 1][j - weight[i - 1]]
                    // use krenge aur agr chhota h to dp[i - 1][j] use krenge
                    if (val[i - 1] + dp[i - 1][j - weight[i - 1]] > dp[i - 1][j]) {
                        dp[i][j] = val[i - 1] + dp[i - 1][j - weight[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][capacity]);
    }
}
//IP
//        5
//        15
//        14
//        10
//        45
//        30
//        2
//        5
//        1
//        3
//        4
//        7

//OP
//        75
