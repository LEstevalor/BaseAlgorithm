package sort55;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[8000000]; //测试八百万条数据
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * arr.length);  //生成[0,8000000)数
        }

        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = new Date();
        String date1Str = sim.format(date1);
        System.out.println("排序前时间：" + date1Str);


//        new RadixSort().radixSort(arr);   //基数排序测试： 2s


        Date date2 = new Date();
        String date2Str = sim.format(date2);
        System.out.println("排序后时间：" + date2Str);
    }
}
