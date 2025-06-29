package DP;

import java.util.Scanner;

public class FriendsPairing {

    ///    In this problem,
    ///
    ///            1. You are given a number n, representing the number of friends.
    ///
    ///            2. Each friend can stay single or pair up with any of it's friends.
    ///
    ///            3. You are required to print the number of ways in which these friends can stay single or pair up.
    ///
    ///            E.g.
    /// 1 person can stay single or pair up in 1 way.
    ///
    /// 2 people can stay singles or pair up in 2 ways. 12 = 1-2, 12.
    ///
    ///            3 people (123) can stay singles or pair up in 4 ways. 123 = 1-2-3, 12-3, 13-2, 23-1.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {

            //ye hum isliye kr rhe h kyuki hme permutation nhi chahiye
            // kyuki hmne choice sirf phle wale bnde ko di h ki agr 1234 h to
            // 1 akela rhega 234 s answer mangwa lo , 1 pair krega 2 se , 3 se, 4 se
            // lekin aisa bhi to ho skta h ki 2 akela rhe answer mangwa lo 134 s , 3 akela rhe
            // answer mangwa ko 124 s to agr aisa krenge to permutation paida ho jayenge jo hme
            // nhi chahiye

            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        System.out.println(dp[n]);
    }
}
