package recursion45;

public class Memory {
    static int max = 8;
    static int[] arr = new int[8];
    static int count = 0;

    public static void main(String[] args) {
        Memory memory = new Memory();
        memory.que8(0);
        System.out.println(count);
    }

    public static void que8(int n) {
        if (n == max) {
            count++;
            return ;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                que8(n + 1);
            }
        }
    }

    public static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
