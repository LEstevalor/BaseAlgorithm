package Test;

import java.util.*;

public class MainKMP {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s2 = scan.next();
        String s1 = scan.next();

        int s1Len = s1.length();
        int[] next = new int[s1Len];
        getNext(next, s1);

        int i = 1;
        int j = 1;
        int res = 0;
        while (i <= s2.length() && j <= s1Len) {
            if (j == 0 || s2.charAt(i - 1) == s1.charAt(j - 1)) {
                i++;
                j++;
                if (j == s1Len + 1) { // 说明匹配上了，同时i不会往回走，不会有串重叠发生
                    res++;
                    j = 1;  // j从第一位开始比较
                }
            } else {
                j = next[j - 1];
            }
        }
        System.out.println(res);
    }

    public static void getNext(int[] next, String str) {
        int i = 1;
        int j = 0;

        while (i < next.length) {
            if (j == 0 || str.charAt(i - 1) == str.charAt(j - 1)) {
                i++;
                j++;
                next[i - 1] = (str.charAt(i - 1) == str.charAt(j - 1)) ? next[j - 1] : j;
            } else {
                j = next[j - 1];
            }
        }
    }

}
