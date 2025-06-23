package DP;

import java.util.Scanner;

public class NotConsecutive1sAllowed {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(countString(n));
        System.out.println(countString2(n));
    }

    private static int countString(int n) {
        // we can take two arrays ek binary strings jo 0 p khtm ho rhe unke liye
        // aur ek wo jo 1 p khtm ho rhe unke liye
        // aur agr dhyan s dekhe to array lene ki jrurt hi nhi kyuki hme sirf previous
        // value chahiye jo hum variable s track kr skte h
        //agle method m dekho
        int[] dp0 = new int[n + 1];
        int[] dp1 = new int[n + 1];

        dp0[1] = 1;
        dp1[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp0[i] = dp0[i - 1] + dp1[i - 1];
            dp1[i] = dp0[i - 1];
        }
        return dp0[n] + dp1[n];
    }

    private static int countString2(int n) {
        int oldconsecutivesones = 1;
        int oldconsecutiveszeros = 1;

        for (int i = 2; i <= n; i++) {
            int newconsecutiveszeros = oldconsecutivesones + oldconsecutiveszeros;
            int newconsecutivesones = oldconsecutiveszeros;

            oldconsecutivesones = newconsecutivesones;
            oldconsecutiveszeros = newconsecutiveszeros;
        }
        return oldconsecutiveszeros + oldconsecutivesones;
    }

}
