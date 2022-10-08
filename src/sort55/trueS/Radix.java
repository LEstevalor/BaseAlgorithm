package sort55.trueS;

public class Radix {
    public static void main(String[] args) {

    }

    public static void radix(int[] arr) {
        int maxN = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxN = Math.max(arr[i], maxN);
        }
        int maxLen = (maxN + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElement = new int[10];
        for (int i = 0, n = 1; i < maxLen; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digit = arr[i] / n % 10;
                bucket[digit][bucketElement[digit]++] = arr[j];
            }
            int index = 0;
            for (int j = 0; j < 10; j++) {
                if (bucketElement[j] != 0) {
                    for (int k = 0; k < bucketElement[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                }
                bucketElement[j] = 0;
            }
        }
    }
}
