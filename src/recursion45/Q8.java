package recursion45;

public class Q8 {
    static int max = 8;
    static int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        Q8 q8 = new Q8();
        q8.check(0);
        System.out.println(count);
    }

    public static void check(int n) {
        if (n == max) {
            count++;
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    public static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }
}
