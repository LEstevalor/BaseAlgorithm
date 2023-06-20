package tree.orderminTree.floyd;

public class MinPath {
    public static void main(String[] args) {
        char[] data = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        int m = Integer.MAX_VALUE / 2;
        int[][] near = new int[][]{
                {0, 5, 7, m, m, m, 2}, {5, 0, m, 9, m, m, 3},
                {m, m, 0, m, 8, m, m}, {m, 9, m, 0, m, 4, m},
                {m, m, 8, m, 0, 5, 4}, {m, m, m, 4, 5, 0, 6},
                {2, 3, m, m, 4, 6, 0}
        };

        GraphP graphP = new GraphP(data, near);
        new FloydDemo().floyd(near);
        for (int i = 0; i < near.length; i++) {
            for (int j = 0; j < near.length; j++) {
                System.out.printf("%4d", near[i][j]);
            }
            System.out.println();
        }
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
class FloydDemo {
    public void floyd(int[][] near) {
        //将每一个节点作为中间节点，进行更新
        for (int k = 0; k < near.length; k++) {
            //节点i，到另一个节点j，不断更新
            for (int i = 0; i < near.length; i++) {
                for (int j = 0; j < near.length; j++) {
                    near[i][j] = Math.min(near[i][j], near[i][k] + near[k][j]);
                }
            }
        }
    }
}

class GraphP {
    char[] data;   //节点数据
    int[][] near;  //路径矩阵

    public GraphP(char[] data, int[][] near) {
        this.data = data;
        this.near = near;
    }
}
