package sort55.trueS;

import java.util.Arrays;

public class Select {
    public static void main(String[] args) {

        int[] arr = {1,3,2,4};
        select(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void select(int[] arr) {
        int minIndex = 0;
        int min = 0;      //意义同temp
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = (arr[j] < arr[minIndex]) ? j : minIndex;
            }
            if (minIndex != i) {
                min = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    public static void mama(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            if (minIndex != i) {
                arr[minIndex] ^= arr[i];
                arr[i] ^= arr[minIndex];
                arr[minIndex] ^= arr[i];
            }
        }
    }
}
