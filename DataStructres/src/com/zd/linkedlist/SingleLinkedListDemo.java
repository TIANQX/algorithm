package com.zd.linkedlist;

import com.sun.security.auth.NTDomainPrincipal;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author tqx
 * @CreateDate 2021/5/11
 * @Description 单向链表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {

        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero3 = new HeroNode(3, "卢俊义", "玉麒麟");
        HeroNode hero5 = new HeroNode(5, "吴用", "智多星");
        HeroNode hero7 = new HeroNode(7, "林冲", "豹子头");
        HeroNode hero2 = new HeroNode(2, "22", "22");
        HeroNode hero4 = new HeroNode(4, "44", "44");
        HeroNode hero6 = new HeroNode(6, "66", "66");
        HeroNode hero8 = new HeroNode(8, "88", "88");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        singleLinkedList.addByNo(hero1);
        singleLinkedList.addByNo(hero3);
        singleLinkedList.addByNo(hero5);
        singleLinkedList.addByNo(hero7);
        singleLinkedList2.addByNo(hero2);
        singleLinkedList2.addByNo(hero4);
        singleLinkedList2.addByNo(hero6);
        singleLinkedList2.addByNo(hero8);
   /*     HeroNode hero5 = new HeroNode(4, "林", "豹子头~");
        singleLinkedList.update(hero5);
        singleLinkedList.list();
        System.out.println("删除后");
        singleLinkedList.del(4);
        singleLinkedList.list();
        singleLinkedList.getHead();
        System.out.printf("链表长度为%d", getLength(singleLinkedList.getHead()));
        System.out.println("倒数第二个节点");
        System.out.println(getLastIndexNode(singleLinkedList.getHead(), 2));
        System.out.println("逆序打印：栈，没有改变链表的结构");
        reversePrint(singleLinkedList.getHead());

        System.out.println("单链表反转");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();*/
        singleLinkedList.list();
        singleLinkedList2.list();
        mergeLinkedList(singleLinkedList.getHead(), singleLinkedList2.getHead());
        System.out.println("合并之后打印");
        singleLinkedList.list();

    }

    public static int getLength(HeroNode head) {
        HeroNode temp = head;
        if (head.next == null) {
            return 0;
        }
        int count = 0;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * @Author tqx
     * @CreateDate 2021/5/13
     * @Description TODO 查找单链表中倒数第K个节点
     * @Param Return
     */

    public static HeroNode getLastIndexNode(HeroNode head, int index) {
        //判断链表是否为空
        if (head.next == null) {
            return null;
        }
        //获取单链表的长度  size-index  得到节点的位置
        int size = getLength(head);
        //索引值超过链表长度
        if (index < 0 || index > size) {
            return null;
        }
        //定义辅助变量，for循环定位到倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * @Author tqx
     * @CreateDate 2021/5/13
     * @Description TODO 方法2利用栈，将各个节点压入栈中，然后利用栈的先进后出特点实现逆序打印效果
     * @Param Return
     */
    public static void reversePrint(HeroNode head) {
        //先判断头节点是否为空
        if (head.next == null) {
            return;
        }
        //创建栈，将节点压栈
        Stack<HeroNode> heroNodeStack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            heroNodeStack.push(cur);
            cur = cur.next;
        }
        //将栈中的节点打印pop
        while (heroNodeStack.size() > 0) {
            System.out.println(heroNodeStack.pop());
        }
    }


    /**
     * @Author tqx
     * @CreateDate 2021/5/13
     * @Description TODO 单链表反转
     * @Param Return
     */
    public static void reverseList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }

        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null) {

            next = cur.next;  //先保存当前节点的下一个节点
            cur.next = reverseHead.next;//将当前节点的下一个节点指向新链表的最前端
            reverseHead.next = cur;//将cur连接到新的链表上
            cur = next;//将cur后移
        }
        //将head.next指向reverseHead.next实现单链表的反转
        head.next = reverseHead.next;


    }

    /**
     * @Author tqx
     * @CreateDate 2021/5/13
     * @Description TODO 合并两个有序的单链表，合并之后依然有序
     * @Param Return
     */
    public static void mergeLinkedList(HeroNode head1, HeroNode head2) {
        //head2合并到head1中
        HeroNode cur1 = head1.next;
        HeroNode cur2 = head2.next;
        HeroNode next1 = null;
        HeroNode next2 = null;
        HeroNode temp1 = null;
        HeroNode temp2 = null;
        if (head1.next == null) {

        }
        while (cur1.next != null) {
            //比较no大小将
            if (cur1.next.no > cur2.next.no) {
                cur1 = cur1.next;
                break;
            }else{

            }

        }
        //1.将cur2.next存入临时
        temp2 = cur2.next;
        //2.将cur2.next指向cur2.next.next
        cur2.next = cur2.next.next;
        //3.temp2.next指向cur1.next.next
        temp2.next = cur1.next.next;
        cur1.next = temp2;
        cur2 = cur2.next;


    }
}

class SingleLinkedList {
    //初始化head
    private HeroNode head = new HeroNode(0, "", "");


    //返回头结点
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //当不考虑顺序时
    //1.找到当前链表的最后节点
    //2.将最后节点的next指向新的节点
    //按照添加的顺序
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = getHead();
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        //当退出循环后，temp执行链表的最后
        //将最后节点指向新增的几点
        temp.next = heroNode;
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示)
    public void addByNo(HeroNode heroNode) {
        //因为head节点不能动，因此需要通过一个辅助指针（变量）来帮助找到添加的位置
        HeroNode temp = head;
        //
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;//空链表
            }
            if (temp.next.no > heroNode.no) {//下一个节点比要插入的英雄编号大，添加到此处
                break;
            } else if (temp.next.no == heroNode.no) {//此编号的英雄已经存在
                flag = true;
                break;
            }
            temp = temp.next;//后移
        }
        //
        if (flag) {
            System.out.printf("当前编号的英雄%d已存在不能插入\n", heroNode.no);
        } else {
            //插入到链表中, temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;

        }


    }


    public void update(HeroNode heroNode) {
        HeroNode temp = head.next;
        if (temp == null) {
            System.out.println("空链表");
            return;
        }
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.NickName = heroNode.NickName;
        } else {
            System.out.printf("没有找到编号为%d的英雄", heroNode.no);
        }

    }

    /**
     * @Author tqx
     * @CreateDate 2021/5/12
     * @Description TODO 根据编号删除节点
     * @Param Return
     */
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("删除的节点%d不存在", no);
        }
    }

    /**
     * @Author tqx
     * @CreateDate 2021/5/12
     * @Description TODO 获取链表长度
     * @Param Return
     */
    public int getLength2() {
        HeroNode temp = getHead();
        int count = 0;
        while (true) {
            if (temp.next == null) {
                break;
            }
            count++;
            temp = temp.next;
        }
        return count;
    }


    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为head节点不能动，需要辅助变量temp
        HeroNode temp = head.next;

        while (true) {
            //判断是否到节点的最后
            if (temp == null) {
                break;
            }
            //输出节点后要将节点后移
            System.out.println(temp);
            //要将节点后移，注意！！！！！！
            temp = temp.next;

        }

    }


}

class HeroNode {
    public int no;
    public String name;
    public String NickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        NickName = nickName;

    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", NickName='" + NickName + '\'' +

                '}';
    }
}