package sort55;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i;   //待插入数据位置的前一个位置
            while (insertIndex >= 1 && insertVal < arr[insertIndex - 1]) {  // 其实这里是确保insertIndex - 1 >= 0
                arr[insertIndex] = arr[insertIndex - 1];
                insertIndex--;
            }
            arr[insertIndex] = insertVal;
        }
    }

//    public void insertSor1t(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            int insertIndex = i;
//            int insertVal = arr[i];
//            while (insertIndex > 0 && arr[insertIndex - 1] > insertVal) {
//                arr[insertIndex] = arr[insertIndex - 1];
//                insertIndex--;
//            }
//            arr[insertIndex] = insertVal;
//        }
//    }

    //self
    public static void insertSort0(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //1、定插入位置
            int insertIndex = i;       //没有比它小，那就放i不动
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    insertIndex = j;   //插入位置
                    break;
                }
            }
            //2、定是否后移
            int temp = arr[i];
            for (int j = i - 1; j >= insertIndex; j--) {
                arr[j + 1] = arr[j];
            }
            arr[insertIndex] = temp;

        }
    }

}
