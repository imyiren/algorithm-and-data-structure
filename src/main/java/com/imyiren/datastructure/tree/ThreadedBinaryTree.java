package com.imyiren.datastructure.tree;

/**
 * @author yiren
 */
public class ThreadedBinaryTree {
    private ThreadedBinaryTreeNode root;

    public ThreadedBinaryTree(ThreadedBinaryTreeNode root) {
        this.root = root;
    }

    public void infixOrder() {
        this.infixOrder(root);
    }

    private void infixOrder(ThreadedBinaryTreeNode node) {
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

    public void preOrder() {
        this.preOrder(root);
    }

    private void preOrder(ThreadedBinaryTreeNode node) {
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

    private void infixThreaded() {
        ThreadedBinaryTreeNode node = this.root;

        while (null != node) {
            // 中序首先会往左走，由于上面做线索化的时候，及时pre为空 也会把isLeft设置为true
            // 所以 这个地方只有走到做左侧 的第一个线索 就是最左叶子节点，此时就输出
            while (!node.isLeftThreaded) {
                node = node.left;
            }
            System.out.println(node);

            // 而此处测试根据右线索遍历，输出 直到没有右线索，
            // 此时左边的 肯定已经被遍历完了 所以 结束过后 直接向右子树移动
            while (node.isRightThreaded) {
                node = node.right;
                System.out.println(node);
            }
            node = node.right;
        }
    }

    private void preThreaded() {
        ThreadedBinaryTreeNode node = this.root;

        while (null != node) {
            System.out.println(node);

            while (!node.isRightThreaded) {
                node = node.left;
                System.out.println(node);
            }

            while (node.isRightThreaded) {
                node = node.right;
                System.out.println(node);
            }

            node = null != node.right ? node.left : node.right;
        }
    }

    public void infixThreadedNodes() {
        infixThreadedNodes(root);
    }

    private ThreadedBinaryTreeNode pre;

    // 对二叉树进行中序线索化
    private void infixThreadedNodes(ThreadedBinaryTreeNode node) {
        if (null == node) {
            return;
        }
        this.infixThreadedNodes(node.left);
        if (null == node.left) {
            node.left = this.pre;
            node.isLeftThreaded = true;
        }
        if (null != pre && null == pre.right) {
            this.pre.right = node;
            this.pre.isRightThreaded = true;
        }
        // 这个地方一定要更改前驱节点
        this.pre = node;

        this.infixThreadedNodes(node.right);
    }

    public void preThreadedNodes() {
        preThreadedNodes(root);
    }


    // 对二叉树进行后序线索化
    private void preThreadedNodes(ThreadedBinaryTreeNode node) {
        if (null == node) {
            return;
        }

        // 先做线索 然后再递归左右子树
        if (null == node.left) {
            node.left = this.pre;
            node.isLeftThreaded = true;
        }
        if (null != pre && null == pre.right) {
            this.pre.right = node;
            this.pre.isRightThreaded = true;
        }
        // 这个地方一定要更改前驱节点
        this.pre = node;

        if (!node.isLeftThreaded) {
            this.preThreadedNodes(node.left);
        }
        if (!node.isRightThreaded) {
            this.preThreadedNodes(node.right);
        }
    }

    public static void main(String[] args) {
        ThreadedBinaryTreeNode node1 = new ThreadedBinaryTreeNode(1);
        ThreadedBinaryTreeNode node2 = new ThreadedBinaryTreeNode(2);
        ThreadedBinaryTreeNode node3 = new ThreadedBinaryTreeNode(3);
        ThreadedBinaryTreeNode node4 = new ThreadedBinaryTreeNode(4);
        ThreadedBinaryTreeNode node5 = new ThreadedBinaryTreeNode(5);
        ThreadedBinaryTreeNode node6 = new ThreadedBinaryTreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        ThreadedBinaryTree binaryTree = new ThreadedBinaryTree(node1);

        System.out.println("===> 前序遍历");
        binaryTree.preOrder();

        System.out.println("===> node 5: " + node5);
        binaryTree.preThreadedNodes();
        System.out.println("===> After threaded: node 5: " + node5);
        System.out.println("===> nede 5's left : " + node5.left);
        System.out.println("===> nede 5's right : " + node5.right);

        binaryTree.preThreaded();
        // System.out.println(node);
    }
}
