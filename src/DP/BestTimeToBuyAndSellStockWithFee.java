package DP;

import java.util.Scanner;

public class BestTimeToBuyAndSellStockWithFee {

    ///    In this problem,
    ///
    ///            1. You are given a number n, representing the number of days.
    ///
    ///            2. You are given n numbers, where ith number represents price of stock on ith day.
    ///
    ///            3. You are required to print the maximum profit you can make if you are allowed infinite transactions.
    ///
    ///            Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = s.nextInt();
        }

        int transactionFee = s.nextInt();

        int buyStateProfit = -prices[0];
        int sellStateProfit = 0;

        for (int i = 1; i < n; i++) {

            System.out.println("Buy state " + buyStateProfit);
            System.out.println("Sell state " + sellStateProfit);

            int newBuyStateProfit = 0;
            int newSellStateProfit = 0;

            if (buyStateProfit + prices[i] - transactionFee > sellStateProfit) {
                newSellStateProfit = buyStateProfit + prices[i] - transactionFee;
            } else {
                newSellStateProfit = sellStateProfit;
            }

            if (sellStateProfit - prices[i] > buyStateProfit) {
                newBuyStateProfit = sellStateProfit - prices[i];
            } else {
                newBuyStateProfit = buyStateProfit;
            }


            buyStateProfit = newBuyStateProfit;
            sellStateProfit = newSellStateProfit;
        }

        System.out.println(sellStateProfit);
    }
}
