package sort55;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        // 升序 -> 大顶堆
        int arr[] = {4, 6, 8, 5, 9};

        heapSort(arr);
    }

    // 堆排序
    public static void heapSort(int[] arr) {
        System.out.println("堆排序");
        int temp = 0;

        // 分布进行
        /*
        adjustHeap(arr, 1, arr.length);
        System.out.println("first: " + Arrays.toString(arr));  // first: [4, 9, 8, 5, 6]

        adjustHeap(arr, 0, arr.length);
        System.out.println("second: " + Arrays.toString(arr));  // second: [9, 6, 8, 5, 4]

        */
        // 1、构造成（大/小）顶堆
        // 最后一个非叶子节点开始
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        // 2、将栈顶元素与（完全二叉树）数组末的元素（里面temp的步骤交换）
        // （会发现每次交换之后，末尾元素被移除 - 长度-1，那么剩下的只有根节点不符合堆，其他节点均仍符合堆）
        // 3、重新调整表结构，再满足堆，进行调整+交换，至整个数组有序
        for (int j = arr.length - 1; j > 0; j--) {
            // 交换（根节点和每次的末端节点交换）
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j); // 不断维护这个
        }

        // 结果
        System.out.println("数组= " + Arrays.toString(arr));
    }

    /**
     * 将一个数组（完全二叉树），调整成一个大顶堆
     * 功能：将以i为非叶子节点的树调整成大顶堆
     * 例：{4,6,8,5,9} i=1 -> adjustHeap -> {4,9,8,5,6} （下一步就得传i=0）   0索引位是根节点的位置
     * @param arr 待调整的数组
     * @param i 非叶子节点在数组中的索引（从这个i，说明是局部的）
     * @param len 对多少个元素调整（排序完的就不纳入比较范围）
     */
    public static void adjustHeap(int[] arr, int i, int len) {
        int temp = arr[i];  // 取出当前非叶节点元素值

        // 调整
        // （1）i*2+1为i的左孩子
        for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
            // 如果右节点值大于左节点，那么切换比较对象为右节点
            if (k + 1 < len && arr[k] < arr[k+1]) {
                k++;
            }
            // 该节点大于arr[i]父节点
            if (arr[k] > temp) {
                arr[i] = arr[k];  // 上移
                i = k;  // 令i指向k继续循环比较（下面可能还有未形成大堆的），确保了下次循环arr[i]的位置正确
            } else {
                break;
            }
        }
        // 当for结束后，以i为父节点的树最大值已放局部最顶端
        arr[i] = temp;  // 赋值回去
    }



    public void heapSort_(int[] arr) {
        // 从第一个非叶子节点遍历每个非叶子节点
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            becomeHeap(arr, i, arr.length);
        }

        // 叶子最边缘与根节点值交换，此时的堆层都是有序的，所有只需对根节点做成顶堆操作
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            becomeHeap(arr, 0, i);
        }
    }

    /**
     * @param arr 待调整的数组
     * @param i 非叶子节点在数组中的索引（从这个i，说明是局部的）
     * @param len 截止元素长度
     */
    private void becomeHeap(int[] arr, int i, int len) {
        int val = arr[i];  // 记录
        for (int k = 2 * i + 1; k < len; k = 2 * k + 1) {
            if (k + 1 < len && arr[k] < arr[k + 1]) {
                k++;  // 右子大则当前转换为右子
            }
            if (arr[k] > val) {
                arr[i] = arr[k];  // 上移
                i = k;            // i此时记录的是下移状态
            } else {
                break;
            }
        }
        arr[i] = val;
    }

}
