package Test;

import java.lang.reflect.Array;
import java.util.*;

public class Adafaw {
    public static void main(String[] args) {
//        Integer[] nums = {4,3,2,1};
//        Arrays.sort(nums,0,4);
        /*Arrays.sort(nums,0,4, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });*/
//        System.out.println(Arrays.toString(nums));

        /*
        // 快捷方法1：Arrays.asList
        Integer[] arr = new Integer[]{1, 2, 3};
        List<Integer> list_ = Arrays.asList(arr);
        System.out.println(list_.toString());       // [1, 2, 3]
        // 快捷方法2：Collections.addAll()
        List<Integer> list__ = new ArrayList<>();
        Collections.addAll(list__, arr);
        System.out.println(list__.toString());       // [1, 2, 3]
         */

        /*
        // toArray
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        Integer[] arr1 = list1.toArray(new Integer[list1.size()]);
        System.out.println(Arrays.toString(arr1));  // [1, 2, 3]
        */
        /*
        // Arrays.sort
        Integer[] arr1 = new Integer[]{5, 2, 0, 1, 3, 1, 4};
        //指定排序初始索引和终止位置（终止索引-1）
        Arrays.sort(arr1, 0, 2);    // [2, 5, 0, 1, 3, 1, 4]
        //顺序-默认升序
        Arrays.sort(arr1);                            // [0, 1, 1, 2, 3, 4, 5]

        //倒序 传入一个实现了Comparator接口
        Arrays.sort(arr1, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;  //大于就交换
            }
        });

        //二维数组排序，其中一维按升序/倒序排序（lambda表达式-简易）
        Integer[][] arr2 = new Integer[][]{{1,3},{3,6},{2,9}};
        Arrays.sort(arr2, (a,b) -> {
            return a[0] - b[0];   //倒序就 b[0] - a[0]  0代表的就是每行第一位（索引）
        });
        // 1 3
        // 2 9
        // 3 6
        */
        /*
        //链表
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.removeLast();  //回溯移调最后一个元素
        //字符串
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('a');
        stringBuffer.deleteCharAt(stringBuffer.length()-1);  //传入的是索引
        String str = stringBuffer.toString();
         */
        /*
        List<String> list = new ArrayList<>();
        list.add("a");            //增
        list.get(0);              //查（用索引）
        list.isEmpty();           //判空
        list.remove(0);     //删
        list.indexOf("a");        //查（用数据）

        LinkedList<String> list_ = new LinkedList<>();
        list_.addFirst("a");   //头插
        list_.addLast("b");    //尾插
        list_.peek();             //活动链表首（头）元素
        list_.pop();              //弹出链表首（头）元素
        list_.remove(0);    //删
        list_.removeFirst();      //删头
        list_.removeLast();       //删尾
        list_.get(0);             //查（用索引）
        list_.indexOf("b");       //查（用数据）

        HashSet<String> set = new HashSet<>();
        set.add("a");         //增
        set.contains("a");    //含
        set.isEmpty();        //判空
        set.remove("a");   //删
        set.size();           //大小

        HashMap<String, String> map = new HashMap<>();
        map.put("a", "amazing");         //增
        map.containsKey("a");            //含-key
        map.containsValue("amazing");    //含-value
        map.remove("a");            //删
        map.size();                      //大小
        map.isEmpty();                   //判空
        map.getOrDefault("a", "army");  //有key="a"则返回原value，无则添加"a","army"键值对

        //indexOf
        //subString
        //length
        //isEmpty
        //equals
        //charAt
        //compareTo

        // StringBuffer（多）  StringBuilder（单）
        // 相比String常用，多的API
        // append
        // delete
        // deleteCharAt

        Queue<String> queue = new LinkedList<>();
        //add      增
        //offer
        //remove   删
        //poll
        //peek     查
        //element

        Deque<String> deque = new LinkedList<>();
        //增    addFirst(e)	    offerFirst(e)	addLast(e)	    offerLast(e)
        //删	removeFirst()	pollFirst()	    removeLast()	pollLast()
        //查	getFirst()	    peekFirst()	    getLast()	    peekLast()

         */
        //因为其本质是根堆而不是队列，因此遍历输出得到的元素无序，依次弹出根顶元素才有序
        //大在前则是大根堆，小在前则是小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        //contains(E e)        		//含
        //offer(E e) 				//将指定元素插入此优先队列
        //peek() 					//获取根堆顶元素
        //poll() 					//获取并移除根堆顶元素
        //remove(Object o) 		    //删
        //size() 					//大小

    }
}
