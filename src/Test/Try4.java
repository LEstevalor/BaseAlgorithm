package Test;

import java.util.ArrayList;
import java.util.List;

public class Try4 {
    public static void main(String[] args) {
        Tr tr = new Tr();
        tr.solveNQueens(4);
    }
}

class Tr {
    List res = new ArrayList();
    List<String> arr0 = new ArrayList<>();
    int[] arr = new int[10000];
    int max = 0;
    char[] ch = new char[10000];
    String st;

    public List<List<String>> solveNQueens(int n) {
        max = n;
        for (int i = 0; i < max; i++) {
            ch[i] = '.';
        }
        st = new String(ch);
        queue(0);
        return res;
    }

    public void queue(int n) {
        if (n == max) {
            for (int i = 0; i < max; i++) {
                arr0.add(st.substring(arr[i], arr[i] + 1));
            }
            res.add(arr0);

            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                queue(n + 1);
            }
        }
    }

    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

}
