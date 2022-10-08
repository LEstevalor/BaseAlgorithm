package recursion45;

//八皇后问题
public class Queue8 {
    //定义一个 max 表示共有多少个皇后
    int max = 8;
    //定义数组array，保存皇后放置位置的结果，如 arr = {0, 4, 7, 5, 2, 6, 1, 3}  第1列第0+1行 第2列第4+1行
    int[] array = new int[max];                                //（这样就没有必要判断是否有列重合的情况）
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("解法：" + count);
        System.out.println("判断冲突次数：" + judgeCount);
    }

    //编写一个方法，放置第n个皇后
    private void check(int n) {
        if (n == max) {   //全部放好了
            print();     //如果只是做题，那么这里写count++;即可，去掉print()函数
            return;      //核心为两个函数：check()回溯，judge()判断
        }

        //每行试位
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //从该列的第0+1行开始判断，然后依次增行判断
            array[n] = i;
            //到第i行，判断是否冲突
            if (judge(n)) {
                //若不冲突，接着放n+1个皇后，即开始递归
                check(n + 1);
            }
        }
    }

    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
    /**
     * 判断：与前面 n - 1 个皇后判断符不符合位置标准
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            judgeCount++;
            // 说明
            //1、array[i] == array[n] 表示判断第n个皇后是否和前面n-1个皇后在同一列
            //2、Math.abs(n-i) == Math.abs(array[n]-array[i]) 表示判断第n个皇后是否和第i个皇后是否在同一个斜线（行列差相同）
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])) {
                return false;
            }
        }
        return true;
    }

    //输出皇后摆放的位置
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) System.out.printf(array[i] + " ");
        System.out.println();
    }
}
//方法一check()遍历试位
//方法二judge()判断位置合法