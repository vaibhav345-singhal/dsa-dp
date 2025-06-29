package DP;

import java.util.Scanner;

public class BestTimeToBuyAndSellStockWith2Transaction {

    ///    In this problem,
    ///
    ///            1. You are given a number n, representing the number of days.
    ///
    ///            2. You are given n numbers, where ith number represents price of stock on ith day.
    ///
    ///            3. You are required to print the maximum profit you can make if you are allowed two transactions at-most.
    ///
    ///            Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }


    }
}
