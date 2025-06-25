package DP;

import java.util.Scanner;

public class MaximumSumNonAdjacent {

    ///    In this problem,
    ///
    ///            1. You are given a number n, representing the count of elements.
    ///            2. You are given n numbers, representing n elements.
    ///            3. You are required to find the maximum sum of a subsequence with no adjacent elements.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int oldInclude = arr[0];
        int oldExclude = 0;

        for (int i = 1; i < n; i++) {
            int newInclude = oldExclude + arr[i];
            int newExclude = Math.max(oldExclude, oldInclude);

            oldInclude = newInclude;
            oldExclude = newExclude;
        }
        System.out.println(Math.max(oldInclude, oldExclude));
    }
}

// key points hum aisa kyu kr rhe h

// 1. adjacent elements nhi lene h to new include purane exclude p hi ho skta h .
// mtlb purana element select nhi kiya to is bar wale ko krlo
// aur exclude p do choices h kre ya na kre include to dono ka max lenge kyuki jiski
// value bdi h present m uski value future m bhi bdi rhegi kyuki dono m choices
//aage same rhegi tree same expand hoga bss present wali value bdi hogi
// nhi smj aayega to recursive tree bna le aur usse variable bhrne ka try kr

//for exp  n = 6 [5,10,10,100,5,6]  ans = 16 iska tree bna aur smj le