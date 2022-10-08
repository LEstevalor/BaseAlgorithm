package tree.unordermintree.prim;

public class MinTreeU {
    public static void main(String[] args) {
        char[] data = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        int nodeCount = data.length;
        int m = Integer.MAX_VALUE;
        int[][] near = new int[][]{
                {0, 5, 7, m, m, m, 2}, {5, 0, m, 9, m, m, 3},
                {m, m, 0, m, 8, m, m}, {m, 9, m, 0, m, 4, m},
                {m, m, 8, m, 0, 5, 4}, {m, m, m, 4, 5, 0, 6},
                {2, 3, m, m, 4, 6, 0}
        };

        new MinTree0().prim(new Graph0(nodeCount, data, near), 1);
    }
}
/*
邻接矩阵
A B C D E F G
0 5 7 - - - 2
5 0 - 9 - - 3
- - 0 - 8 - -
- 9 - 0 - 4 -
- - 8 - 0 5 4
- - - 4 5 0 6
2 3 - - 4 6 0
 */

//创建最小生成树 -> 村庄最短路径
class MinTree0 {
    //创建图的邻接矩阵

    /**
     * 最小生成树算法
     *
     * @param graph
     * @param v     表示从第几个顶点开始生成 'a'->1  'b'->2  'c'->3  ...
     */
    public void prim(Graph0 graph, int v) {
        //表示顶点是否被标记（默认0，从未被访问）（访问我们定为1）
        int[] visited = new int[graph.nodeCount];

        //把当前第一个节点标记
        visited[v - 1] = 1;

        //prim最终会生成n-1条边
        for (int i = 1; i < graph.nodeCount; i++) {
            //t1 t2记录两个顶点下标，目的是确定最短边
            int t1 = -1;
            int t2 = -1;
            //记录最短边
            int curMin = Integer.MAX_VALUE;

            //去遍历，寻找访问过的节点，然后寻找每一个访问过节点的最短边（最短的最短）
            for (int j = 0; j < graph.nodeCount; j++) {
                //当前节点被访问过，下一个节点没有被访问过，而开始寻找最短边
                for (int k = 0; k < graph.nodeCount; k++) {
                    if (visited[j] == 1 && visited[k] == 0 && graph.near[j][k] < curMin) {
                        curMin = graph.near[j][k];   //存最小边，同时存首尾点
                        t1 = j;
                        t2 = k;
                    }
                }
            }
            //找到所有被访问节点的下一个最小边
            System.out.println(graph.data[t1] + "->" + graph.data[t2] + "  权值=" + curMin);
            //并标记尾点
            visited[t2] = 1;
        }
    }
}

//创建图
class Graph0 {
    int nodeCount;      //图节点数
    char[] data;        //存放节点数据
    int[][] near;       //邻接矩阵（存放边）

    public Graph0(int nodeCount, char[] data, int[][] near) {
        this.nodeCount = nodeCount;
        this.data = new char[nodeCount];
        this.near = new int[nodeCount][nodeCount];

        //创建一个新的图，而不影响原来的图
        for (int k = 0; k < nodeCount; k++) {
            this.data[k] = data[k];
            for (int l = 0; l < nodeCount; l++) {
                this.near[k][l] = near[k][l];
            }
        }
    }
}

