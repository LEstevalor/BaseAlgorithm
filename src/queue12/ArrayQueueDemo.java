package queue12;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';   //接受用户输入
        Scanner sc = new Scanner(System.in);
        boolean tip = true;
        while(tip) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add): 添加数据");
            System.out.println("g(get): 取出数据");
            System.out.println("h(head):查头数据");
            key = sc.next().charAt(0);
            switch (key) {
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("输出一个值");
                    int value = sc.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    } break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("取出的头数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    } break;
                case 'e':
                    sc.close();
                    tip = false;
                    break;
                default: break;
            }
        }
        System.out.println("程序退出");
    }
}

//使用数组模拟队列
//编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize;   //表示数组最大容量
    private int front;     //队列头
    private int rear;      //队列尾
    private int[] arr;     //用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;            //指向队列头部，分析出front指向队列头的前一个位置
        rear = -1;             //指向队列尾部，直接指向队列最后一个元素位置
    }

    //判断队列是否为满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断是否为满
        if(isFull()) {
            System.out.println("队列已满，不能添加数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //获取队列数据，出队列
    public int getQueue() {
        //判断是否为空
        if(isEmpty()) {
            //通过抛出异常  因为取出数据需要返回一个特定的值，而没有默认的值，只能直接丢异常
            throw new RuntimeException("队列空，不能取数据");  //抛出异常已经不需要return了
        }
        front++;
        return arr[front];
    }

    //显示队列所以数据
    public void show() {
        if(isEmpty()) {
            System.out.println("队列空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示头数据
    public int headQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列空，无元素");
        }
        return arr[front + 1];
    }
}

//当全部数据取出后，get方法的rear和front已经跑满，无法再次添加数据。（以此引出下面的环形数组）
//        ①不能复用；
//        ②用环形数组进行优化。