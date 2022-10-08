package recursion45;

//迷宫问题
public class Maze {
    public static void main(String[] args) {
        //先模拟一个二维数组，模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //1表示墙
        //边界均为墙
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        for (int j = 1; j < 6; j++) {
            map[0][j] = 1;
            map[7][j] = 1;
        }
        //据题，补墙（挡板）
        map[3][1] = 1;
        map[3][2] = 1;
//        map[2][2] = 1;    //map[2][1] = 3在结果中出现
                            // 再加map[1][2] = 1，结果map[2][1] = map[1][1] = 3

        printMize(map);
        System.out.println();

        setWay(map, 1, 1);

        printMize(map);
    }

    //递归来给小球找路
    /**
     *
     * @param map  表示地图
     * @param i    始发位置行
     * @param j    始发位置列
     * @return     若找到通路，返true，否则返false
     * 约定map[i][j]为0表示还未走过，2表示通路可走，3表示已经走过但走不通
     * 需先确定策略（这里：下 -> 右 -> 上 -> 左）（路径与方向优先顺序有关）
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {  //找到通路
            return true;
        } else {
            if (map[i][j] == 0) {   //可以走还未走
                //开始 递归 找路
                map[i][j] = 2;      //认为该点可以走通
                if (setWay(map, i + 1, j)) {   //下
                    return true;
                } else if (setWay(map, i, j + 1)) {   //右
                    return true;
                } else if (setWay(map, i - 1, j)) {   //上
                    return true;
                } else if (setWay(map, i, j - 1)) {   //左
                    return true;
                } else {
                    map[i][j] = 3;     //或者走不通、死路
                    return false;
                }
            } else {
                // 1/2/3都不能再走
                return false;   //map[i][j] != 0;
            }
        }
    }

    //打印出迷宫地图
    public static void printMize(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}