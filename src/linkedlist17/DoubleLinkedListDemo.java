package linkedlist17;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        //创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();
        System.out.println();

        //修改
        HeroNode2 newHeroNode2 = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode2);

        doubleLinkedList.list();
        System.out.println();

        //删除
        doubleLinkedList.del(3);

        doubleLinkedList.list();
        System.out.println();

        //插入
        HeroNode2 hero5 = new HeroNode2(3, "公孙离", "阿巴");
        doubleLinkedList.addByOrder(hero5);

        doubleLinkedList.list();
        System.out.println();
    }
}

//创建一个双向链表的类
class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");   //先初始化头结点，且使其不动

    public HeroNode2 getHead() {
        return head;
    }     //返回头结点

    public void add(HeroNode2 heroNode2) {
        HeroNode2 temp = head;      //因head不动（用于遍历），故需一辅助变量temp
        //遍历找到最后节点
        while(temp.next != null) {
            temp = temp.next;
        }   //当退出while循环时，temp就指向链表的最后
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }    //默认添加到最后一个位置（与单链表相比，需指向前一个）

    public void addByOrder(HeroNode2 heroNode2) {
        HeroNode2 temp = head;     //因头结点不动，仍通过辅助变量temp操作
        boolean flag = false;      //标志编号是否存在，默认false
        while(temp.next != null) {
            if(temp.next.no > heroNode2.no) {  //若true，则位置就在temp之后
                break;
            } else if(temp.next.no == heroNode2.no) {    //编号已经存在
                flag = true;      //说明编号存在
                break;
            }
            temp = temp.next;     //后移
        }
        //判断flag值
        if(flag) {
            System.out.printf("插入英雄编号%d已存在，不能加入", heroNode2.no);
        } else {   //插入
            heroNode2.next = temp.next;
            heroNode2.pre = temp;
            if(temp.next != null) {    //如果插入最后一个位置，那么不需要下一个回指（null当然没有pre）
                temp.next.pre = heroNode2;
            }
            temp.next = heroNode2;
        }
    }  //第二种添加方式，根据排名将英雄插入到指定位置

    public void update(HeroNode2 newHeroNode2) {
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }   //判断是否为空

        //找到要修改的节点
        HeroNode2 temp = head.next;
        boolean flag = false;     //是否找到该节点
        while(temp != null) {
            if(temp.no == newHeroNode2.no) {   //需要判断最后一个符不符合，所以前面一个判断不能temp.next == null
                flag = true;                                             //判断完了再，跑break
                break;
            }
            temp = temp.next;
        }

        if(flag) {   //根据flag判断
            temp.name = newHeroNode2.name;
            temp.nickname = newHeroNode2.nickname;
        } else {
            System.out.printf("没有找到编号 %d 的节点\n", newHeroNode2.no);
        }
    }  //修改节点信息（双向链表与单链表相同）

    public void del(int no) {
        if(head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;
        while(temp != null) {
            if(temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            temp.pre.next = temp.next;   //删除节点前一位的next指向其的next
            if(temp.next != null) {        //若是最后一个位置的节点，自然不需要pre(因为也没有)  【细节】
                temp.next.pre = temp.pre;    //删除节点后一位的pre指向其的pre
            }
        } else {
            System.out.printf("没有编号%d的节点\n", no);
        }
    }      //删除 （注意删最后一个节点，不需pre回指）

    public void list() {
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while(temp != null) {
            System.out.println(temp);  //输出节点信息
            temp = temp.next;          //后移
        }
    }  //显示链表[遍历]     头结点不能动，故也需辅助变量遍历（双向链表可以用尾节点与pre遍历）
}

//创建HeroNode2类，每个HeroNode2对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;  //指向下一个节点，默认null
    public HeroNode2 pre;   //指向上一个节点，默认null

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +      //因为next会一直指向下一个next，为了打印清晰，去掉next的打印输出
                "no=" + no +      //pre同理
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '}';
    }
}