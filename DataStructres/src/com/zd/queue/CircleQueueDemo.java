package com.zd.queue;

import java.util.Scanner;

/**
 * @Author tqx
 * @CreateDate 2021/5/8
 * @Description 环形数组模拟队列
 */
public class CircleQueueDemo {
    public static void main(String[] args) {
        // 创建队列
        CircleArrayQueue queue = new CircleArrayQueue(4);//有一个预留空间
        // 接收用户输入的值
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        // 输出菜单
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中取数据");
            System.out.println("h(head):查看队列头数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    try {
                        queue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
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

class CircleArrayQueue {
    private int rear;
    private int front;
    private int maxSize;
    private int[] arr;

    public CircleArrayQueue(int arrayMaxSize) {
//        this.rear = 0;
//        this.front = 0;
        maxSize = arrayMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否已满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        //将rear后移，必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //获取队列中的数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        //这里需要分析出front是指向队列的第一元素
        //1.先把front对应的值保留到一个临时变量 中
        //2.将front后移，考虑取模
        //将临时变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列中的所有数据
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        //思路：从front开始遍历，遍历多少个元素
        //动脑筋
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }

    }

    //求出当前队列有效数据的个数
    public int size() {
        //rear=2
        //front=1
        //maxSize=4
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据（注意不是取出数据）
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        return arr[front];
    }
}
