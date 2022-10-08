package stack31;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        while (loop) {
            System.out.println("show");
            System.out.println("exit");
            System.out.println("push");
            System.out.println("pop");
            System.out.println("please input your selection:");
            key = sc.next();
            switch (key) {
                case "show":
                    arrayStack.list();
                    break;
                case "exit":
                    sc.close();
                    loop = false;    //终止循环
                    break;
                case "push":
                    System.out.println("输入一个数");
                    int value = sc.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = arrayStack.pop();
                        System.out.println(res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
            }
        }

        System.out.println("程序结束");
    }
}
class ArrayStack {
    private int maxSize;   //栈的大小
    private int[] stack;   //数组模拟栈，将数据放入栈中
    private int top = -1;  //栈顶，初始化-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

//    栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

//    栈空
    public boolean isEmpty() {
        return top == -1;
    }

//    入栈
    public void push(int value) {
        if (isFull()) return;
        stack[++top] = value;
    }

//    出栈
    public int pop() {
        if (isEmpty()) throw new RuntimeException("栈为空，没有数据可以取出");
        return stack[top--];
    }

//    显示栈的情况[遍历栈]
    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空，没有数据");
            return;
        }
        /*  for循环的辅助变量i更简单一点
        int temp = top;
        while (top >= 0) {
            System.out.println(stack[top--]);
        }
        top = temp;
         */
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
/*
int top = -1;
int[] arr = new int[5];
for (int i = 0; i < 5; i++) {
    arr[++top] = i;
}
while (top >= 0) {
    System.out.println(arr[top--]);
}
 */