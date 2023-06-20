package sort55;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //位移法
    public static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 这里面就是一个按间隔的插入排序
                int j = i;
                int temp = arr[i];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    //逐步推导(交换法——实际上偏慢)
    public static void shellSort0(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组所有的元素（共gap组，每组arr.length/gap个元素），步长为gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加步长后的元素，则交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }

        /*
        //一轮 (10个数据分成了10/2 = 5组)
        for (int i = 5; i < arr.length; i++) {
            //遍历各组所有的元素（共5组，每组2个元素），步长为5
            for (int j = i - 5; j >= 0; j -= 5) {
                //如果当前元素大于加步长后的元素，则交换
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }

        //二轮 (10个数据分成了10/2/2 = 5/2 = 2组)
        for (int i = 2; i < arr.length; i++) {
            //遍历各组所有的元素（共2组，每组5个元素），步长为2
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }

        //三轮 (10个数据分成了10/2/2/2 1组)
        for (int i = 1; i < arr.length; i++) {
            //遍历各组所有的元素（共1组，每组10个元素），步长为1
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        */

    }
}
