package DP;

import java.util.Scanner;

public class PaintHouses {

    ///    In this problem,
    ///
    ///            1. You are given a number n, representing the number of houses.
    ///
    ///       2. In the next n rows, you are given 3 space separated numbers representing the cost of painting nth house with red or blue or green color.
    ///
    ///   3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
    public static void main(String[] args) {
        // somewhat similar to maximum sum non-adjacent type
        // at any given point of index wo represent krta h ki agr hum choose krte h wo color
        // lagan to kitna min hum generate kr skte h
        //mtlb humne maan lete h red lagaya index 1,0 pr to cost of that red color for house
        // usme add krenge previous 0,1 and 0,2 ka minimum kyuki hum red choose nhi kr skte dobara
        // as adjacent color same nnhi hona chahiye
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[][] colorsCost = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                colorsCost[i][j] = s.nextInt();
            }
        }

        int[][] dp = new int[n][3];
        dp[0][0] = colorsCost[0][0];
        dp[0][1] = colorsCost[0][1];
        dp[0][2] = colorsCost[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = colorsCost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = colorsCost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = colorsCost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        int ans = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        System.out.println(ans);
    }
}

// n = 3
// 1 1 1 --> r
// 2 2 2 --> g
// 3 3 3 --> b

//dp

//1                    2                      3
//(1 + min(2,3)=> 3)   (2 + min(1,3)=> 3)     (3 + min(1,2)=> 4)
//(1 + min(3,4) => 4)  (2 + min(3,4) => 5)    (3 + min(3,3) => 6)


// ans is min of last  row  min(4 , 5 ,6 )