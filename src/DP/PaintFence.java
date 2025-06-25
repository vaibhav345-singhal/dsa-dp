package DP;

import java.util.Scanner;

public class PaintFence {

    ///    In this question,
    ///
    ///           1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
    ///
    /// 2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two fences have same colors.

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();

        // ways of 2nd fence
        int same = k * 1;
        int diff = k * (k - 1);
        int total = same + diff;

        // start krenge 3rd fence s kyuki 1 fence ka kuch answer nhi h
        // 2nd fence ka answer hmne already dal diya h
        // to from 3rd to n
        for (int i = 3; i <= n; i++) {
            same = diff * 1;
            diff = total * (k - 1);
            total = same + diff;

        }

        System.out.println(total);
    }
}
