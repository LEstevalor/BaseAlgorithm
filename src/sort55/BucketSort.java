package sort55;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {

        int[] arr = { 1, 45, 32, 23, 22, 31, 47, 24, 4, 15 };
        bucket(arr, 10);

        System.out.println(Arrays.toString(arr));
        // [1, 4, 15, 22, 23, 24, 31, 32, 45, 47]
    }

    /**
     * 桶排序
     * @param arr 数组
     * @param bucketSize 自定义桶的大小（根据数组的值和桶的大小来计算需要多少桶）
     */
    public static void bucket(int[] arr, int bucketSize) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        int bucketCount = (max - min) / bucketSize + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // 把每个通的元素放入对应的桶中
        for (int i = 0; i < arr.length; i++) {
            buckets.get((arr[i] - min) / bucketSize).add(arr[i]);
        }

        // 对每个桶中的元素排序，并把他们合并为一个有序数组
        int currentIndex = 0;
        for (int i = 0; i < bucketCount; i++) {
            List<Integer> bucket = buckets.get(i);
            Collections.sort(bucket);
            for (int j = 0; j < bucket.size(); j++) {
                arr[currentIndex++] = bucket.get(j);
            }
        }
    }
}
