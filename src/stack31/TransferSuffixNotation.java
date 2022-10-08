package stack31;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings({"all"})
public class TransferSuffixNotation {
    public static void main(String[] args) {
        //完成一个中缀表达式转成后缀表达式的功能
        //说明
        //1、 1+((2+3)×4)-5  ==>  1 2 3 + 4 × + 5 -
        //2、因直接对str操作不便，故先将其化为对应的list （借鉴PolandNotation中写的方法）
        //3、将得到的中缀表达式对应的list ==> 后缀表达式对应的List
        //   即[1, +, (, (, 2, +, 3, ), ×, 4, ), -, 5]  ==>  [1 2 3 + 4 × + 5 -]

        String str0 = "1 + ( ( 2 + 3 ) × 4 ) - 5";    //这是有空格的，但是对于一般没有空格间隔的中缀表达式，是用不了split的
        System.out.println(haveEmptyToInfixExpressionList(str0));

        String str = "1+((2+3)×4)-5";
        List<String> ls = toInfixExpressionList(str);
        System.out.println(ls);

        System.out.println(parseSuffixExpression(ls));
    }

    //方法：将得到的中缀表达式对应的list ==> 后缀表达式对应的List
    public static List<String> parseSuffixExpression(List<String> ls) {
        //定义两个栈
//        Stack<String> stackRes = new Stack<String>();   //不能pop操作，而且最后需要逆序输出结果
        List<String> stackRes = new ArrayList<String>();
        //关于逆序输出——两种方案：（1）最后全部pop到StackSym，由StackSym输出；（2）stackRes用new ArrayList<String>()。
        Stack<String> stackSym = new Stack<String>();
        for (String str : ls) {
            if(str.matches("\\d+")) {
                stackRes.add(str);     //数字直接入栈
            } else if (str.equals("(")) {
                stackSym.push(str);
            } else if (str.equals(")")) {
                while (!stackSym.peek().equals("(")) stackRes.add(stackSym.pop());
                stackSym.pop();    //弹出最后的“(”
            } else {    //peek()是Stack中查看栈顶数据的方法
                while (stackSym.size() != 0 && Operation.getValue(stackSym.peek()) >= Operation.getValue(str)) {
                    stackRes.add(stackSym.pop());
                }
                stackSym.push(str);
            }
        }

        //将剩余的运算符放入StackRes
        while (stackSym.size() != 0) {
            stackRes.add(stackSym.pop());
        }

        return stackRes;
    }

    //方法：将中缀表达式转成对应的list（对于一般的中缀表达式）
    public static List<String> toInfixExpressionList(String s) {
        List<String> ls = new ArrayList<String>();
        int i = 0;   //这是一个指针，用于遍历
        String str;  //多位数的拼接
        char c;      //遍历每一个字符的放入
        do {
            //如果c为非数字，需加入到ls
            if((c = s.charAt(i)) < '0' || (c = s.charAt(i)) > '9') {
                ls.add("" + c);   //"" + char变成String类型
                i++;
            } else {    //如果c为数字，需考虑多位数
                str = "";   //即符合了第一次使用，而且每次加入就回到原状态（不会导致叠加错误）
                while(i < s.length() && (c = s.charAt(i)) >= '0' && (c = s.charAt(i)) <= '9') {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        } while(i < s.length());

        return ls;
    }

    //方法：将中缀表达式转成对应的list （制造了间隔空格才能这么搞）（否则用不了split）
    public static List<String> haveEmptyToInfixExpressionList(String s) {
        List<String> ls = new ArrayList<String>();
        String[] split = s.split(" ");
        for (String ss : split) {
            ls.add(ss);
        }
        return ls;
    }
}
//编写一个类Operation，可以返回一个运算符的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //下一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+" :
                result = ADD;
                break;
            case "-" :
                result = SUB;
                break;
            case "×" :
                result = MUL;
                break;
            case "/" :
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}
