package linkedlist17;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //test
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        /*
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
         */

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);  //效果与上面相同

        //显示
        singleLinkedList.list();
        System.out.println();

        //测试修改
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);

        //显示
        singleLinkedList.list();
        System.out.println();

        //删除
        singleLinkedList.del(4);
        singleLinkedList.list();
        System.out.println();

        System.out.println(getLength(singleLinkedList.getHead()));
        System.out.println();

        researchK(singleLinkedList.getHead(), 2);
        System.out.println();

        reverse(singleLinkedList.getHead());
        singleLinkedList.list();
        System.out.println();

        reverseList0(singleLinkedList.getHead());
        singleLinkedList.list();
        System.out.println();

        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();
        System.out.println();

        reversePrint(singleLinkedList.getHead());

    }

    //从尾到头打印单链表【百度】
    //1、反转是一个方法（但会破坏原结构）
    //2、能用循环少用递归
    //3、栈：利用先进后出的特性，实现逆打印
    public static void reversePrint(HeroNode head) {
        if(head.next == null) {
            return;        //空链表不打印
        }
        //创建一个栈，将各个节点压入栈中，再弹出
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;   //后移
        }
        //将栈中结点打印出来即可
        while(stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    @SuppressWarnings({"all"})
    //单链表的反转【腾讯面试题】
    //思路1：做完必要判断后，用一个tempIt要在遍历，把每一个节点的next给它
           //用temp1赋予原本的tempIt充当每一个节点
           //temp2记录上一个节点
    public static void reverse(HeroNode head) {
        HeroNode tempIt = head.next;       //用于遍历
        HeroNode temp1;                    //辅助节点next的赋值
        HeroNode temp2 = head;             //存放遍历位置的前一个节点数据
        if(tempIt == null) {
            System.out.println("链表为空");
            return;
        }
        while(true) {
            if(tempIt == null) {   //只有一个元素直接返回
                break;
            }
            temp1 = tempIt;        //temp1充当当前位置节点
            tempIt = temp1.next;   //后移，记录原来下一个节点信息
            if(temp1 == head.next) {   //反转第一个元素
                temp1.next = null;     //最后一个元素指向null
            } else {
                if(tempIt == null) {   //说明是原本的最后一个节点
                    head.next = temp1; //头节点指向原本最后一个节点
                }
                temp1.next = temp2;    //指向原来前一个位置
            }
            temp2 = temp1;             //保存当前位置的节点信息（给下一个位置使用）
        }
    }
    //思路2：从头到尾每遍历一个节点就取出，放到新链表头reverseHead的最前端
    public static void reverseList0(HeroNode head) {
        //链表为空或仅有一个，直接返回即可
        if(head.next == null || head.next.next == null) {
            return;
        }
        HeroNode temp = head.next;
        HeroNode temp1;     //辅助变量（用于存储temp.next，以进行遍历）
        HeroNode reverseHead = head;
        while(temp != null) {
            temp1 = temp.next;
            temp.next = (temp == head.next)? null : reverseHead.next;
//            if (temp == head.next) {
//                temp.next = null;
//            } else {
//                temp.next = reverseHead.next;
//            }
            reverseHead.next = temp;     //不需再指定头结点了，reverseHead已经是了
            temp = temp1;
        }
    }
    //思路3：从头到尾每遍历一个节点就取出，放到新链表reverseHead的最前端
    public static void reverseList(HeroNode head) {
        if(head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");

        while(cur != null) {  //交换
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    //查找单链表中的倒数第k个结点【新浪面试题】
    public static void researchK (HeroNode head, int k) {   //返回节点也行，返回类型改为HeroNode对象即可
        HeroNode temp = head;
        int len = getLength(head);
        int num = 0;
        if(len == 0) {
            System.out.println("链表为空");
            return;
        }
        if(k > len || k <= 0) {
            System.out.println("没有此倒数序号结点");
            return;
        }
        while(true) {
            temp = temp.next;
            if(num == len - k) {   //没有倒数第0个这种说法
                break;
            } else {
                num++;
            }
        }
        System.out.println(temp);
    }

    //方法：获取单链表的节点个数（若是带头结点的链表，需求不统计头结点）
    /**
     *
     * @param head 链表的头结点
     * @return 返回的是单链表的有效节点个数
     */
    public static int getLength(HeroNode head) {
        int len = 0;
        HeroNode temp = head;
        while(true) {
            if(temp.next == null) {
                break;
            } else { len++; }
            temp = temp.next;
        }
        return len;
    }

}

//定义SingleLinkedList管理英雄
class SingleLinkedList {
    //先初始化头结点，且使其不动
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;        //返回头结点
    }

    //添加节点到单向链表
    //思路：不考虑编号顺序，找到当前最后节点，将最后节点的next指向新节点
    public void add(HeroNode heroNode) {
        //因head不可动（用于遍历），故需一辅助变量temp
        HeroNode temp = head;
        //遍历找到最后节点
        while(true) {                //改进while(temp.next != null) {temp = temp.next;}
            if(temp.next == null) {
                break;
            }
            //如果没有找到最后,一直将temp移到最后
            temp = temp.next;
        }   //当退出while循环时，temp就指向链表的最后
        temp.next = heroNode;
    }

    //第二种添加方式，根据排名将英雄插入到指定位置
    // （如果已经有这个排名，则添加失败，并给出提示）
    public void addByOrder(HeroNode heroNode) {
        //因为头结点不能动，仍然通过赋值变量temp操作
        //因为是单链表，故只能加到添加位置的前一个节点，否则无法插入
        HeroNode temp = head;
        boolean flag = false;      //标志编号是否存在，默认false
        while(true) {
            if(temp.next == null) {   //到最后一个节点
                break;
            }
            if(temp.next.no > heroNode.no) {  //若true，则位置就在temp之后
                break;
            } else if(temp.next.no == heroNode.no) {    //编号已经存在
                flag = true;      //说明编号存在
                break;
            }
            temp = temp.next;     //后移
        }
        //判断flag值
        if(flag) {
            System.out.printf("插入英雄编号%d已存在，不能加入", heroNode.no);
        } else {   //插入
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点信息，根据no编号修改，即no编号不能改
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到要修改的节点
        HeroNode temp = head.next;
        boolean flag = false;     //是否找到该节点
        while(true) {
            if(temp == null) {
                break;  //遍历结束
            }
            if(temp.no == newHeroNode.no) {   //需要判断最后一个符不符合，所以前面一个判断不能temp.next == null
                flag = true;                                             //判断完了再，跑break
                break;
            }
            temp = temp.next;
        }
        //根据flag判断
        if(flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号 %d 的节点\n", newHeroNode.no);
        }
    }

    //删除节点
    public void del(int no) {

        HeroNode temp = head;
        boolean flag = false;
        while(temp.next != null) {
            if(temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("没有编号%d的节点\n", no);
        }
    }

    //显示链表[遍历]            头结点不能动，故也需辅助变量遍历
    public void list() {
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while(true) {
            //判断是否到链表最后
            if(temp == null) {
                break;
            }
            System.out.println(temp);  //输出节点信息
            temp = temp.next;          //后移
        }
    }

}

//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;  //指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '}';
        //因为next会一直指向下一个next，为了打印清晰，去掉next的打印输出
    }
}