package AlgorithmBook.DP;

import java.util.Scanner;

/**
 * DP
 * 最大字段和问题
 */
public class MaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        int res = maxSum(a);
        System.out.println(res);
    }
    private static int maxSum(int[] a) {
        int res = 0;
        int[] b = new int[a.length];
        for (int i = 1; i < b.length; i++) {
            b[i] = Math.max(b[i - 1] + a[i], a[i]);
            res = Math.max(res, b[i]);
        }
        return res;
    }
}
/*
6
-2
11
-4
13
-5
-2
20
*/
