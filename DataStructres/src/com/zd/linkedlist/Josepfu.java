package com.zd.linkedlist;

import javax.sound.midi.Soundbank;

/**
 * @Author tqx
 * @CreateDate 2021/5/14
 * @Description TODO
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.show();
        //测试一把小孩出圈是否正确
        circleSingleLinkedList.countBoy(1, 2, 5); // 2->4->1->5->3
    }
}

class CircleSingleLinkedList {
    Boy first = null;

    public CircleSingleLinkedList() {

    }

    public CircleSingleLinkedList(Boy first) {
        this.first = first;
    }

    public void add(int nums) {
        if (nums < 1) {
            System.out.println();
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void show() {
        if (first == null) {
            System.out.println();
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("编号%d\n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }

    }

    /**
     * @Author tqx
     * @CreateDate 2021/5/17
     * @Description TODO 根据用户的输入，计算出小孩出圈的顺序
     * @Param startNo  表示从第几个小孩开始数数
     * @Param countNum 表示数几下
     * @Param nums  表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (startNo < 1 || startNo > nums || first == null) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        // 创建要给辅助指针,帮助完成小孩出圈
        Boy helper = first;

        // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();

        }
        //小孩报数前，先让 first 和  helper 移动 k - 1次
        for(int j=0;j<startNo-1;j++){
            first=first.getNext();
            helper=helper.getNext();

        }
        //当小孩报数时，让first 和 helper 指针同时 的移动  m  - 1 次, 然后出圈
        //这里是一个循环操作，知道圈中只有一个节点
        while (true){
            if(helper==first){  //说明圈中只有一个节点
                break;
            }
            //让 first 和 helper 指针同时 的移动 countNum - 1
            for(int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //这时将first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first); //
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());
    }


}

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
