package com.imyiren.datastructure.linkedlist;

/**
 * @author feng
 */
public class SingleNode {
    public int value;
    public SingleNode next;

    public SingleNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SingleNode{" +
                "value=" + value +
                '}';
    }
}
