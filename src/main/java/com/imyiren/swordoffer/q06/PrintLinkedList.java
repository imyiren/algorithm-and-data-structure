package com.imyiren.swordoffer.q06;

import java.util.Stack;

/**
 * @author yiren
 */
public class PrintLinkedList {
    public static void main(String[] args) {
        Node head = new Node(0);
        Node ptr = head;
        for (int i = 1; i < 10; i++) {
            ptr.next = new Node(i);
            ptr = ptr.next;
        }
        reversePrintLinkedListByStack(head);
        reversePrintLinkedListByRecursion(head.next);
    }

    /**
     * 栈实现
     * @param head
     */
    public static void reversePrintLinkedListByStack(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        Node ptr = head;

        while (null != (ptr = ptr.next)) {
            stack.push(ptr);
        }

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 递归实现
     * @param node
     */
    public static void reversePrintLinkedListByRecursion(Node node) {
        if (node == null) {
            return;
        }
        reversePrintLinkedListByRecursion(node.next);
        System.out.println(node);
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
