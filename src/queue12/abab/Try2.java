package queue12.abab;

import java.math.BigInteger;
import java.util.Arrays;

public class Try2 {
    public static void main(String[] args) {
        String str = "7 5 8 7 8 8 9 2 7 2 8 1 4 9 1 8 1 8 8 4 1 7 9 6 1 4 5 4 5 6 5 5 6 9 5 6 5 5 4 7 9 3 5 5 1 " +
        "7 5 7 9 7 4 7 3 3 1 4 6 4 5 5 8 8 3 2 4 3 1 1 3 3 1 6 6 5 5 4 4 2 9 9 9 2 1 9 1 9 2 9 5 7 9 " +
        "4 3 3 7 7 9 3 6 1 3 8 8 3 7 3 6 8 1 5 3 9 5 8 3 8 1 8 3 3 8 3 2 3 3 5 5 8 5 4 2 8 6 7 6 9 " +
        "8 1 8 1 8 4 6 2 2 1 7 9 4 2 3 3 4 2 8 4 2 2 9 9 2 8 3 4 9 6 3 9 4 6 9 7 9 7 4 9 7 6 6 2 8 9 4 1 8 1 7 2 1 6 " +
        "9 2 8 6 4 2 7 9 5 4 1 2 5 1 7 3 9 8 3 3 5 2 1 6 7 9 3 2 8 9 5 5 6 6 6 2 1 8 7 9 9 " +
        "6 7 1 8 8 7 5 3 6 5 4 7 3 4 6 7 8 1 3 2 7 4 2 2 6 3 5 3 4 9 2 4 5 7 6 6 3 2 7 2 4 8 5 5 4 " +
        "7 4 4 5 8 3 3 8 1 8 6 3 2 1 6 2 6 4 6 3 8 2 9 6 1 2 4 1 3 3 5 3 4 9 6 3 8 6 5 9 1 5 3 2 6 8 8 5 3 " +
        "2 2 7 9 3 3 2 8 6 9 8 4 4 9 5 8 2 6 3 4 8 4 9 3 8 8 " +
        "7 7 7 9 7 5 2 7 9 2 5 1 9 2 6 5 3 9 3 5 7 3 5 4 2 8 9 " +
        "7 7 6 6 8 7 5 5 8 2 4 7 7 4 7 2 6 9 2 1 8 2 9 8 5 7 3 6 " +
        "5 9 4 5 5 7 5 5 6 3 5 3 9 5 8 9 5 4 1 2 6 1 4 3 5 3 2 4 1 ";
        String arr[] = str.split(" ");
        int temp = 0;
        double num[][] = new double[30][30];
        for(int i = 0; i < 29; i++) {
            for(int j = 0; j < i + 1; j++) {
                num[i][j] = Double.valueOf(arr[temp++]);
            }
        }
        for(int i = 1; i < 30; i++) {
            for(int j = 0; j < 30; j++) {
                if(j != 0)
                    num[i][j] += num[i - 1][j]/2.0 + num[i - 1][j - 1]/2.0;
                else
                    num[i][j] += num[i - 1][j]/2.0;
            }
        }
        Arrays.sort(num[29]);
        System.out.println(num[29][29]);
        System.out.println(num[29][0]);
//        double number = num[29][29] / num[29][0];
        int number = (int)(num[29][29]/num[29][0]);
        BigInteger big1 = new BigInteger("2086458231");
        BigInteger big2 = new BigInteger(String.valueOf(number));
        System.out.println(num[29][29]/num[29][0]);
        System.out.println(big1.multiply(big2));
    }
}
