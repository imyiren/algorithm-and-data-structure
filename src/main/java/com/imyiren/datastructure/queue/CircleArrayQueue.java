package com.imyiren.datastructure.queue;

import java.util.Scanner;

/**
 * @author yiren
 */
public class CircleArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        int value = arr[front];

        // 讲front后移
        front = (front + 1) % maxSize;

        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空， 没有数据");
            return;
        }
        // 从front开始遍历，遍历

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d \n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }


    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }

    public static void main(String[] args) {
// 初始化一个队列
        CircleArrayQueue arrayQueue = new CircleArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(show):添加数据");
            System.out.println("g(get ):取出数据");
            System.out.println("h(head):查看队头");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    loop = false;
                    scanner.close();
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        System.out.println("取出一个值：" + arrayQueue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("显示队列头值：" + arrayQueue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
            System.out.println("===================");
        }
        System.out.println("程序退出");
    }
}
