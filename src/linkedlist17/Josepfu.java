package linkedlist17;

public class Josepfu {
    public static void main(String[] args) {
        //测试
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);    //加入5个小孩
        circleSingleLinkedList.showBoy();

        //测试出圈
        circleSingleLinkedList.countBoy(1, 2, 5);

    }
}

//创建一个环形单向链表
class CircleSingleLinkedList {
    //创建一个first节点，当前无编号
    private Boy first = new Boy(-1);
    //添加小孩节点，构成环形链表
    public void addBoy(int nums) {
        //nums 做一个数据校验
        if(nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;       //辅助指针，帮助构建环形链表
        //使用for循环来创建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号，创建小孩节点
            Boy boy = new Boy(i);
            //若为第一个小孩
            if(i == 1) {
                first = boy;
                boy.setNext(boy);   //构成环
            } else {
                boy.setNext(first);
                curBoy.setNext(boy);
            }
            curBoy = boy; //后移
        }
    }

    //遍历当前环形链表
    public void showBoy() {
        //判断链表是否为空
        if(first == null) {
            System.out.println("没小孩");
            return;
        }
        Boy curBoy = first;  //因为first不动，需辅助指针
        do {
            System.out.printf("%d号小孩\n", curBoy.getNo());
            curBoy = curBoy.getNext();    //后移
        } while(curBoy.getNext() != first.getNext());
    }

    //根据用户输入，计算小孩出圈顺序
    /**
     *
     * @param startNo  表示从第几个小孩开始数
     * @param countNum 表示数几下
     * @param nums     表示最初有几个小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据校验
        if(first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误");
            return;
        }
        //创建要给辅助指针（变量）helper，帮助小孩出圈
        Boy helper = first;
        //事项先应指向环形链表的最后这个节点
        while(helper.getNext() != first) {
            helper = helper.getNext();
        }
        //小孩报数前，先让first和helper移动 k - 1 次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //小孩报数时，让first和helper指针同时移动 m - 1 次后出圈
        //当圈中只有一个节点时，输出并退出循环
        while(helper != first) {
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //此时first指向节点就是待出圈的节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("圈中最后的小孩%d\n", first.getNo());
    }
}


//创建一个Boy类，表示一个节点
class Boy {
    private int no;
    private Boy next;
    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}