package search77;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//使用二分查找 —— 前提是有序数组（这里假设从小到大）
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int index = binarySearch(arr, 0, arr.length - 1, 87);
        System.out.println(index);

        int[] arr_ = {1, 8, 10, 89, 1000, 1000, 1234};
        ArrayList<Integer> list = binarySearch2(arr_, 0, arr_.length - 1, 1000);
    }

    /**二分查找
     *
     * @param arr
     * @param left
     * @param right
     * @param value
     * @return 找不到下标返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;
        if (left > right) {           //未匹配到的情况
            return -1;
        }
        if (value > arr[mid]) {
            return binarySearch(arr, mid + 1, right, value);
        } else if (value < arr[mid]) {
            return binarySearch(arr, left, mid - 1, value);
        } else {
            return mid;
        }
    }

    //课后思考题，查找多个相同值
    //思路分析：1、在找mid索引值时，不要马上返回；
    //         2、向mid的左右边扫描满足条件的下标，加入集合ArrayList
    //         3、将ArrayList返回
    public static ArrayList binarySearch2(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;
        if (left > right) {
            return null;
        }
        if (value > arr[mid]) {
            return binarySearch2(arr, mid + 1, right, value);
        } else if (value < arr[mid]) {
            return binarySearch2(arr, left, mid - 1, value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(mid);
            //向右查询
            for (int i = mid + 1; i < arr.length; i++) {
                if (arr[i] == value) {
                    list.add(i);
                } else {
                    break;
                }
            }
            //向左查询
            for (int i = mid - 1; i >= 0; i--) {
                if (arr[i] == value) {
                    list.add(i);
                } else {
                    break;
                }
            }
            return list;
        }
    }
}
//跟mid比过了，不需要再考虑mid位置的索引，浪费

