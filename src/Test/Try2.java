package Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Try2 {
    public static void main(String[] args) {
        int j = 20;
        char[] ch = String.valueOf(j).toCharArray();
        System.out.println(Arrays.toString(ch));
        for (char c : ch) {
            int k = c - '0';
            System.out.println(k);
        }

//        System.out.println(3 == 3.0);  //true

//        System.out.println(Math.round(3.451516));  //3

        BigInteger sumy = new BigInteger("89");
        BigInteger sumx = new BigInteger("10");
        for (int i = 1; i <= 60; i++) {
            if (i % 3 == 0) sumx = sumx.multiply(new BigInteger("2"));
            if (i % 2 == 0) sumy = sumy.multiply(new BigInteger("2"));
            if (i % 4 == 0) {
                sumy = sumy.subtract(sumx.divide(new BigInteger("2")));
            } else {
                sumy = sumy.subtract(sumx);
            }
        }
        System.out.println(sumy);

        System.out.println((char)(1+'1'));  //'2'，(char)2 != '2'
    }
}
