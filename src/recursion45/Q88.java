package recursion45;

public class Q88 {
    static int max = 8;
    static int count = 0;
    static int[] arr = new int[max];
    public static void main(String[] args) {
        check(0);
        System.out.println(count);
    }
    public static void check (int n) {
        if (n == max) {
            count++;
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }
    public static boolean judge (int n) {
        for (int i = 0; i < n; i++) {
            if (arr[n] == arr[i] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
