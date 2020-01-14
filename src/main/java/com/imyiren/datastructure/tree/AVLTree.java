package com.imyiren.datastructure.tree;

/**
 * @author feng
 */
public class AVLTree {
    public AVLTreeNode root;

    public void add(AVLTreeNode node) {
        if (root == null) {
            root = node;
            return;
        }
        this.add(root, node);
    }

    private void add(AVLTreeNode curNode, AVLTreeNode node) {
        if (null == node) {
            return;
        }

        if (node.value < curNode.value) {
            // 左边为空就添加
            if (null == curNode.left) {
                curNode.left = node;
            } else {
                // 否则就递归做子树
                add(curNode.left, node);
            }
        } else {
            // 左边为空就添加
            if (null == curNode.right) {
                curNode.right = node;
            } else {
                // 否则就递归做子树
                add(curNode.right, node);
            }
        }

        if (root.leftHeight() - root.rightHeight() > 1) {
            // 左旋转
            this.root.leftRotate();
        }
        if (root.rightHeight() - root.leftHeight() > 1) {
            // 左旋转
            this.root.rightRotate();
        }
    }


    private void infixOrder(AVLTreeNode node) {
        if (null == node) {
            return;
        }
        if (null != node.left) {
            infixOrder(node.left);
        }
        System.out.println(node);
        if (null != node.right) {
            infixOrder(node.right);
        }
    }

    public void infixOrder() {
        this.infixOrder(this.root);
    }


    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 5, 7, 8};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new AVLTreeNode(arr[i]));
        }
        avlTree.infixOrder();

        System.out.print("没有平衡前的树的高度: " + avlTree.root.height() + "\n");
        System.out.print("没有平衡前的树的左子树高度: " + avlTree.root.left.height() + "\n");
        System.out.print("没有平衡前的树的右子树高度: " + avlTree.root.right.height() + "\n");

        int[] arr2 = {10, 12, 9, 9, 7, 6};
        avlTree = new AVLTree();
        for (int i = 0; i < arr2.length; i++) {
            avlTree.add(new AVLTreeNode(arr2[i]));
        }
        avlTree.infixOrder();

        System.out.print("没有平衡前的树的高度: " + avlTree.root.height() + "\n");
        System.out.print("没有平衡前的树的左子树高度: " + avlTree.root.left.height() + "\n");
        System.out.print("没有平衡前的树的右子树高度: " + avlTree.root.right.height() + "\n");

    }
}
