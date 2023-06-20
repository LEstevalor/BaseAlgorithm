package Test;

import java.util.Arrays;
import java.util.Scanner;

public class ttttttt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] gap = new int[N];
        for (int i = 0; i < N; i++) {
            gap[i] = sc.nextInt();
        }

        // System.out.println(Arrays.toString(gap));

        int[][] near = new int[N][N];
        for (int i = 0; i < M; i++) {
            int k1 = sc.nextInt();
            int k2 = sc.nextInt();
            int k3 = sc.nextInt();
            near[k1-1][k2-1] = k3;
            near[k2-1][k1-1] = k3;
            // System.out.println(k1 + " " + k2 + " " + k3);
        }

        int m = 10000;  // 保证是不会被用的大数
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && near[i][j] == 0) {
                    near[i][j] = m;
                }
                if (i > 0) {
                    near[i][j] += gap[i];
                }
            }
        }

        int res = dijsktra(near, gap, 0);

        System.out.println(res);
    }
    private static int dijsktra(int[][] near, int[] gap, int start) {
        int n = near.length;
        boolean[] visited = new boolean[n];
        visited[start] = true;

        for (int i = 0; i < n; i++) {
            int t = start;
            int mind = Integer.MAX_VALUE / 2;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && near[start][j] < mind) {
                    mind = near[start][j];
                    t = j;
                }
            }
            visited[t] = true;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && near[start][j] > near[start][t] + near[t][j]) {
                    near[start][j] = near[start][t] + near[t][j];
                }
            }

        }

        return near[start][n - 1];
    }
}
/*

确定方法：正序 点到点 -> dijsktra
将到点和隔离时间相加

*/

