package linkedlist17;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        //入栈
        stack.add("1");
        stack.add("22");
        stack.add("333");
        while (stack.size() > 0) {
            System.out.println(stack.pop());         //pop就是将栈顶的数据取出
        }
//        System.out.println(stack.size());
//        for (int i = 0; i < stack.size(); i++) {
//            System.out.println(stack.pop());      //pop就是将栈顶的数据取出，此时stack的size也会随着减少
//        }
    }
}
