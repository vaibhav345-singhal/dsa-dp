package DP;

import java.util.Scanner;

public class ArrangeBuildings {

    /// In this problem
    /// 1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
    /// 2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
    /// 3. You are required to find and print the number of ways in which the buildings can be built on both side of roads.
    ///
    /// This problem is similar to no consecutive 1s allowed for each side means
    /// solve for one side using same method and do the multiplication with that no
    /// to get the answer for both side .
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        long ob = 1;
        long os = 1;

        for (int i = 2; i <= n; i++) {
            long nb = os;
            long ns = ob + os;

            ob = nb;
            os = ns;
        }
        long total = ob + os;
        long ans = total * total;
        System.out.println(ans);
    }
}
