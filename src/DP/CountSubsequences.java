package DP;

import java.util.Scanner;

public class CountSubsequences {
    ///    In this problem,
    ///
    ///    1. You are given a string str.
    ///
    ///    2. You are required to calculate and print the count of subsequences of the nature a+b+c+.
    ///
    ///    For abbc - there are 3 subsequences. abc, abc, abbc
    ///
    ///    For abcabc - there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int a = 0; // count of a+ nature
        int ab = 0; // count of a+b+ nature
        int abc = 0; // count of a+b+c nature

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                // we will use formula --> 2*a + 1
                a = 2 * a + 1;
            } else if (c == 'b') {
                // we will use formula --> 2*ab + a
                ab = 2 * ab + a;
            } else if (c == 'c') {
                // we will use formula --> 2*abc + ab
                abc = 2 * abc + ab;
            }
        }
        System.out.println(abc);
    }
}

// formula generate hua h after doing a dry run like agr hum a+b+ nature count krna chahte
//h to its natural or common sense to add all those jinke last m a h kyuki unke aage b lga k
//hume a+b+ nature mil jayega isliye hum ab or a add kr rhe h formula m ,
// aur iske sath previous agr koi count h ab ka mtlb multiple b h
//string  m to unme new b add hoga ya nhi hoga to usse unke dounble kr dega to isliye
// we are doing 2 * a or 2 * ab or 2*abc

// simple h just do one dry one for abcabc for clarity
// you can take abca'b'c' to differ a,b,c position wise

//dry run picture

//          a     b      c       a'            b'                         c'
//
//a         (a)1  (a)1   (a)1    3(a,aa',a')   3(a,aa',a')                3(a,aa',a')
//
//ab        0     1(ab)  (ab)1   1(ab)         5(ab,abb',ab',aa'b',a'b')  5(ab,abb',ab',aa'b',a'b')
//
//abc       0     0      1(abc)  1(abc)        1(abc)                     7(abc,abcc',abc',abb'c',ab'c',aa'b'c',a'b'c')