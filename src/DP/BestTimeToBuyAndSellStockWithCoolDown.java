package DP;

import java.util.Scanner;

public class BestTimeToBuyAndSellStockWithCoolDown {

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

        //bst --> buy state profit
        //sst --> sold state profit
        //cst --> cooldown state profit

        int bst = -prices[0];
        int sst = 0;
        int cst = 0;

        for (int i = 1; i < n; i++) {
            int nbst = 0;
            int nsst = 0;
            int ncst = 0;

            if (cst - prices[i] > bst) {
                nbst = cst - prices[i];
            } else {
                nbst = bst;
            }

            if (bst + prices[i] > sst) {
                nsst = bst + prices[i];
            } else {
                nsst = sst;
            }

            if (sst > cst) {
                ncst = sst;
            } else {
                ncst = cst;
            }

            bst = nbst;
            sst = nsst;
            cst = ncst;
        }

        return sst;
    }
}
