package DP;

import java.util.Scanner;

public class GenerateTargetSumSubSets {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int target = s.nextInt();

        generateSubSets(arr, 0, "");

        System.out.println("for recursion start " + System.currentTimeMillis());
        System.out.println(targetSumSubSetPresentOrNot(arr, 0, 0, target));
        System.out.println("for recursion end " + System.currentTimeMillis());

        // solution for target sum subsets using dp

        boolean[][] dp = new boolean[n + 1][target + 1];

        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    if (dp[i - 1][j]) {
                        dp[i][j] = true;
                    } else {
                        int currentArrVal = arr[i - 1];
                        if (j >= currentArrVal) {
                            int remainingSum = j - currentArrVal;
                            if (dp[i - 1][remainingSum]) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[arr.length][target]);
        System.out.println(System.currentTimeMillis());
    }

    private static boolean targetSumSubSetPresentOrNot(int[] arr, int i, int curr, int target) {
        if (i >= arr.length) {
            return target == curr;
        }

        return targetSumSubSetPresentOrNot(arr, i + 1, curr + arr[i], target) ||
                targetSumSubSetPresentOrNot(arr, i + 1, curr, target);
    }

    private static void generateSubSets(int[] arr, int i, String s) {
        if (i >= arr.length) {
            System.out.println(s);
            return;
        }

        generateSubSets(arr, i + 1, s + arr[i]);
        generateSubSets(arr, i + 1, s);
    }
}
