package DP;

import java.util.Scanner;

public class BestTimeToBuyAndSellStockII {

///    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = s.nextInt();
        }

        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int buyPoint = Integer.MAX_VALUE;
        int sellPoint = Integer.MIN_VALUE;
        int profitOverall = 0;

        for (int i = 0; i < n; i++) {
            // buy , sell ko update kr rhe kyuki buy s phle sell nhi hoga
            if (prices[i] < buyPoint) {
                buyPoint = prices[i];
                sellPoint = prices[i];
            }

            // sell ko aage bdate ja rhe jb tk dip na aajye kyuki tbhi max profit hoga
            while (i < n && prices[i] >= sellPoint) {
                sellPoint = prices[i];
                i++;
            }

            profitOverall += sellPoint - buyPoint;

            // profit calculate krne k baad dono ko update kr rhe kyuki
            // buy -> sell , buy -> sell allowed h . aisa nhi kr skte ki
            // buy -> buy -> sell -> sell or sell -> buy
            if (i < n) {
                buyPoint = prices[i];
                sellPoint = prices[i];
            }
        }
        return profitOverall;
    }
}
