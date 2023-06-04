package course;

/**
 * 连续邮资问题--回溯法

 以递归回溯的方式去不断更新迭代局部最优解与局部最优值，最后得到全局最优解与全局最优值。
 N、M、
 定义一个函数来实现回溯法。X[]可用邮票的面值列表，递归j是需要支付的邮资总额，Y[]代表对应索引值为邮资所需最小邮票数目，i引导索引数（到N+1为止——终止条件）。
 根据i，每一次调用函数，判断0至上一个x[i-2]的M-1个，来使用当前的x[i-1]去更新Y[]。
 当i>N（及N+1）时，代表调用进入叶子节点位置层，更新局部最优解与最优值。
 然后回溯上一层接着调用，不过需要判断是否对应Y[]值已达M，若已达M其实已经没有遍历意义，因为不能添加邮票了，同时在该测能记录下最优的X[i]
 （在更新最优解位置才会真正记录下该X[i]）。回溯时，注意记录上一层的Y[]，已实现撤销上一步所选的邮票面值。
 */
public class StampQuestion {
    public static int n = 5;  //邮票的不同面值的数量
    public static int m = 4;  //每张信封允许贴的最多邮票数
    public int maxR;  //当前最优值
    public int maxl;  //邮资上界
    public int[] x;  //当前解
    public int[] y;  //贴出各种邮资所需最少邮票数
    public int[] bestx;  //当前最优解

    public static void main(String[] args) {
        StampQuestion st = new StampQuestion();
        int maxR = st.maxStamp();
        System.out.println("n:" + n + " m:"+ m);
        System.out.println("能贴出的最大邮资为：" + maxR);
        for (int i = 1; i <= n; i++) {
            System.out.print(st.bestx[i] + " ");
        }
    }

    public int maxStamp() {
        maxR = 0;
        maxl = 1500;
        bestx = new int[n + 1];
        x = new int[n + 1];
        y = new int[maxl + 1];
        for (int i = 1; i <= maxl; i++) y[i] = Integer.MAX_VALUE;
        x[1] = 1;  // 初始可确定的1解
        // y[0] = 0; // java中默认
        backtrack(2, 1);
        return maxR;
    }

    public void backtrack(int i, int r) {
        // x[i-2]*m的话已经是m个邮票了，没遍历意义
        for (int j = 0; j <= x[i - 2] * (m - 1); j++) {
            // 邮票使用小于m且被替换过
            if (y[j] < m) {
                // 替换为当前的x[i-1]来更新y
                for (int k = 1; k <= m - y[j]; k++) {
                     if (y[j] + k < y[j + x[i - 1] * k]) {
                        y[j + x[i - 1] * k] = y[j] + k;
                    }
                }
            }
        }
        // 与最优r差一个位置r-1便于更新，遍历到r被替换过的位置
        while (y[r] < Integer.MAX_VALUE) r++;

        // 遍历到叶子节点
        if (i > n) {
            // 若覆盖区间大于maxR，更新maxR，并且更新最优解
            if (r - 1 > maxR) {
                maxR = r - 1;
                for (int j = 1; j <= n; j++)
                    bestx[j] = x[j];
            }
            return;
        }

        // 用z存储当前层的y数组值
        int[] z = new int[maxl + 1];
        for (int k = 1; k <= maxl; k++) {
            z[k] = y[k];
        }

        // 下一层迭代
        for (int j = x[i - 1] + 1; j <= r; j++) {
            if (y[r - j] < m) {
                x[i] = j;  // 记录当前解x[i]，若回溯回来再进入也会更新x[i]
                backtrack(i + 1, r + 1);  // 下一位i与r
                for (int k = 1; k <= maxl; k++)
                    y[k] = z[k];
            }
        }
    }
}
