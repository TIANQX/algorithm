package com.zd.linkedlist;

import javax.sound.midi.Soundbank;

/**
 * @Author tqx
 * @CreateDate 2021/5/13
 * @Description TODO 双向链表
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero3 = new HeroNode2(3, "卢俊义", "玉麒麟");
        HeroNode2 hero5 = new HeroNode2(5, "吴用", "智多星");
        HeroNode2 hero7 = new HeroNode2(7, "林冲", "豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero5);
        doubleLinkedList.add(hero7);
        HeroNode2 hero8 = new HeroNode2(3, "88", "88");
        doubleLinkedList.update(hero8);
        doubleLinkedList.list();
        doubleLinkedList.del(7);
        System.out.println("删除后");
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * @Author tqx
     * @CreateDate 2021/5/13
     * @Description TODO 顺序增加
     * @Param Return
     */
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = getHead();

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;


    }

    /**
     * @Author tqx
     * @CreateDate 2021/5/13
     * @Description TODO 根据编号增加
     * @Param Return
     */
    public void addByOrder(HeroNode2 heroNode2) {

    }

    /**
     * @Author tqx
     * @CreateDate 2021/5/13
     * @Description TODO 打印双向链表
     * @Param Return
     */
    public void list() {

        HeroNode2 temp = head.next;
        if (temp == null) {
            System.out.println("空链表~");
            return;
        }
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }

    /**
     * @Author tqx
     * @CreateDate 2021/5/13
     * @Description TODO 根据编号更新
     * @Param Return
     */
    public void update(HeroNode2 heroNode) {
        HeroNode2 temp = getHead();
        if (temp.next == null) {
            System.out.println("空链表~");
            return;
        }
        boolean flag = false;
        while (temp.next != null) {
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.name;
        } else {
            System.out.printf("没有找到编号为%d的英雄", heroNode.no);
        }

    }

    /**
     * @Author tqx
     * @CreateDate 2021/5/13
     * @Description TODO 删除
     * @Param Return
     */
    public void del(int no) {
        HeroNode2 temp = head.next;
        if (temp == null) {
            System.out.println("空链表~");
            return;
        }
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {

            temp.pre.next = temp.next;
            //
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }

        } else {
            System.out.printf("编号为%d的英雄不存在\n", no);
        }

    }
}


class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 pre;
    public HeroNode2 next;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}