package AlgorithmBook.DP;

import java.util.Scanner;

/**
 * DP
 * 最长公共子序列问题
 */
public class LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        int res = longestCommonSubsequence(str1, str2);
        System.out.println(res);

        String res_str = longestCommonSubsequencePlus(str1, str2);
        System.out.println(res_str);
    }
    // 返回最长子序列长度
    public static int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
    // 返回最长子序列
    public static String longestCommonSubsequencePlus(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        StringBuilder[][] dps = new StringBuilder[n1 + 1][n2 + 1];  // 单线程StringBuilder比String拼接和修改操作速度快得多
        for (int i = 0; i <= n1; i++) {
            dps[i][0] = new StringBuilder();
        }
        for (int j = 1; j <= n2; j++) {
            dps[0][j] = new StringBuilder();
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dps[i][j] = new StringBuilder(dps[i - 1][j - 1]);
                    dps[i][j].append(text1.charAt(i - 1));
                } else {
                    if (dps[i - 1][j].length() > dps[i][j - 1].length()) {
                        dps[i][j] = new StringBuilder(dps[i - 1][j]);
                    }  else {
                        dps[i][j] = new StringBuilder(dps[i][j - 1]);
                    }
                }
            }
        }
        return dps[n1][n2].toString();
    }
}

/*
ABCBDAB
BDCABA
4
BDAB
*/
