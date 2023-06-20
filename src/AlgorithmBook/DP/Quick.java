package AlgorithmBook.DP;

public class Quick {
    public static void main(String[] args) {
        System.out.println("傻逼徐福林");
        int[] arr = {5, 1, 2, 8, 9};
        quick(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%4d", arr[i]);
        }
    }
    public static void quick(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        while (l < r) {
            int mid = (l + r) >> 1;
            while (arr[l] < arr[mid]) l++;
            while (arr[r] > arr[mid]) r--;
            if (l >= r) break;
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == arr[mid]) l++;
            if (arr[r] == arr[mid]) r--;
        }
        if (l == r) {
            l++;
            r--;
        }
        if (l < right) quick(arr, l, right);
        if (r > left) quick(arr, left, r);
    }
}
