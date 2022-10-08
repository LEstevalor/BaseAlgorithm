package tree.orderminTree.dijkstra;

public class MMM {
    /**
     * Dijkstra算法
     * @param near  邻接矩阵
     * @param start 起始点
     */
    public static void dijkstra(int[][] near, int start) {
        int n = near.length;
        int[] visited = new int[n];
        visited[start] = 1;

        for (int i = 1; i < n; i++) {
            int t = start;
            int minDis = Integer.MAX_VALUE/2;
            for (int j = 0; j < n; j++) {
                if (visited[j] == 0 && near[start][j] < minDis) {
                    minDis = near[start][j];
                    t = j;
                }
            }
            visited[t] = 1;
            for (int k = 0; k < n; k++) {
                if (visited[k] == 0) {
                    near[start][k] = Math.min(near[start][k], near[start][t] + near[t][k]);
                }
            }
        }
    }

    /**
     * Floyd算法
     * @param near 邻接矩阵
     */
    public static void floyd(int[][] near) {

        for (int k = 0; k < near.length; k++) {

            for (int i = 0; i < near.length; i++) {
                for (int j = 0; j < near.length; j++) {

                    near[i][j] = Math.min(near[i][j],
                            near[i][k] + near[k][j]);

                }
            }

        }
    }
}
