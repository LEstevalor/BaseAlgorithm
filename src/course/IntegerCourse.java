package course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerCourse {
    public static void main(String[] args) {
        int[] arr = {1, 6, 5, 34, 9, 32};
        poSort(arr);                               // 优化冒泡
        System.out.println("优化冒泡：" +Arrays.toString(arr));  // [1, 5, 6, 9, 32, 34]
        System.out.println("指数函数的二分：" + quickA(16, 5));   // 1048576（指数函数的二分——快速幂处理（未做取余操作））

        // 求数分裂和的问题
        System.out.println("求数分裂和的问题↓↓");
        System.out.println("两个参数 递归：" + q(6, 6));        // 两个参数 递归
        System.out.println("动态规划：" + dp(6));              // 动态规划
        System.out.println("动态规划 + 显示：" + dp_plus(6));         // 动态规划 + 显示
    }

    // q(n,n) = q(n,n-1) + 1
    // q(n,1) = 1
    // q(n,m) = q(n,n)  m >= n
    // q(n,m) = q(n,m-1) + q(n-m,m) n>m>1

    /**
     * 递归
     */
    public static int q(int n, int m) {
        if (m == 1) {
            return 1;                             // q(n,1) = 1
        }
        if (m == n) {
            return q(n, n - 1) + 1;           // q(n,n) = q(n,n-1) + 1
        }
        if (m > n) {  // 写入m=n就死循环了
            return q(n, n);                       // q(n,m) = q(n,n)  m >= n
        }
        // 剩下1 < m < n的情况
        return q(n, m - 1) + q(n - m, m);  // q(n,m) = q(n,m-1) + q(n-m,m) n>m>1
    }

    /**
     * DP
     * @param n 原数
     * @return 结果在f[n][n]
     */
    public static int dp(int n) {
        int[][] f = new int[n + 1][n + 1];
        // 从上往下，从左往右遍历
        for (int i = 1; i <= n; i++) {
            f[i][1] = 1;                              // m = 1, q(n,1) = 1
            for (int j = 2; j < i; j++) {
                int n_m_index = Math.min(j, i - j);           // q(n,m) = q(n,n)  m >= n被包含处理(注意i>j恒成立)
                f[i][j] = f[i][j - 1] + f[i - j][n_m_index];  // q(n,m) = q(n,m-1) + q(n-m,m) n>m>1
            }
            f[i][i] = f[i][i - 1] + 1;                // q(n,n) = q(n,n-1) + 1
        }
        // printTwo(f);  // 打印测试
        return f[n][n];  // f(6)(6)
    }

    // 显示，存一个字符串列表 需两个（字符串列表类型）二维矩阵str[][]  （数值类型）二维矩阵f[][]
    public static int dp_plus(int n) {
        int[][] f = new int[n + 1][n + 1];
        List[][] lists = new List[n + 1][n + 1];

        // 从上往下，从左往右遍历
        for (int i = 1; i <= n; i++) {
            f[i][1] = 1;                              // m = 1, q(n,1) = 1
            if (i > 1) {
                lists[i][1] = new ArrayList<String>();
                lists[i][1].add(lists[i-1][1].get(0) + "+1"); // 处理第一列+1的问题
            }
            for (int j = 2; j < i; j++) {                     // q(n,m) = q(n,m-1) + q(n-m,m) n>m>1
                lists[i][j] = new ArrayList<String>();
                int n_m_index = Math.min(j, i - j);           // q(n,m) = q(n,n)  m >= n被包含处理(注意i>j恒成立)
                f[i][j] = f[i][j - 1] + f[i - j][n_m_index];
                while(n_m_index > 0) {
                    for (Object str : lists[i-j][n_m_index]) {
                        lists[i][j].add(j + "+" + str);       // j + 对应各列表的字符串，比如q(6,4)时，4 + q(2,2)的那一列即4+2 4+1+1
                    }                                         // 因为是从前向后递归，所以lists[2][2]={"2"} lists[2][1]={"1+1"}均已存好
                    n_m_index--;
                }
            }
            f[i][i] = f[i][i - 1] + 1;                // q(n,n) = q(n,n-1) + 1
            lists[i][i] = new ArrayList<String>();
            lists[i][i].add(i + "");                  // 对角线元素直接存i
        }

        System.out.println("显示n的：");
        for (int i = n; i >= 1; i--) {
            for (Object str : lists[n][i]) {
                System.out.printf("%s\t", str);
            }
            System.out.println();
        }

        System.out.println("显示所有：");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                for (Object str : lists[i][j]) {
                    System.out.printf("%-15s", str);
                }
            }
            System.out.println();
        }

        return f[n][n];  // f(6)(6)
    }

    /**
     * 打印整型二维数组
     * @param f 整型二维数组
     */
    public static void printTwo(int[][] f) {
        if (f.length == 0) {
            return;
        }
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[0].length; j++) {
                System.out.printf("%d\t", f[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 冒泡（优化完的）
     * @param arr 原数组
     */
    public static void poSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean bo = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    bo = true;
                }
            }
            if (!bo) {
                break;
            }
        }
    }

    /**
     * a^n用二分（快速幂的处理方式）
     * @param a 底数
     * @param n 指数（要求为自然数）
     * @return
     */
    public static int quickA(int a, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return a;
        }
        if (n % 2 != 0) {
            return quickA(a, n - 1) * a;  // quickA(a, n/2) * quickA(a, n/2) * a
        }
        return quickA(a, n / 2) * quickA(a, n / 2);
    }

}
