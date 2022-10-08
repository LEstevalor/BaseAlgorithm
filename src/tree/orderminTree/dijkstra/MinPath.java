package tree.orderminTree.dijkstra;

public class MinPath {
    public static void main(String[] args) {
        char[] data = {'a','b','c','d','e','f','g'};
        int m = Integer.MAX_VALUE/2;
        int[][] near = new int[][] {
                {0,5,7,m,m,m,2},{5,0,m,9,m,m,3},
                {m,m,0,m,8,m,m},{m,9,m,0,m,4,m},
                {m,m,8,m,0,5,4},{m,m,m,4,5,0,6},
                {2,3,m,m,4,6,0}
        };
        new DijkstraDemo().dijkstra(data, near, 0);
        for (int i = 0; i < near.length; i++) {
            System.out.printf("%4d", near[0][i]);
        }
    }
}
class DijkstraDemo {
    public void dijkstra(char[] data, int[][] near, int start) {
        //顶点数
        int n = near.length;
        //保存起始点（原点）到各个顶点的最短路径
        int[] bis = new int[n];
        //标记当前顶点是否被访问
        int[] visited = new int[n];
        //记录最短路径的顶点
        String[] path = new String[n];
        //初始化标记路径，一开始假设起始点到所有其他点可通
        for (int i = 0; i < n; i++) {
            path[i] = new String(data[start] + "->" + data[i]);
        }
        //该起始点标记为被访问过，且到本身的距离为0
        visited[start] = 1;
        bis[start] = 0;

        //这里我们要执行n-1次对于所有的顶点，求的与其他点对应的最短路径
        for (int i = 1; i < n; i++) {
            //遍历所有边，从最短的开始，利用尾点做中间节点，更新start起始点到其他点的距离

            //比如即使 A与F不相通，但是在前面的更新中早已把near对应的值赋上去了
            int t = -1;    //记录最短路径的尾点（只要是连通图，那么-1就会被替换调，必有相通的点被更新）
            int minDis = Integer.MAX_VALUE/2;
            // 先找到 start初始点 到 另外N-1个点中最短的那一条路径
            for (int j = 0; j < n; j++) {
                if (visited[j] == 0 && near[start][j] < minDis) {
                    minDis = near[start][j];
                    t = j;
                }
            }
            //记录最短路径并标记
            bis[t] = minDis;
            visited[t] = 1;

            //然后以尾点作为中间点，开始找经过该最短路径的点，同时进行比较
            for (int k = 0; k < n; k++) {
                if (visited[k] == 0 && near[start][t] + near[t][k] < near[start][k]) {
                    near[start][k] = near[start][t] + near[t][k];
                    path[k] = path[t] + "->" + path[k];
                }
            }
        }
    }
}
class GraphPP {
    char[] data;
    int[][] near;
    public GraphPP(char[] data, int[][] near) {
        this.data = data;
        this.near = near;
    }
}
