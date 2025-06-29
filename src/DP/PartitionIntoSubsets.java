package DP;

import java.util.Scanner;

public class PartitionIntoSubsets {

    ///    In this problem,
    ///
    ///            1. You are given a number n, representing the number of elements.
    ///
    ///            2. You are given a number k, representing the number of subsets.
    ///
    ///            3. You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets.
    ///    E.g.
    ///            For n = 4 and k = 3 total ways is 6
    ///
    ///            12-3-4
    ///
    ///            1-23-4
    ///
    ///            13-2-4
    ///
    ///            14-2-3
    ///
    ///            1-24-3
    ///
    ///            1-2-34

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int people = s.nextInt();
        int teams = s.nextInt();

        if (teams == 0 || people == 0 || people < teams) {
            System.out.println(0);
            return;
        }

        long[][] dp = new long[teams + 1][people + 1];


        for (int t = 1; t <= teams; t++) {
            for (int p = 1; p <= people; p++) {
                if (p < t) {
                    dp[t][p] = 0;
                } else if (t == p) {
                    dp[t][p] = 1;
                } else {
                    dp[t][p] = dp[t - 1][p - 1] + t * dp[t][p - 1];
                }
            }
        }
        System.out.println(dp[teams][people]);
    }
}
