package com.imyiren.datastructure.tree;

/**
 * @author feng
 */
public class AVLTreeNode {
    public int value;
    public AVLTreeNode left;
    public AVLTreeNode right;

    public AVLTreeNode(int value) {
        this.value = value;
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    public int leftHeight() {
        return null == left ? 0 : left.height();
    }

    public int rightHeight() {
        return null == right ? 0 : right.height();
    }

    public void leftRotate() {
        // 创建新节点
        AVLTreeNode node = new AVLTreeNode(this.value);
        // 把新节点的左子树设置成当前节点的左子树
        node.left = this.left;
        // 把新的节点的右子树设置成当前节点的右子树的左子树
        node.right = this.right.left;
        // 把当前节点的值替换成右子节点的值
        this.value = this.right.value;
        // 把当前节点的右子节点 设置成 当前节点的右子节点的右子节点
        this.right = this.right.right;
        // 把当前节点的左子节点 设置成 新的节点
        this.left = node;
    }

    public void rightRotate() {
        // 创建新节点
        AVLTreeNode node = new AVLTreeNode(this.value);
        // 把新节点的右子树设置成当前节点的右子树
        node.right = this.right;
        // 把新的节点的左子树设置成当前节点的左子树的右子树
        node.left = this.left.right;
        // 把当前节点的值替换成左子节点的值
        this.value = this.left.value;
        // 把当前节点的左子节点 设置成 当前节点的左子节点的左子节点
        this.left = this.left.left;
        // 把当前节点的右子节点 设置成 新的节点
        this.right = node;
    }

    @Override
    public String toString() {
        return "AVLTreeNode{" +
                "value=" + value +
                '}';
    }
}
