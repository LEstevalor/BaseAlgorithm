package sort55;

import java.util.Arrays;

//基数排序（桶排序）
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));   //[3, 14, 53, 214, 542, 748]
    }
    //基数排序方法
    public static void radixSort(int[] arr) {
        //(1)、需得到数组中最大数的位置
        int maxN = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxN = Math.max(arr[i], maxN);
        }
        //得到最大数是几位数
        int maxLength = (maxN + "").length();

        //(2)、定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //1、二维数组包含10个一维数组
        //2、为了防止放入数时，数据溢出，则每个一维数组（桶），大小定为arr.length
        //3、基数排序，是空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为记录每个桶，实际放了多少数据，定义一个一维数组来记录桶的数据个数(对这个二维数组，每一行就是一个桶)
        //如bucketElementCounts[0]记录的就是bucket[0]桶内放的个数(每一行的数据个数)
        int[] bucketElementCounts = new int[10];   //记录的就是行数

        int digitOfElement = 0;
        int index = 0;
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // 针对每个位数排序处理
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素对应位值，放入桶中，并把对应桶顶数字+1
                digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = arr[j];
            }
            //遍历每个桶，把桶中数据按顺序放入原数组（放的是重置过的数据）
            for (int j = 0; j < 10; j++) {
                //如果桶中有（重置）数据，才放入
                if (bucketElementCounts[j] != 0) {
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                }
                bucketElementCounts[j] = 0;
            }
            index = 0;
        }

        /*
        //第一轮（针对个位排序处理）
        //取出元素个位
        for (int i = 0; i < arr.length; i++) {
            digitOfElement = arr[i] % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        //按照这个桶的顺序（一维数组的下标依次取出数据，放入原数组）
        index = 0;    //辅助循环桶的变量
        //遍历每一个桶，并将桶中数据放入原数组
        for (int i = 0; i < 10; i++) {
            //如果桶中有数据，才放入原数组
            if (bucketElementCounts[i] != 0) {
                //循环该桶，并取出元素放入原数组
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            //第一轮处理后，需bucketElementCounts[i]=0处理（为下一次使用准备）
            bucketElementCounts[i] = 0;
        }
        System.out.println("第一轮结果：" + Arrays.toString(arr));  //[542, 53, 3, 14, 214, 748]

        //第二轮（针对十位排序处理）
        //取出元素十位数
        for (int i = 0; i < arr.length; i++) {
            digitOfElement = arr[i] / 10 % 10;
            //虽然桶内的数据没有清空，但是再重新入值时，后续只会取出重置过的数据，从下面这条语句可知
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        //按照这个桶的顺序（一维数组的下标依次取出数据，放入原数组）
        index = 0;    //辅助循环桶的变量
        //遍历每一个桶，并将桶中数据放入原数组
        for (int i = 0; i < 10; i++) {
            //如果桶中有数据，才放入原数组
            if (bucketElementCounts[i] != 0) {
                //循环该桶，并取出元素放入原数组
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            bucketElementCounts[i] = 0;       //易漏
        }
        System.out.println("第二轮结果：" + Arrays.toString(arr));  //[3, 14, 214, 542, 748, 53]

        //第三轮（针对百位排序处理）
        //取出元素百位数
        for (int i = 0; i < arr.length; i++) {
            digitOfElement = arr[i] / 100 % 10;    //这里实际上直接/100也行，因为最大位数就是三位
            //虽然桶内的数据没有清空，但是再重新入值时，后续只会取出重置过的数据，从下面这条语句可知
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        //按照这个桶的顺序（一维数组的下标依次取出数据，放入原数组）
        index = 0;    //辅助循环桶的变量
        //遍历每一个桶，并将桶中数据放入原数组
        for (int i = 0; i < 10; i++) {
            //如果桶中有数据，才放入原数组
            if (bucketElementCounts[i] != 0) {
                //循环该桶，并取出元素放入原数组
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            bucketElementCounts[i] = 0;
        }
        System.out.println("第三轮结果：" + Arrays.toString(arr));  //[3, 14, 53, 214, 542, 748]
         */

    }
}
