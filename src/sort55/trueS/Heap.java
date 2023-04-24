package sort55.trueS;

import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        heapSort(new int[]{4, 8, 5, 6, 9});
    }

    public static void heapSort(int[] arr) {
        int temp = 0;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            adjust(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void adjust(int[] arr, int i, int len) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < len; k = 2 * k + 1) {
            if (k + 1 < len && arr[k] < arr[k+1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
