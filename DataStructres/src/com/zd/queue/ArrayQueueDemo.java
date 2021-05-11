package com.zd.queue;

import java.util.Scanner;

/**
 * @Author tqx
 * @CreateDate 2021/5/8
 * @Description 数组模拟队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        // 创建队列
        ArrayQueue queue = new ArrayQueue(3);
        // 接收用户输入的值
        char key=' ';
        Scanner scanner=new Scanner(System.in);
        // 输出菜单
        boolean loop=true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中取数据");
            System.out.println("h(head):查看队列头数据");
            key=scanner.next().charAt(0);
            switch (key){
                case 's':
                    try {
                        queue.showQueue();
                    }catch (Exception e ){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int value=scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }


}

class ArrayQueue {
    private int rear;
    private int front;
    private int maxSize;
    private int[] arr;

    public ArrayQueue(int arrayMaxSize) {
        rear = -1;
        front = -1;
        maxSize = arrayMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否已满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能添加数据");
            return;
        }
        rear++;
        arr[rear] = n;

    }

    //获取队列中的数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列中的所有数据
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头数据（注意不是取出数据）
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        return arr[front++];
    }
}
