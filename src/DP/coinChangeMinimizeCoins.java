package DP;

import java.util.Arrays;
import java.util.Scanner;

public class coinChangeMinimizeCoins {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = s.nextInt();
        }
        int amount = s.nextInt();
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // amount +1 s isliye fill kre as we need something bigger value
        // to compare the min . hum Integer.MAX_VALUE bhi use kr skte h lekin hume phir check lgana pdega
        // kyuki dp[i-coin] agr Integer.MAX_VALUE hua to +1 krke wo minus ho jayega overflow
        // to hum amount +1 kr skte h kyuki count kbhi usse aage nhi jayega kyuki agr 1 ka coin h to
        // hme exactly amount times wo chahiye hoga for example 1 k 11 sikke to calculate 11 to amount+1
        //safely hum use kr skte h
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                // yha num minimize krte ja rhe h ki agr hum ith sum chukana chahte h
                // to hume coin jo loop m chl rha h usko use krke kitne coin s chukana pdega
                // aur agr wo count km h phle wale s to usko update kr denge
                // dp[i] = phle kitne coin s chuka rhe
                // dp[i-coin] +1 ab kitne coins s chuka skte agr new min h to update krdo
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        int ans = dp[amount] > amount ? -1 : dp[amount];
        System.out.println(ans);
    }
}
//  IP
//        4
//        186
//        419
//        83
//        408
//        6249
//OP
//        20