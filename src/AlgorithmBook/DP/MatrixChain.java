package AlgorithmBook.DP;

import java.util.Scanner;

/**
 * DP
 * 矩阵相乘问题
 */
public class MatrixChain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入矩阵个数：");
        int n = sc.nextInt();
        int[][] as = new int[n][2];
        for (int i = 0; i < n; i++) {
            as[i][0] = sc.nextInt();
            as[i][1] = sc.nextInt();
        }
        int res = matrixChain(as);
        System.out.printf("矩阵结果：%d\n", res);
    }
    private static int matrixChain(int[][] as) {
        int n = as.length;
        // DP含义：矩阵AI*...*AJ的I-J计算次数
        int[][] dp = new int[n][n];
        // 斜对接向上遍历
        int j = 1;
        while (j < n) {
            int i = 0;
            for (int jj = j; jj < n; jj++, i++) {
                dp[i][jj] = Integer.MAX_VALUE;
//                dp[i][jj] = Math.min(dp[i][jj - 1] + as[i][0] * as[jj - 1][1] * as[jj][1],
//                        dp[i + 1][jj] + as[i][0] * as[i + 1][0] * as[jj][1]);  // 并不是按左和下推，而是连续的f推的
                for (int ii = i; ii < jj; ii++) {   // 比如 f(BCDE) = f(B) f(CDE), f(BC) f(DE), f(BCD) f(E)
                    dp[i][jj] = Math.min(dp[i][jj], dp[i][ii] + dp[ii + 1][jj] + as[i][0] * as[ii][1] * as[jj][1]);
                }
            }
            j++;
        }
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                System.out.printf("%6d", dp[i][k]);
            }
            System.out.println();
        }

        return dp[0][n - 1];
    }
}
/*
请输入矩阵个数：6
30 35
35 15
15 5
5 10
10 20
20 25
     0 15750  7875  9375 11875 15125
     0     0  2625  4375  7125 10500
     0     0     0   750  2500  5375
     0     0     0     0  1000  3500
     0     0     0     0     0  5000
     0     0     0     0     0     0
矩阵结果：15125
 */