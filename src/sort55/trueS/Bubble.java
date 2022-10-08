package sort55.trueS;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
//        bubble(arr);
//        System.out.println(Arrays.toString(arr));
        ad(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubble(int[] arr) {
        int temp = 0;
        boolean bo = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    bo = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (bo) {
                bo = false;
            } else {
                break;
            }
        }
    }

    public static void ad(int[] arr) {
        boolean bo = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    bo = true;
                    arr[j] ^= arr[j+1];
                    arr[j+1] ^= arr[j];
                    arr[j] ^= arr[j+1];
                }
            }
            if (bo) {
                bo = false;
            } else {
                break;
            }
        }
    }
}
