package course;

import java.util.Arrays;
import java.util.HashSet;

import static java.lang.Math.random;

public class BestBinaryTree {
    private static final double maxV = 10000.0;
    public static void main(String[] args) {
        int n = 4;
        double[] p = {maxV, 0.15, 0.1, 0.05, 0.3};
        double[] q = {0.05, 0.1, 0.05, 0.05, 0.15};
        int[][] root = new int[n + 1][n + 1];
        double[][] w = new double[n + 2][n + 2];
        double[][] e = new double[n + 2][n + 2];
        OBST(p, q, n, root, w, e);
        System.out.println(e[1][n]);  // 2.95

        System.out.println("root期望最小节点选取");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(root[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("随机生成正整数范围到11");
        HashSet<Integer> set = new HashSet<>();
        while (set.size() < 4) {
            int a = (int) (random() * 10) + 1;
            set.add(a);
        }

        int[] nums = new int[6];
        int j = 1;
        for (Integer i : set) {
            nums[j++] = i;
        }
        nums[5] = 11;
        Arrays.sort(nums);
        nums[0] = 0;
        // 开区间边界，这样才能被叶子节点包容
        System.out.println("根节点值：");
        for (int i = 1; i < 5; i++) {
            System.out.println(nums[i]);
        }

        System.out.println("查找概率：");
        p[0] = maxV;
        for (int i = 1; i <= n; i++) {
            p[i] = 0.1;
            q[i - 1] = (nums[i] - nums[i - 1] - 1) / 10.0;
            System.out.println(p[i] + " " + q[i - 1]);
        }
        q[n] = (nums[n + 1] - nums[n] - 1) / 10.0;
        System.out.println("   " + q[n]);


        root = new int[n + 1][n + 1];
        w = new double[n + 2][n + 2];
        e = new double[n + 2][n + 2];

        OBST(p, q, n, root, w, e);
        System.out.println("期望值:" + e[1][n]);
    }

    /**
     *
     * @param p 到非叶节点的概率 n+1（首位补-1）
     * @param q 到叶节点的概率   n+1
     * @param n 实际节点数
     * @param root 记录根节点数组 n+1 n+1
     * @param w 子树概率和 n+2 n+2
     * @param e 子树期望   n+2 n+2
     */
    private static void OBST(double[] p, double[] q, int n, int[][] root, double[][] w, double[][] e) {
        for (int i = 1; i <= n + 1; i++) {
            w[i][i - 1] = e[i][i - 1] = q[i - 1];  // 显然[1][0]位虚拟，即叶子节点
        }

        // l决定从小树到大树，i决定从左至右（同时也是l节点高树的节点范围）
        // j为对应i右边界，k为寻找[i,j]范围内最小期望二叉搜索树
        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = l + i - 1;  // 1 - n+1
                e[i][j] = maxV;
                w[i][j] = w[i][j - 1] + p[j] + q[j];

                // 取最小期望子树的根
                for (int k = i; k <= j; k++) {  // 迭代次数为i次
                    double temp = e[i][k - 1] + e[k + 1][j] + w[i][j];
                    if (temp < e[i][j]) {
                        e[i][j] = temp;
                        root[i][j] = k;  // 取根结点位置
                    }
                }

            }
        }
    }
}
