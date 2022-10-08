package search77.testS;

public class Binary1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 8, 9, 44, 54};
        System.out.println(binary(arr, 0, arr.length-1, 44));
    }
    private static int binary(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;
        if (left > right) {
            return -1;
        }
        if (value > arr[mid]) {
            return binary(arr, mid + 1, right, value);
        } else if (value < arr[mid]) {
            return binary(arr, left, mid - 1, value);
        } else {
            return mid;
        }
    }
}
