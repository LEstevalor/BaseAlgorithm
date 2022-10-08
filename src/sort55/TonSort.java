package sort55;

import java.util.ArrayList;
import java.util.Arrays;

public class TonSort {
    public static void main(String[] args) {

        int[] arr = { 1, 45, 32, 23, 22, 31, 47, 24, 4, 15 };
        bucketsort(arr);

        System.out.println(Arrays.toString(arr));  // [1, 45, 32, 23, 22, 31, 47, 24, 4, 15]
    }

    public static void bucketsort(int[] arr) {
        ArrayList[] bucket = new ArrayList[5];// 声明五个桶
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();// 确定桶的格式为ArrayList
        }
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] / 10;// 确定元素存放的桶号
            bucket[index].add(arr[i]);// 将元素存入对应的桶中
        }
        for (int i = 0; i < bucket.length; i++) {// 遍历每一个桶
            bucket[i].sort(null);// 对每一个桶排序
            for (int i1 = 0; i1 < bucket[i].size(); i1++) {// 遍历桶中的元素并输出
                System.out.print(bucket[i].get(i1) + " ");
            }   // 1 4 15 22 23 24 31 32 45 47
        }
    }
}
