package DP;

import java.util.Scanner;

public class CountEncodings {

    ///    In this problem,
    ///    1. You are given a string str of digits. (will never start with a 0)
    ///    2. You are required to encode the str as per following rules
    ///
    ///    1 - a
    ///    2 - b
    ///    3 - c
    ///    .......
    ///    25 - y
    ///    26 - z
    ///
    ///    3. You are required to calculate and print the count of encodings for the string str.
    ///    For 123 - there are 3 encodings. abc, aw, lc
    ///    For 993 - there is 1 encoding. iic
    ///    For 013 - This is an invalid input. A string starting with 0 will not be passed.
    ///    For 103 - there is 1 encoding. jc
    ///   For 303 - there are 0 encodings. But such a string maybe passed. In this case
    ///    print 0.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();

        if (s.charAt(0) == '0') return;

        int[] dp = new int[n];
        dp[0] = 1;

        // is solution m multiple edge cases h like
        // 1 . agr last dono char 0 0 ho
        // 2 . ek 0 ek non zero ho like nonzero - 0 or 0 - nonzero
        // 3. dono non zero ho
        // 4. string start hi 0 s ho rhi ho
        // 5 . aur jb i-2 kr rhe h to out of bound na ho

        // upr wali sari cheeze dhyaan rkhni h

        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) == '0' && s.charAt(i) == '0') {
                dp[i] = 0;
            } else if (s.charAt(i - 1) == '0' && s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            } else if (s.charAt(i - 1) != '0' && s.charAt(i) == '0') {
                if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                    dp[i] = i >= 2 ? dp[i - 2] : 1;
                } else {
                    dp[i] = 0;
                }
            } else {
                if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        System.out.println(dp[n - 1]);
    }
}
