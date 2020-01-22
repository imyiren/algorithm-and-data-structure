package com.imyiren.datastructure.tree;

/**
 * @author yiren
 */
public class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    private void preOrder() {
        preOrder(0);
    }

    private void preOrder(int index) {
        if (null == arr || arr.length == 0) {
            System.out.println("树为空！");
            return;
        }
        System.out.println(arr[index]);

        int next;
        if ((next = 2 * index + 1) < arr.length) {
            preOrder(next);
        }
        if ((next = 2 * index + 2) < arr.length) {
            preOrder(next);
        }
    }

    private void infixOrder() {
        infixOrder(0);
    }

    private void infixOrder(int index) {
        if (null == arr || arr.length == 0) {
            System.out.println("树为空！");
            return;
        }
        int next;
        if ((next = 2 * index + 1) < arr.length) {
            infixOrder(next);
        }
        System.out.println(arr[index]);
        if ((next = 2 * index + 2) < arr.length) {
            infixOrder(next);
        }
    }

    private void postOrder() {
        postOrder(0);
    }

    private void postOrder(int index) {
        if (null == arr || arr.length == 0) {
            System.out.println("树为空！");
            return;
        }
        int next;
        if ((next = 2 * index + 1) < arr.length) {
            postOrder(next);
        }
        if ((next = 2 * index + 2) < arr.length) {
            postOrder(next);
        }
        System.out.println(arr[index]);
    }

    public static void main(String[] args) {
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println("===> 前序");
        arrayBinaryTree.preOrder();
        System.out.println("===> 中序");
        arrayBinaryTree.infixOrder();
        System.out.println("===> 后序");
        arrayBinaryTree.postOrder();
    }
}
