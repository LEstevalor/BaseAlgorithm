package Test;

import java.util.Scanner;

public class Agvesg {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.close();
        long[][] near = new long[2021][2021];
        for (int i = 0; i < 2021; i++) {
            for (int j = i+1; j < 2021; j++) {
                if (j - i > 21) {
                    near[i][j] = Integer.MAX_VALUE / 2;
                } else {
                    near[i][j] = lcm(i+1, j+1);
                }
                near[j][i] = near[i][j];
            }
        }
        dijkstra(near, 0);
        System.out.println(near[0][2020]);
    }
    static void dijkstra(long[][] near, int start) {
        int n = near.length;   //顶点个数
        int[] visited = new int[n];   //标记访问矩阵 0 1
        //初始点记为已标记
        visited[start] = 1;
        //遍历 n-1次，更新最短路径(i无实际意义，只是为了遍历n-1次)
        for (int i = 1; i < n; i++) {
            long minDis = Integer.MAX_VALUE / 2;
            int t = start;    //标记尾点
            //寻找第一最短边
            for (int j = 0; j < n; j++) {
                if (visited[j] == 0 && near[start][j] < minDis) {
                    t = j;
                    minDis = near[start][j];
                }
            }

            //标记尾点j，让其作为中间节点开始遍历
            visited[t] = 1;
            for (int k = 0; k < n; k++) {
                if (visited[k] == 0 && near[start][t] + near[t][k] < near[start][k]) {
                    near[start][k] = near[start][t] + near[t][k];
                }
            }
        }
    }

    //最小公倍数 = a*b/最大公倍数
    static int lcm(int a, int b) {
        return a * b / gcd(a,b);
    }
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}
