package DP;

import java.util.Random;
import java.util.Arrays;
import java.util.Comparator;

public class packet01 {
    public static void main(String[] args) {

    }

    /**
     * 动态规划解决0-1背包
     * @param capacity 背包容量
     * @param w 物体重量
     * @param v 物体体积
     * @return 容量capacity下背包装入物品最优解
     */git
    public static int dp(int capacity, int[] w, int[] v) {
        // 物品数
        int n = w.length;
        // dp[i][j]中i代表第几个背包（显然这里i=0无意义），j代表当前重量
        int[][] dp = new int[n + 1][capacity + 1];

        // 遍历，从前往后、从左到右
        // 外层：遍历n个物品
        for (int i = 1; i <= n; i++) {
            // 内层：遍历容量至capacity
            for (int j = 1; j <= capacity; j++) {
                if (j >= w[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacity];
    }

    /**
     * 空间优化后的动态规划解决0-1背包
     * @param capacity 背包容量
     * @param w 物体重量
     * @param v 物体体积
     * @return 容量capacity下背包装入物品最优解
     */
    public static int dp_v(int capacity, int[] w, int[] v) {
        int n = w.length;
        // dp[i][j]中i代表第几个背包（显然这里i=0无意义），j代表当前重量
        int[] dp = new int[capacity + 1];

        // 遍历，从前往后、从左到右
        // 外层：遍历n个物品
        for (int i = 1; i <= n; i++) {
            // 内层：遍历容量至capacity
            for (int j = capacity; j >= 1; j--) {
                if (j >= w[i - 1]) {
                    dp[j] = Math.max(dp[j], dp[j - w[i - 1]] + v[i - 1]);
                }
            }
        }

        return dp[capacity];
    }

    /**
     * 贪心算法解决0-1背包
     * @param capacity 背包容量
     * @param w 物体重量
     * @param v 物体体积
     * @return 容量capacity下背包装入物品的贪心解
     */
    public static int greedy(int capacity, int[] w, int[] v) {
        // 以价值向量v为依据排序，w随之索引位移动
        // 先创建一个索引数值
        Integer[] indexs = new Integer[v.length];
        for (int i = 0; i < indexs.length; i++) {
            indexs[i] = i;
        }
        // 然后按以v为依据，对应索引数组变动
        Arrays.sort(indexs, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(v[o2], v[o1]);  // 顺序比v[o1], v[o2]是从小到大，我们这里贪心要从大到小
            }
        });

        int result = 0;  // 记录结果
        for (Integer index : indexs) {
            if (capacity >= w[index]) {
                capacity -= w[index];
                result += v[index];
            }
        }

        return result;
    }

    /**
     * 回溯法解决0-1背包
     * @param capacity 背包容量
     * @param w 物体重量
     * @param v 物体体积
     * @param index 当前索引
     * @param result 上一个索引传递过来的结果值
     * @return 容量capacity下被使用容量的背包装入物品的价值
     */
    public static int backtrack(int capacity, int[] w, int[] v, int index, int result) {
        int curResult = result;
        for (int i = index; i < w.length - 1; i++) {
            if (capacity >= w[index]) {
                curResult = Math.max(curResult,
                        backtrack(capacity - w[index], w, v, i + 1, result + v[i]));
            }
        }
        return curResult;
    }

    private static void testzero() {
        int[] w = {1, 3, 4};
        int[] v = {15, 20, 30};

        long startTime = System.currentTimeMillis();
        System.out.println("动态规划结果：" + dp(4, w, v));  // 35
        System.out.println("方法运行时间：" + (System.currentTimeMillis() - startTime) + "毫秒");

        startTime = System.currentTimeMillis();
        System.out.println("贪心算法结果：" + greedy(4, w, v));  // 30，这里贪心算法就没有得到最优解
        System.out.println("方法运行时间：" + (System.currentTimeMillis() - startTime) + "毫秒");

        startTime = System.currentTimeMillis();
        System.out.println("回溯结果：" + backtrack(4, w, v, 0, 0));  // 35
        System.out.println("方法运行时间：" + (System.currentTimeMillis() - startTime) + "毫秒");

        startTime = System.currentTimeMillis();
        System.out.println("优化DP结果：" + dp_v(4, w, v));  // 35
        System.out.println("方法运行时间：" + (System.currentTimeMillis() - startTime) + "毫秒");
    }
}
