package sparseArray8;

//稀疏数组
public class Eight1 {
    public static void main(String[] args) {
        //二维数组转稀疏数组
        int[][] a = {{0,0,1,2},{0,0,2,0}};
        int sum = 0;
        //1、遍历二维数组得到有效数字的数目sum
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j] != 0){
                    sum++;
                }
            }
        }
        //2.根据sum的值创建稀疏数组
        int[][] sparseArray = new int[sum+1][3];
        //3.将有效数组存放进稀疏数组
        int point = 1;
        sparseArray[0][0] = a.length;
        sparseArray[0][1] = a[0].length;
        sparseArray[0][2] = sum;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != 0){
                    sparseArray[point][0] = i;
                    sparseArray[point][1] = j;
                    sparseArray[point++][2] = a[i][j];
                }
            }
        }
//        for (int i = 0; i < sum + 1; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.printf("%d\t",sparseArray[i][j]);
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < sum + 1; i++) {
//                System.out.printf("%d\t",sparseArray[i][0],"%d\t",sparseArray[i][1],"%d\n",sparseArray[i][2]);
//        }
        for(int[] arr : sparseArray){
            for(int data : arr){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        System.out.println();
        //把稀疏数组转换为二维数组
        int[][] aa = new int[ sparseArray[0][0] ][ sparseArray[0][1] ];
        for (int i = 1; i <= sparseArray[0][2]; i++) {
            aa[ sparseArray[i][0] ][ sparseArray[i][1] ] = sparseArray[i][2];
        }
        for(int[] arr2 : aa){
            for(int data2 : arr2){
                System.out.printf("%d\t",data2);
            }
            System.out.println();
        }
    }
}
