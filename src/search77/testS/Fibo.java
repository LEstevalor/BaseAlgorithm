package search77.testS;

import java.util.Arrays;

public class Fibo {
    public static void main(String[] args) {
        int[] nums = {1, 5, 8, 78, 89, 111};
        System.out.println(new Solution().fibo(nums, 111));
    }
}
class Solution {
    public int fibo(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int[] f = fib(high + 1);
        int k = 0;
        while (nums.length > f[k] - 1) k++;
        int[] arr = Arrays.copyOf(nums, f[k]-1);
        for (int i = high; i < arr.length; i++) arr[i] = nums[high];
        while (low <= high) {
            int mid = low + f[k-1] - 1;
            if (target > arr[mid]) {
                low = mid + 1;
                k -= 2;
            } else if (target < arr[mid]) {
                high = mid - 1;
                k--;
            } else {
                return Math.min(mid, high);
            }
        }
        return -1;
    }
    public int[] fib(int maxSize) {
        int[] f = new int[maxSize * 2];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }
}
