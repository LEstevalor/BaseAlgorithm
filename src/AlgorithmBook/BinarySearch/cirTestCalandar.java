package AlgorithmBook.BinarySearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class cirTestCalandar {
    static int[] arr2 = new int[50];  // 前缀表
    static int[][] arr0;  // 结果数组
    static int[][] arr1;  // 间接结果数组
    static int[][] arr1_;  // 结果数组
    public static void main(String[] args) {
        arr2[0] = 1;
        for (int i = 1; i < arr2.length; i++) {
            arr2[i] = arr2[i - 1] * 2;
        }
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        tableDoublePrepare(n1, 1, n1);
        printArr(arr0);

        tablePrepare(n2, 1, n2, true);  // 第二参数为是否随机排序
        printArr(arr1_);
    }

    /**
     * 打印二维数组（不限制方阵）
     * @param arr 二维数组
     */
    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 预处理进入循环赛表获取（只适应于2^k, k>=1）
     * @param n 人数
     * @param start 首位 比如1
     * @param end 尾位 比如8（真实比赛人数）
     */
    public static void tableDoublePrepare(int n, int start, int end) {
        System.out.println("循环赛程表（2^k场景）：");
        arr0 = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr0[i][0] = i;  // 首列赋值
        }
        tableDouble(n, arr0, start, end, end / 2);
    }

    /**
     * 循环赛表获取（只适应于2^k, k>=1）
     * @param n 真实比赛人数
     * @param arr 循环赛表
     * @param start 首位 比如1
     * @param end 尾位 比如8（真实比赛人数）
     * @param disHalf 位差
     */
    private static void tableDouble(int n, int[][] arr, int start, int end, int disHalf) {
        if (start == end - 1) {
            arr[0][start - 1] = arr[1][end - 1] = start;
            arr[0][end - 1] = arr[1][start - 1] = end;
        } else {
            tableDouble(n, arr, start, start + disHalf - 1, disHalf / 2);
            tableDouble(n, arr, end - disHalf + 1, end, disHalf / 2);

            for (int i = 0; i < disHalf; i++) {
                // 对应第一个table
                for (int j = start - 1; j < start + disHalf - 1; j++) {
                    arr[i + disHalf][j + disHalf] = arr[i][j];
                }
                // 对应第二个table
                for (int j = end - disHalf; j < end; j++) {
                    arr[i + disHalf][j - disHalf] = arr[i][j];
                }
            }
        }
    }

    /**
     * 预处理进入循环赛表获取（适合任意大于等于2的比赛人数）
     * @param n 真实比赛人数
     * @param start 首位 比如1
     * @param end 尾位 比如8（真实比赛人数）
     * @param random_ 是否进行天数随机
     */
    public static void tablePrepare(int n, int start, int end, boolean random_) {
        System.out.println("循环赛程表（全场景）：");
        int l = 0;
        int r = arr2.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr2[mid] < end) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        n = arr2[l];
        arr1 = new int[n][n];
        for (int i = 0; i < end; i++) {
            arr1[i][0] = i;  // 首列赋值（超过end的不赋值）
        }
        table(n, arr1, start, arr2[l], arr2[l] / 2, end);

        if (random_) {
            HashSet<ArrayList<Integer>> set = new HashSet<>();
            for (int j = 1; j < n; j++) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < end; i++) {
                    list.add(arr1[i][j]);
                }
                set.add(list);
            }

            int j = 1;
            for (ArrayList<Integer> list : set) {
                int i = 0;
                for (Integer integer : list) {
                    arr1[i++][j] = integer;
                }
                j++;
            }
        }

        if (n == l) {
            arr1_ = arr1;
        } else {
            arr1_ = new int[end][n];
            for (int i = 0; i < end; i++) {
                arr1_[i] = arr1[i];
            }
        }
    }

    /**
     * 循环赛表获取（适合任意大于等于2的比赛人数）
     * @param n 总位差
     * @param arr 循环赛表
     * @param start 首位 比如1
     * @param end 尾位 比如8
     * @param disHalf 位差
     * @param ending 比赛人数（真实比赛人数）
     */
    private static void table(int n, int[][] arr, int start, int end, int disHalf, int ending) {
        if (start == end - 1) {
            if (start <= ending) arr[0][start - 1] = arr[1][end - 1] = start;
            if (end <= ending) arr[0][end - 1] = arr[1][start - 1] = end;
        } else {
            table(n, arr, start, start + disHalf - 1, disHalf / 2, ending);
            table(n, arr, end - disHalf + 1, end, disHalf / 2, ending);

            for (int i = 0; i < disHalf && i < ending - disHalf; i++) {
                // 对应第一个table
                for (int j = start - 1; j < start + disHalf - 1; j++) {
                    arr[i + disHalf][j + disHalf] = arr[i][j];
                }
                // 对应第二个table
                for (int j = end - disHalf; j < end; j++) {
                    arr[i + disHalf][j - disHalf] = arr[i][j];
                }
            }
        }
    }
}