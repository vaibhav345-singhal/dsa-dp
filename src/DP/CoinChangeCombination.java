package DP;

import java.util.Scanner;

public class CoinChangeCombination {

     /// count all combinations not permutations to generate amount
     /// means for 2 3 4 coins array ans is 2 {(2,2,3),(2,5)}
     /// permutations can be 223 , 322, 232, 25,52 like that
     /// supply is infinite of coins

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = s.nextInt();
        }
        int amount = s.nextInt();

        /*
         in this dp we will fill kitne trike h ith value ko pay krne k
         like kitne trike s dp[0] pay kr skte h using each coin
        */
        int[] dp = new int[amount + 1];
        dp[0] = 1; // kyuki 0 val pay krne ka ek trika h ki kuch na pay kro

        for (int i = 0; i < coins.length; i++) {
            /*
             each coin s pay krne k trike to outside loop will be coins loop
             like for 1st coin than 2nd coin , ye permutaion hone s rok lega kyuki hum ek k baad ek s payment
             kr rhe h like phle 2 phir 3 phir 5
             agr hum ek bar m aisa kr denge ki 2 se krdi sath m 3 s bhi krdi 5 s bhi krdi to permutation
             paida ho jayega;
            */
            for (int j = coins[i]; j < dp.length; j++) {

                /*
                    andr wala loop run krega like j value ko pay krne k
                    kitne trike h using coins[i];

                    j loop coins[i] s start hoga kyuki chhoti value ko bda coin use krke pay nhi kr skte
                    like 3 val ko 4 ya 5 ya 6 k coin s pay nhi kra ja skta h;
                */

                dp[j] += dp[j - coins[i]];

                /*
                 for example to pay 6 using coin 2 ways are dp[6 - 2]
                 kyuki 2 pay krne k baad 4 pay krna hoga aur agr 4 pay krne k trike h to add kr denge
                agr nhi h to kaise pay krenge nhi kr skte 0 add ho jayega
                */
            }
        }
        System.out.println(dp[amount]);
    }
}
//ip [2 ,3 ,5] amount = 7;
//op 2