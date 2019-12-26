package io.ilss.datastructure.stack;

/**
 * 数组实现栈
 *
 * @author feng
 */
public class ArrayStack implements Stack {
    private int top;
    private int[] stack;
    private int maxSize;


    public ArrayStack(int maxSize) {
        this.top = -1;
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    @Override
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        stack[++top] = value;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top--];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[this.top];
    }

    @Override
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        System.out.print("stack: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack stack = new ArrayStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.list();

        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        stack.list();
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());


    }
}
