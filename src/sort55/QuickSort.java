package sort55;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
//        int[] arr = {2,3,1,5,4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;     // 左下标
        int r = right;    // 右下标
        int temp = 0;     // 临时变量
        int pivot = arr[(l + r) / 2];  // pivot 中轴值
        // while循环的目的：让比pivot 值 小的放左边，大的放右边（如果pivot值不是恰好的中值，那么它会移动的）
        while (l < r) {
            while (arr[l] < pivot) l++;  // 在pivot左边一直找，找到>=pivot的值才退出
            while (arr[r] > pivot) r--;  // 在pivot右边一直找，找到<=pivot的值才退出
            //若l >= r,则说明pivot左边值均比它小，右边值均比它大
            if (l >= r) break;

            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //为了防止加入死循环，若交换完后，发现arr[l] == priot 则 r--,前移，arr[r] == priot 则 l++,后移
            if (arr[l] == pivot) r--;  // 9 9 11  -> 11 9 9就是为什么l r不对应（对应上交换之前的）
            if (arr[r] == pivot) l++;
        }

        //如果l==r,必须l++,r--,否则出现栈溢出  (同时也是说明该数确实是中立的，不需要我们后续再去操作它了)
        if (l == r) {
            l++;
            r--;
        }
        //向左递归(从右一直排到最左边)
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归（从左一直排到最右边）
        if (right > l) {
            quickSort(arr, l, right);
        }

        //while循环内，左移右移，交换，防卡死
        //while循环外，防溢，左递，右递
    }

    public static void quick(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;
        int pivot = arr[(l+r)/2];
        while (l < r) {
            while (arr[l] < pivot) l++;
            while (arr[r] > pivot) r--;
            if (l >= r) break;

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) r--;
            if (arr[r] == pivot) l++;
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) quickSort(arr, left, r);
        if (right > l) quickSort(arr, l, right);
    }
}
