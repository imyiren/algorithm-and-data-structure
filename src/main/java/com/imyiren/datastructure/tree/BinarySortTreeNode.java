package com.imyiren.datastructure.tree;

/**
 * @author feng
 */
public class BinarySortTreeNode {
    public int value;
    public BinarySortTreeNode left;
    public BinarySortTreeNode right;


    public BinarySortTreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BinarySortTreeNode{" +
                "value=" + value +
                '}';
    }
}
