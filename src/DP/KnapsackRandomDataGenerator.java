package DP;

import java.util.Random;

public class KnapsackRandomDataGenerator {
    private int capacityMin;
    private int capacityMax;
    private int itemCountMin;
    private int itemCountMax;
    private int weightMin;
    private int weightMax;
    private int valueMin;
    private int valueMax;

    public KnapsackRandomDataGenerator(int capacityMin, int capacityMax, int itemCountMin, int itemCountMax,
                                       int weightMin, int weightMax, int valueMin, int valueMax) {
        this.capacityMin = capacityMin;
        this.capacityMax = capacityMax;
        this.itemCountMin = itemCountMin;
        this.itemCountMax = itemCountMax;
        this.weightMin = weightMin;
        this.weightMax = weightMax;
        this.valueMin = valueMin;
        this.valueMax = valueMax;
    }

    public void generateTest() {
        long result_time1 = 0;
        long result_time2 = 0;
        long result_time3 = 0;
        long result_time4 = 0;

        Random random = new Random();
        int numTests = 10000;
        for (int i = 1; i <= numTests; i++) {
            int capacity = random.nextInt(capacityMax - capacityMin + 1) + capacityMin;
            int itemCount = random.nextInt(itemCountMax - itemCountMin + 1) + itemCountMin;
            int[] weights = new int[itemCount];
            int[] values = new int[itemCount];
            for (int j = 0; j < itemCount; j++) {
                int weight = random.nextInt(weightMax - weightMin + 1) + weightMin;
                int value = random.nextInt(valueMax - valueMin + 1) + valueMin;
                weights[j] = weight;
                values[j] = value;
            }

            long startTime1 = System.currentTimeMillis();
            packet01.dp(capacity, weights, values);
            long endTime1 = System.currentTimeMillis();
            result_time1 += (endTime1 - startTime1);

            long startTime2 = System.currentTimeMillis();
            packet01.greedy(capacity, weights, values);
            long endTime2 = System.currentTimeMillis();
            result_time2 += (endTime2 - startTime2);

            long startTime3 = System.currentTimeMillis();
            packet01.backtrack(capacity, weights, values, 0, 0);
            long endTime3 = System.currentTimeMillis();
            result_time3 += (endTime3 - startTime3);

            long startTime4 = System.currentTimeMillis();
            packet01.dp_v(capacity, weights, values);
            long endTime4 = System.currentTimeMillis();
            result_time4 += (endTime4 - startTime4);
        }
        System.out.println("随机" + numTests + "条测试数据的运行时间：");
        System.out.println("动态规划算法运行时间：" + result_time1 + "ms");
        System.out.println("贪心算法运行时间：" + result_time2 + "ms");
        System.out.println("回溯算法运行时间：" + result_time3 + "ms");
        System.out.println("优化DP空间运行时间：" + result_time4 + "ms");
    }

    public static void main(String[] args) {
        // 容量在[1, 200]，物品数量在[1, 30]，重量在[1, 50]，价值在[1, 50]
        KnapsackRandomDataGenerator generator = new KnapsackRandomDataGenerator(1, 200,
                1, 10, 1, 50, 1, 50);
        generator.generateTestData();
    }

    public void generateTestData() {
        Random random = new Random();
        int numTests = 50;
        for (int i = 1; i <= numTests; i++) {
            int capacity = random.nextInt(capacityMax - capacityMin + 1) + capacityMin;
            int itemCount = random.nextInt(itemCountMax - itemCountMin + 1) + itemCountMin;
            int[] weights = new int[itemCount];
            int[] values = new int[itemCount];
            for (int j = 0; j < itemCount; j++) {
                int weight = random.nextInt(weightMax - weightMin + 1) + weightMin;
                int value = random.nextInt(valueMax - valueMin + 1) + valueMin;
                weights[j] = weight;
                values[j] = value;
            }
            System.out.print("Test " + i + ": ");
            System.out.print("capacity=" + capacity + ", ");
            System.out.print("itemCount=" + itemCount + ", ");
            System.out.println("weights=" + arrayToString(weights) + ", values=" + arrayToString(values));
        }
    }

    private String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
