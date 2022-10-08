package search77;

public class InsertValueSearch {
    static int count = 0;

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 1; i <= 100; i++) {
            arr[i - 1] = i;
        }
        System.out.println("索引结果" + insertValueSearch(arr, 0, arr.length - 1, 1));
        System.out.println("调用次数" + count);
    }

    public static int insertValueSearch(int[] arr, int left, int right, int target) {
        if (left > right || target < arr[0] || target > arr[arr.length - 1]) return -1;  //比最小值或比最大值大，索引越界
//        count++;
        int mid = left + ((target - arr[left]) / (arr[right] - arr[left])) * (right - left);
        if (target > arr[mid]) {
            return insertValueSearch(arr, mid + 1, right, target);
        } else if (target < arr[mid]) {
            return insertValueSearch(arr, left, mid - 1, target);
        } else {
            return mid;
        }
    }
}
