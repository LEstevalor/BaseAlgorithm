package Test;

import java.util.Scanner;

public class Dfaawf {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        sc.close();
        long res = 1;
        if (n > 1) {
            long[]	nums = new long[47725];
            nums[0] = 1;
            nums[1] = 1;
            for (int i = 2; i < 47725; i++) {
                for (int j = i; j >= 1; j--) {
                    if (j == i || j == 0) {
                        nums[j] = 1;
                    } else {
                        nums[j] += nums[j-1];
                    }
                    if (nums[j] == n) {
                        res = j + 1 + (i + 1) * i / 2;
                    }
                }
            }
            res = res==1? 2 + (n + 1) * n / 2 : res;
            System.out.println(res);
        } else {
            System.out.println(res);
        }

    }
}
