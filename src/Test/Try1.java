package Test;

import java.util.Arrays;

public class Try1 {
    public static void main(String[] args) {
        int n = 2019;
        // int t = n - 1;
        // while (t!= 0 && t / 26 >= 0) {  //确定位数
        //   demi++;
        //   t = (t - 26) / 26;
        // }
        char[] ch = new char[3];
        int[] in = new int[3];
        int i = 2;
        while (i >= 0) {
            in[i] = n % 26;
            if (in[i] == 0) {  //最前一位肯定不为0
                in[i + 1] -= 1;
                in[i] = 26;
            }
            n /= 26;
            i--;
        }

        for (int j = 0; j < 3; j++) {
            ch[j] = (char) (in[j] + 'A' - 1);
        }
        System.out.println(Arrays.toString(ch));

    }
//    b = 0 ? a : gcd(b, a%b);
}
