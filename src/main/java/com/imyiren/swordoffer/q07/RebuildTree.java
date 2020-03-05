package com.imyiren.swordoffer.q07;

/**
 * @author yiren
 */
public class RebuildTree {
    public static void main(String[] args) {
        int[] preArr = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] infixArr = {4, 7, 2, 1, 5, 3, 8, 6};
        Node root = rebuildTree(preArr, infixArr);
        preOrder(root);

    }

    private static class Node {
        private int value;
        private Node left;
        private Node right;

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

    private static Node rebuildTree(int[] preArr, int[] infixArr) {
        if (null == preArr || preArr.length < 1 || preArr.length != infixArr.length) {
            return null;
        }
        Node root = new Node(0);
        rebuildTree(root, preArr, 0, preArr.length - 1, infixArr, 0, infixArr.length - 1);
        return root;
    }

    private static void rebuildTree(Node node, int[] preArr, int preLeft, int preRight, int[] infixArr, int infixLeft, int infixRight) {
        node.value = preArr[preLeft];
        int infixMiddle = 0;
        for (int i = infixLeft; i <= infixRight; i++) {
            if (infixArr[i] == node.value) {
                infixMiddle = i;
            }
        }
        if (infixMiddle != infixLeft) {
            node.left = new Node(0);
            rebuildTree(node.left,
                    preArr, preLeft + 1, preLeft + infixMiddle - infixLeft,
                    infixArr, infixLeft, infixMiddle - 1);
        }
        if (infixMiddle != infixRight) {
            node.right = new Node(0);
            rebuildTree(node.right,
                    preArr, preLeft + infixMiddle - infixLeft + 1, preRight,
                    infixArr, infixMiddle + 1, infixRight);
        }

    }

    private static void preOrder(Node node) {
        if (null == node) {
            return;
        }
        System.out.println(node);
        if (null != node.left) {
            preOrder(node.left);
        }
        if (null != node.right) {
            preOrder(node.right);
        }
    }
}
