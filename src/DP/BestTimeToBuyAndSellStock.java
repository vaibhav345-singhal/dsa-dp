package DP;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock {

    ///    In this problem,
    ///
    ///            1. You are given a number n, representing the number of days.
    ///
    ///            2. You are given n numbers, where ith number represents price of stock on ith day.
    ///
    ///            3. You are required to print the maximum profit you can make if you are allowed a single transaction.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = s.nextInt();
        }

        int minSoFar = Integer.MAX_VALUE;
        int overallProfit = 0;
        int profitIfSoldToday = 0;

        for (int i = 0; i < n; i++) {
            if (prices[i] < minSoFar) {
                minSoFar = prices[i];
            }

            profitIfSoldToday = prices[i] - minSoFar;

            if (profitIfSoldToday > overallProfit) {
                overallProfit = profitIfSoldToday;
            }
        }
        System.out.println(overallProfit);
    }
}
