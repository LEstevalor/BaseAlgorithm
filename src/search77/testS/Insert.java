package search77.testS;

public class Insert {
    public static void main(String[] args) {
        int[] arr = new int[11];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(new Solution0().insert(arr, 10));
    }
}
class Solution0 {
    public int insert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        if (target > nums[high] || target < nums[low]) return -1;
        while (low <= high) {
            int mid = low + ((target-nums[low])/(nums[high]-nums[low]))*(high - low);
            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
