package io.ilss.datastructure.queue;

import java.util.Scanner;

/**
 * @author feng
 */
public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空， 没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d \n", i, arr[i]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front + 1];
    }

    public static void main(String[] args) {
        // 初始化一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
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
