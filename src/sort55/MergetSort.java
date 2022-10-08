package sort55;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergetSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];   //归并排序需一个额外空间(空间换时间)
        mergeSort(arr, 0, arr.length - 1, temp);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(temp));
    }

    // 分 + 合方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;  //中间索引
            //向左递归分解
            mergeSort(arr, left, mid, temp);
            //向右递归分解
            mergeSort(arr, mid + 1, right, temp);
            //到合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 归并
     * @param arr    原始数组
     * @param left   左边有序序列的初始索引
     * @param mid    中间索引
     * @param right  右边索引
     * @param temp   做中转的数值
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;     //左边有序序列的初始索引
        int j = mid + 1;  //右边有序序列的初始索引
        int t = 0;        //指向temp数组的当前索引

        //(一)
        //先把左右两边的数据按规则填充至temp数组，直到左右两边有序序列有一边处理完为止(有一边满足了，就一边false，跳出)
        while (i <= mid && j <= right) {
            //若  左边有序序列的当前元素<=右边有序序列的当前元素  左边的当前元素拷贝到temp数组
            //若  反之 右边的当前元素拷贝到temp数组
            temp[t++] = (arr[i] <= arr[j]) ? arr[i++]: arr[j++];
        }

        //(二)
        //把剩余数据的一边的数据依次填充到temp中
        while (i <= mid) temp[t++] = arr[i++];   //若左边剩余
        while (j <= right) temp[t++] = arr[j++]; //若右边剩余

        //(三)
        //将temp数组的元素拷贝到arr（注：并不是每次都拷贝所有）
        t = 0;
        int templeft = left;
        //第一次templeft = 0  right = 1
        //第二次           2          3
        //第三次           0          3    。。。
        //最后一次（第七次）0          7
        while (templeft <= right) arr[templeft++] = temp[t++];
    }

}
/*
if (arr[i] <= arr[j]) {
        temp[t++] = arr[i++];
        } else {
        temp[t++] = arr[j++];
        }
 */