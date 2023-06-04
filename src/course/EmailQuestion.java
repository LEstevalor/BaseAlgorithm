package course;

import java.util.Arrays;
import java.util.Scanner;

public class EmailQuestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入n, m：");
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.print("\n输入n的面值：");
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        // 确保x数组从小到大，假设数组x中无重复值
        Arrays.sort(x);

        if (n == 0 || m == 0 || x[0] != 1) {
            System.out.print("\n结果区间不存在");
        } else {
            prepare(n, m, x);
        }

    }

    private static void prepare(int n, int m, int[] x) {
        int maxSize = 1000;
        int[] y = new int[maxSize];  // 邮资所需最少的邮票数
        for (int i = 1; i < maxSize; i++) {
            y[i] = i <= m ? i : Integer.MAX_VALUE;  // x[0] = 1
        }
        int r = m;

        System.out.println(getEmailArea(n, m, x, r, y));
    }

    private static int getEmailArea(int n, int m, int[] x, int r, int[] y) {

        for (int i = 1; i < n; i++) {  // x[0]就不必要使用了

            if (x[i] == x[i - 1]) {  // 同面值无遍历意义
                continue;
            }
            if (x[i] > r + 1) {  // 必定间断点r+1
                break;
            }

            // 遍历x[i] ~ x[i] * m，y记录最小的邮票数
            for (int j = x[i]; j <= x[i] * m; j++) {
                // 最多m个当前邮票
                for (int t = 1; t <= m; t++) {
                    if (j - t * x[i] >= 0) {
                        y[j] = Math.min(y[j], t + y[j - t * x[i]]);
                    }
                }
            }

            int minj = x[i] * m;
            // 取最小间断点，并更新区间最大值为该最小间断点前的那一个值
            for (int j = x[i]; j < x[i] * m; j++) {
                if (y[j] <= m && y[j + 1] > m) {
                    minj = Math.min(j, minj);
                }
            }
            r = minj;
        }

        return r;
    }
}
