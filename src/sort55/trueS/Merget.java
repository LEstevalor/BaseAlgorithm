package sort55.trueS;

import java.util.Arrays;

public class Merget {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];   //归并排序需一个额外空间(空间换时间)
        mergetSort(arr, 0, arr.length - 1, temp);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(temp));
    }

    public static void mergetSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergetSort(arr, left, mid, temp);
            mergetSort(arr, mid + 1, right, temp);
            merget(arr, left, mid, right, temp);
        }
    }

    public static void merget(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            temp[t++] = (arr[i] < arr[j]) ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[t++] = arr[i++];
        while (j <= right) temp[t++] = arr[j++];
        t = 0;
        while (left + t <= right) arr[left + t] = temp[t++];
    }

    public static void megadw(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            temp[t++] = (arr[i] < arr[j]) ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[t++] = arr[i++];
        while (j <= right) temp[t++] = arr[j++];
        t = 0;
        while (left + t <= right) arr[left + t] = temp[t++];
    }
}
