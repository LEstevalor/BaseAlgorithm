package queue12;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        //测试
        CircleArray queue = new CircleArray(3);
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

class CircleArray {
    private int maxSize;   //表示数组最大容量
    //front变量含义调整，front指向队列元素，初始值0
    private int front;     //队列头
    //rear变量含义调整，rear指向最后一个元素的后一个位置  （front和rear位置的调整只是相对于 调后了一位）
    private int rear;      //队列尾
    private int[] arr;     //用于存放数据，模拟队列

    //创建队列的构造器
    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断队列是否为满
    public boolean isFull() {
        return (rear + 1) % maxSize == front; //预留一个位置，区分满和空
    }

    //判断队列是否为空(不变)
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
        arr[rear] = n;
        rear = (rear + 1) % maxSize;        //多空了一个数据出来
    }

    //获取队列数据，出队列
    public int getQueue() {
        //判断是否为空
        if(isEmpty()) {
            //通过抛出异常  因为取出数据需要返回一个特定的值，而没有默认的值，只能直接丢异常
            throw new RuntimeException("队列空，不能取数据");  //抛出异常已经不需要return了
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列所以数据
    public void show() {
        if(isEmpty()) {
            System.out.println("队列空");
            return;
        }
        //改进
        //从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前对队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;  //rear<maxSize时与>时
    }

    //显示头数据
    public int headQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列空，无元素");
        }
        return arr[front];
    }
}