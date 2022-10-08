package stack31;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //先定义一个逆波兰表达式
        //(3+4)×5-6 =>  3 4 + 5 × 6 -  == 29
        //说明为了方便，逆波兰表达式 的数字和符号使用空格隔开
        String suffixExpression = "3 4 + 5 × 6 -";
        //思路
        //1、先将"3 4 + 5 * 6 -"放入ArrayList
        //2、将ArrayList 传递一个方法，遍历ArrayList 配合栈 完成计算

        List<String> rpnList = getListString(suffixExpression);
        System.out.println(rpnList);     //[3, 4, +, 5, *, 6, -]
        System.out.println(calculate(rpnList));

        //测试：
        //(3+4)×5-16 =>  3 4 + 5 × 16 -  == 19
        System.out.println(calculate(getListString("3 4 + 5 × 16 -")));
    }

    //将一个逆波兰表达式，依次将数据和运算符放入 ArrayList 【不用去扫描了】
    public static List<String> getListString(String suffixExpression) {
        //将suffixExpression分隔
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
    public static int calculate(List<String> ls) {
        //创建栈，只需要一个栈
        Stack<String> stack = new Stack<String>();
        //遍历
        for (String item : ls) {
            //使用正则表达式来取出值
            if (item.matches("\\d+")) {   //匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                //pop弹出两个数，并运算后再入栈
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num2 - num1;
                } else if (item.equals("×")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num2 / num1;
                } else {
                    throw new RuntimeException("运算符错误");
                }
                //把结果res入栈
                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.pop());   //栈中最后的数字即为最后结果
    }
}
