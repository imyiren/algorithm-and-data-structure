package io.ilss.datastructure.stack;

import io.ilss.datastructure.linkedlist.SingleNode;

/**
 * @author feng
 */
public class LinkedStack implements Stack {
    public SingleNode top;

    public LinkedStack() {
        this.top = new SingleNode(0);
    }

    @Override
    public void push(int value) {
        SingleNode node = new SingleNode(value);
        node.next = this.top.next;
        this.top.next = node;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        SingleNode temp = this.top.next;
        this.top.next = temp.next;
        return temp.value;
    }

    @Override
    public boolean isEmpty() {
        return this.top.next == null;
    }

    @Override
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        SingleNode temp = this.top.next;
        System.out.print("stack: ");
        while (null != temp) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    @Override
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return this.top.next.value;
    }

    public static void main(String[] args) {
        Stack stack = new LinkedStack();
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
        System.out.println("pop: " + stack.pop());


    }

}
