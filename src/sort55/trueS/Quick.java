package sort55.trueS;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
        quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quick(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(l+r)/2];
        while (l < r) {
            while (arr[l] < pivot) l++;
            while (arr[r] > pivot) r--;
            if (l >= r) break;
            arr[r] ^= arr[l];          //卡住的数就做交换，直到终止条件
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            if (arr[l] == pivot) r--;   //数组元素可重复才用加这两行
            if (arr[r] == pivot) l++;   //不加可能会一直卡在r或l的某一步，一直跟一个数在做交换
        }
        if (l == r) {   //到这里说明当前元素是中立的
            l++;
            r--;
        }
        if (left < r) quick(arr, left, r);
        if (right > l) quick(arr, l, right);  //直至判断完每一个元素left = r; right = l
    }

    public static void qq(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int midVal = arr[(l+r)/2];
        while (l < r) {
            while (arr[l] < midVal) l++;
            while (arr[r] > midVal) r--;
            if (l >= r) break;
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l] ^= arr[r];
            if (arr[l] == midVal) l++;
            if (arr[r] == midVal) r--;
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {quick(arr, left, r);}
        if (right > l) {quick(arr, l ,right);}
    }

    public static void qu(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int midval = arr[(l+r)/2];
        while (l < r) {
            while (arr[l] < midval) l++;
            while (arr[r] > midval) r--;
            if (l >= r) break;

            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l] ^= arr[r];
            if (arr[l] == midval) l++;
            if (arr[r] == midval) r--;
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) qu(arr, left, r);
        if (right > l) qu(arr, l, right);
    }
}
