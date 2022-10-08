package Test;

public class FAFAW {
    public static void main(String[] args) {
        dijkstra();
    }

    private static void dijkstra() {
        long[][] distance=new long[2021][2021];
        //得到点到其他相邻点的距离
        for (int i = 0; i <2021; i++) {
            for (int j = i + 1; j <2021 ; j++) {
                if (j - i > 21) {
                    distance[i][j] = 999999999L;
                } else {
                    distance[i][j] = lcm(i+1,j+1);
                }
                distance[j][i] = distance[i][j];
            }
        }
        boolean[] useSpot=new boolean[2021];//选择点
        long[] dis=new long[2021];
        for (int i = 0; i <2021 ; i++) {
            dis[i]=999999999L;
        }
        dis[0]=0;
        for (int i = 0; i <2021 ; i++) {
            int minIndex=0;
            long min=999999999L;
            for (int j = 0; j < 2021; j++) {
                if(!useSpot[i]&&Math.abs(i-j)<=21){
                    if(min>dis[j]){//选出最优路线
                        minIndex=j;
                        min=dis[j];
                    }
                }
            }
            for (int j = 0; j < 2021; j++) {
                if(distance[minIndex][j]!=0&&min+distance[minIndex][j]<dis[j]){
                    dis[j]=min+distance[minIndex][j];
                }
            }
            useSpot[minIndex]=true;
        }
        System.out.println(dis[2020]);
    }

    //最小公倍数 = a*b/最大公倍数
    static int lcm(int a, int b) {
        return a * b / gcd(a,b);
    }
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}
