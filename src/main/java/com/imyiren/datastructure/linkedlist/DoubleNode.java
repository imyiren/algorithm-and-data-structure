package com.imyiren.datastructure.linkedlist;

/**
 * @author yiren
 */
public class DoubleNode {
    public DoubleNode pre;
    public DoubleNode next;
    public int value;

    public DoubleNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "value=" + value +
                '}';
    }
}
