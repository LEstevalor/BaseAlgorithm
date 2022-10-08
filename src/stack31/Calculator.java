package stack31;

public class Calculator {
    public static void main(String[] args) {
        String expression = "3+2*6-12";
        //创建两个栈 —— 数栈 & 符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //用于扫描
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';     //每次扫描的char保存到ch中
        String keepNum = ""; //用于拼接多位数
        //开始循环扫描
        while (index < expression.length()) {
            ch = expression.charAt(index++);  //substring(index, 1 + index++)也可以
            //判断ch是操作符否
            if (operStack.isOper(ch)) {
                //判断符号栈是否为空
                if(!operStack.isEmpty()) {
                    //如果符号栈有操作符，比较优先级，若小于等于原操作符，先计算原的再放入，否则做当前计算后再放入
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //运算的结果放入数栈
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    //如果符号栈无操作符，直接入栈
                    operStack.push(ch);
                }
            } else {   //如果是数
                //不能发现一个数就立即入栈，因为可能是多位数
//                numStack.push(ch - '0');  //'1' -> 1     //一位数运算到多位数运算↓
                //处理多位数↓，直至下一位是符号位或没有数字了
                keepNum += ch;
                if(index == expression.length() || operStack.isOper(expression.charAt(index))) {
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum = "";   //每次计算后都需清空，否则一直叠加
                }
            }
        }

        //扫描完毕后顺序运行
        while (!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }

        System.out.printf("表达式%s = %d\n", expression, numStack.pop());  //结果数在弹出的那个位置（二个数中最后push进去的）
    }
}
//创建一个栈
//在原先ArrayStackDemo中写好的ArrayStack基础上定义ArrayStack2
class ArrayStack2 {
    private int maxSize;   //栈的大小
    private int[] stack;   //数组模拟栈，将数据放入栈中
    private int top = -1;  //栈顶，初始化-1

    public ArrayStack2(int maxSize) {
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
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }


    //    返回运算符的优先级，优先级是由程序员确定，这里用数字表示（数字越大，则优先级越高）
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;      //假定目前的运算符只有+ - * /
        }
    }

    //     判断是否为一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //     计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;   //存放计算结果
        switch (oper) {
            case '+':
                res = num2 + num1;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    //     可以返回栈顶的值，但不是真正的pop -> 不会弹出，只是get
    public int peek() {
        return stack[top];
    }
}