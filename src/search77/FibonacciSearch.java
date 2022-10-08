package search77;

import java.util.Arrays;

public class FibonacciSearch {
    static int maxSize = 0;
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        maxSize = 2 * arr.length;
        System.out.println(fibonacciSearch(arr, 1234));
    }
    public static int fibonacciSearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int k = 0;
        int f[] = fib();
        while (high > f[k] - 1) k++;  //获取对应下标
        int[] temp = Arrays.copyOf(nums, f[k] - 1);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = nums[high];
        }
        while (low <= high) {
            int mid = low + f[k-1] - 1;
            if (target < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (target > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                return Math.min(mid, high); //(mid <= high) ? mid : high;  //拓展部分的下标肯定要记为high
            }
        }
        return -1;
    }
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }
}
