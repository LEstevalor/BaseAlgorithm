package tree.unordermintree.prim;

/**
 * 最小生成树算法 求 最短路径
 */
public class MinTreeUsing {
    public static void main(String[] args) {
        int nodeCount = 7;
        int m = Integer.MAX_VALUE;
        int[][] near = new int[][]{
                {0, 5, 7, m, m, m, 2}, {5, 0, m, 9, m, m, 3},
                {m, m, 0, m, 8, m, m}, {m, 9, m, 0, m, 4, m},
                {m, m, 8, m, 0, 5, 4}, {m, m, m, 4, 5, 0, 6},
                {2, 3, m, m, 4, 6, 0}
        };

        //求最短路径
        int res = new MMinTree().prim(new MGraph(nodeCount, near), 1);

        System.out.println(res);   // 25
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
class MMinTree {
    //创建图的邻接矩阵

    /**
     * 最小生成树算法 —— 最短路径
     *
     * @param graph
     * @param v     表示从第几个顶点开始生成 'a'->1  'b'->2  'c'->3  ...
     */
    public int prim(MGraph graph, int v) {
        //结果数
        int res = 0;
        //表示顶点是否被标记（默认0，从未被访问）（访问我们定为1）
        int[] visited = new int[graph.nodeCount];

        //把当前第一个节点标记
        visited[v - 1] = 1;

        //prim最终会生成n-1条边（这里只是为了遍历n-1次，i没有任何实际意义）
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
            res += curMin;
            //并标记尾点（易漏）
            visited[t2] = 1;
        }
        return res;
    }
}

//创建图
class MGraph {
    int nodeCount;      //图节点数
    int[][] near;       //邻接矩阵（存放边）

    public MGraph(int nodeCount, int[][] near) {
        this.nodeCount = nodeCount;
        this.near = near;
    }
}

/**
 * Prim算法
 * 记忆数组，记录起点，表示被访问过
 * 外层遍历n-1，仅遍历作用
 * 内遍历，两层遍历找起点为被访问过的点，终点为未被访问过的点，中最短的路，记录终点即可（如果题目要求的只是结果）
 * 将最短路做叠加，记录终点为被访问点
 */
class MM {
    public int prim(int[][] near, int v) {
        int res = 0;
        int n = near.length;
        int[] visited = new int[n];
        visited[v-1] = 1;
        for (int i = 0; i < n-1; i++) {
            int t1 = -1;
            int t2 = -1;
            int min = Integer.MAX_VALUE/2;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (visited[j] == 1 && visited[k] == 0 && min > near[j][k]) {
                        min = near[j][k];
                        t1 = j;
                        t2 = k;
                    }
                }
            }
            res += min;
            visited[t2] = 1;
        }
        return res;
    }
}

/*

	public static int prim(int[][] near, int start) {
		int size = near.length;
		boolean[] visited = new boolean[size];
		visited[start] = true;
		int res = 0;

		for (int i = 1; i < size; i++) {
			int minPath = Integer.MAX_VALUE / 2;
			int end = -1;

			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					if (visited[j] && !visited[k] && near[j][k] < minPath) {
						minPath = near[j][k];
						end = k;
					}
				}
			}

			res += minPath;
			visited[end] = true;
		}
		return res;
	}

 */
