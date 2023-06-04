package course;

import java.util.stream.IntStream;

public class GraphZip {
    public static void main(String[] args) {
        System.out.println("图像压缩算法");
        int p[] = {1, 2, 3, 4};
        caculGraphZip(p);  // 1+2+3+4 3*4+11=23

        System.out.println("\n按自然数序列的最小分组最大字段合");
        caculNaturalSpeSum(4, 2);

        System.out.println("\n按随机序列的最小分组最大字段合");
        caculSpeSum(p, 2);
    }

    // 打印一维矩阵
    private static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%4d", arr[i]);
        }
        System.out.println();
    }

    /**
     * 图像压缩算法输入
     * @param p 像素点值数组
     */
    private static void caculGraphZip(int[] p) {
        int l[] = new int[p.length + 1];
        int b[] = new int[p.length + 1];
        System.out.println("结果：" + compress(p.length, p, l, b));
        System.out.print("数组l：");
        printArr(l);
        System.out.print("数组b：");
        printArr(b);
    }

    /**
     * 压缩图像算法
     * @param n 像素点数
     * @param p 对应的n个像素点值
       s m个像素段（1 <= m <= n）对应最优压缩结果
     * @param l 像素段下包含的像素点数
     * @param b 像素段下记录最长的像素点二进制位数，并对数化（底数为2）处理以得二进制高位
     * @return 返回s[n]压缩结果，DP最终累计值
     */
    private static int compress(int n, int p[], int l[], int b[]) {
        // 0索引位无意义，仅用于迭代，DP中往往对应实际逻辑意义，Java中默认int数组为0
        int s[] = new int[n + 1];
        int bitMax = 256;
        // 头信息长 b + l
        int header = 11;

        // 从低位向高位迭代，
        for (int i = 1; i <= n; i++) {
            // 会被最小的代替（int位上限值）
            s[i] = Integer.MAX_VALUE;
            b[i] = (int) (Math.log(p[i - 1]) / Math.log(2)) + 1;
            int bmax = b[i];

            // 一个分段最少一个像素
            l[i] = 1;

            for (int j = 1; j <= bitMax && j <= i; j++) {
                bmax = Math.max(bmax, b[i - j]);
                int curS = s[i - j] + j * bmax;
                if (s[i] > curS) {
                    s[i] = curS;
                    l[i] = j;
                }
            }

            // 每个优化分段必须带一个头信息长
            s[i] += header;
        }
        System.out.print("数组s：");
        printArr(s);
        return s[n];
    }

    /**
     * 按自然数序列的最小分组最大字段合
     * @param n 为1到n的正整数
     * @param m m段
     */
    private static void caculNaturalSpeSum(int n, int m) {
        int sum = (n + 1) * n / 2 / m;
        int result = 0;
        int curSum = 0;
        int k = 1;
        for (int i = 1; i <= n; i++) {
            curSum += i;
            System.out.printf("%4d", i);
            if (curSum >= sum || i == n) {
                result = Math.max(result, curSum);
                curSum = 0;
                System.out.printf(" 第%d段\n", k++);
            }
        }

        System.out.println("结果：" + result);
    }

    /**
     * 按随机序列的最小分组最大字段合
     * @param arr 随机数组
     * @param m m段
     */
    private static void caculSpeSum(int[] arr, int m) {
        int n = arr.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            // 初始化
            dp[i][1] = dp[i - 1][1] + arr[i - 1];

            for (int j = 2; j <= m; j++) {
                int minValue = Integer.MAX_VALUE;
                for (int k = 1; k <= i; k++) {
                    // arr[1-k]最优与arr[k+1]~arr[i]分段
                    int curValue = Math.max(dp[k][j - 1], dp[i][1] - dp[k][1]);
                    minValue = Math.min(minValue, curValue);
                }
                dp[i][j] = minValue;
            }
        }

        System.out.println("结果：" + dp[n][m]);
    }
}
