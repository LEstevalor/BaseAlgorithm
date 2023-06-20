package sort55.trueS;

public class Insert {
    public static void main(String[] args) {

    }

    public static void insert(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i;
            while (insertIndex > 0 && insertVal < arr[insertIndex - 1]) {
                arr[insertIndex] = arr[insertIndex - 1];
                insertIndex--;
            }
            arr[insertIndex] = insertVal;
        }
    }

    public static void eInsert(int[] arr) {
        int val = 0;
        int k = 0;
        for (int i = 1; i < arr.length; i++) {
            val = arr[i];
            k = i;
            while (k > 0 && val < arr[k-1]) {
                arr[k] = arr[k-1];
                k--;
            }
            arr[k] = val;
        }
    }

    public static void baba(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i;
            while (insertIndex > 0 && insertVal < arr[insertIndex - 1]) {
                arr[insertIndex] = arr[insertIndex] - 1;
                insertIndex--;
            }
            arr[insertIndex] = insertVal;
        }
    }
}
