package search77.testS;

public class Binary2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 8, 9, 10};
        int value = 8;
        System.out.println(solution(arr, value));
    }
    public static int solution(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (value > arr[mid]) {
                left = mid + 1;
            } else if (value < arr[mid]) {
                right = mid - 1;  //左闭右开区间的话，写right = mid，因为最右边值起不到了作用
            } else {
                return mid;
            }
        }
        return -1;
    }
}
