package io.ilss.datastructure.tree;

/**
 * @author feng
 */
public class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public void preOrder() {
        this.preOrder(root);
    }

    public void infixOrder() {
        this.infixOrder(root);
    }

    public void postOrder() {
        this.postOrder(root);
    }

    public BinaryTreeNode preSearch(int value) {
        return this.preSearch(root, value);
    }


    public BinaryTreeNode infixSearch(int value) {
        return this.infixSearch(root, value);
    }

    public BinaryTreeNode postSearch(int value) {
        return this.postSearch(root, value);
    }

    private void preOrder(BinaryTreeNode node) {
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

    private void infixOrder(BinaryTreeNode node) {
        if (null == node) {
            return;
        }
        if (null != node.left) {
            this.infixOrder(node.left);
        }
        System.out.println(node);
        if (null != node.right) {
            this.infixOrder(node.right);
        }
    }

    private void postOrder(BinaryTreeNode node) {
        if (null == node) {
            return;
        }
        if (null != node.left) {
            this.postOrder(node.left);
        }
        if (null != node.right) {
            this.postOrder(node.right);
        }
        System.out.println(node);
    }

    private BinaryTreeNode preSearch(BinaryTreeNode node, int value) {
        if (null == node) {
            return null;
        }

        System.out.println("当前查找节点: " + node);
        if (value == node.value) {
            return node;
        }

        BinaryTreeNode result = null;
        if (null != node.left) {
            result = this.preSearch(node.left, value);
        }
        if (null != result) {
            return result;
        }

        if (null != node.right) {
            result = this.preSearch(node.right, value);
        }
        return result;
    }

    private BinaryTreeNode infixSearch(BinaryTreeNode node, int value) {
        if (null == node) {
            return null;
        }
        BinaryTreeNode result = null;
        // 左递归
        if (null != node.left) {
            result = this.infixSearch(node.left, value);
        }
        if (null != result) {
            return result;
        }

        System.out.println("当前查找节点: " + node);
        if (value == node.value) {
            return node;
        }

        // 右递归
        if (null != node.right) {
            result = this.infixSearch(node.right, value);
        }
        return result;
    }

    private BinaryTreeNode postSearch(BinaryTreeNode node, int value) {
        if (null == node) {
            return null;
        }
        BinaryTreeNode result = null;

        // 左递归
        if (null != node.left && null != (result = this.postSearch(node.left, value))) {
            return result;
        }
        // 右递归
        if (null != node.right && null != (result = this.postSearch(node.right, value))) {
            return result;
        }

        System.out.println("当前查找节点: " + node);
        if (value == node.value) {
            return node;
        }
        return null;
    }


    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
        node3.left = node5;

        BinaryTree binaryTree = new BinaryTree(node1);

        System.out.println("===> 前序");
        binaryTree.preOrder();
        System.out.println("===> 中序");
        binaryTree.infixOrder();
        System.out.println("===> 后序");
        binaryTree.postOrder();

        System.out.println("===> 查找");
        System.out.println("===> 前序查找");
        BinaryTreeNode preSearchResult = binaryTree.preSearch(2);
        System.out.println(preSearchResult);
        System.out.println("===> 中序查找");
        BinaryTreeNode infixSearchResult = binaryTree.infixSearch(3);
        System.out.println(infixSearchResult);
        System.out.println("===> 后序查找");
        BinaryTreeNode postSearchResult = binaryTree.postSearch(6);
        System.out.println(postSearchResult);

    }
}
