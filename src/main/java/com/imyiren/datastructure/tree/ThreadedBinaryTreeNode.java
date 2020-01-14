package com.imyiren.datastructure.tree;

/**
 * @author feng
 */
public class ThreadedBinaryTreeNode {
    public int value;
    public ThreadedBinaryTreeNode left;
    public ThreadedBinaryTreeNode right;
    public boolean isLeftThreaded = false;
    public boolean isRightThreaded = false;

    public ThreadedBinaryTreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ThreadedBinaryTreeNode{" +
                "value=" + value +
                ", isLeftThreaded=" + isLeftThreaded +
                ", isRightThreaded=" + isRightThreaded +
                '}';
    }
}
