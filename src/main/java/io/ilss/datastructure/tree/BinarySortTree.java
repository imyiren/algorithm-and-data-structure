package io.ilss.datastructure.tree;

import java.util.Random;

/**
 * @author feng
 */
public class BinarySortTree {
    public BinarySortTreeNode root;

    public void add(BinarySortTreeNode node) {
        if (root == null) {
            root = node;
            return;
        }
        this.add(root, node);
    }

    private void add(BinarySortTreeNode curNode, BinarySortTreeNode node) {
        if (null == node) {
            return;
        }

        if (node.value < curNode.value) {
            // 左边为空就添加
            if (null == curNode.left) {
                curNode.left = node;
                return;
            }
            // 否则就递归做子树
            add(curNode.left, node);
        } else {
            // 左边为空就添加
            if (null == curNode.right) {
                curNode.right = node;
                return;
            }
            // 否则就递归做子树
            add(curNode.right, node);
        }
    }

    public void remove(BinarySortTreeNode node) {
        // this.remove(this.root, node);
    }

    private void remove(int value) {
        // 没有东西直接返回
        if (this.root == null) {
            return;
        }

        // 要删除的节点
        BinarySortTreeNode node = null;
        // 要删除节点的父节点
        BinarySortTreeNode parent = null;
        // 查找要删除节点的父节点和要删除的节点
        BinarySortTreeNode tempNode = root;
        while (null != tempNode) {
            // 查找要删除的节点
            if (value == tempNode.value) {
                node = tempNode;
                break;
            }
            // 向左
            if (value < tempNode.value) {
                parent = tempNode;
                tempNode = tempNode.left;
            }
            // 向右
            if (value > tempNode.value) {
                parent = tempNode;
                tempNode = tempNode.right;
            }
        }

        // 特殊情况优先判断
        if (null == node) {
            System.out.println("没有要删除的节点");
            return;
        }

        // 如果根节点 没有左右子树 直接置空
        if (null == root.left && null == root.right) {
            System.out.println("===> 删除节点是根节点");
            root = null;
            return;
        }


        // 第一种：叶子节点
        // 找到目标节点node
        // 找到目标节点的父节点parent 考虑根节点没有父节点
        // 确定node 是parent的左子节点还是右子节点
        // 根据情况来对应删除

        // 左子节点 parent.left = null
        // 右子节点 parent.right = null

        // 如果要删除的是子节点。
        if (null == node.left && null == node.right) {
            System.out.println("===> 删除节点是子节点");
            // 这个地方要判空 因为你不确定是左边还是右边，也可以比较value的值 比如左边：node.value < parent.value
            if (null != parent.left && parent.left.value == node.value) {
                parent.left = null;
            }
            if (null != parent.right && parent.right.value == node.value) {
                parent.right = null;
            }
            return;
        }

        // ====================================================
        // 第二种：非叶子节点
        // 找到目标节点node
        // 找到目标节点的父节点parent 考虑根节点没有父节点
        // 确定node 是parent的左子节点还是右子节点

        // 左：
        // 如果node的子节点是左节点：parent.left = node.left
        // 如果node的子节点是右节点：parent.left = node.right

        // 右：
        // 如果node的子节点是左节点：parent.right = node.left
        // 如果node的子节点是右节点：parent.right = node.right

        // 开始处理要删除的节点有做左子树 或者右子树
        // 有左没有右
        if (null != node.left && null == node.right) {
            System.out.println("===> 删除节点有左子树");
            if (null == parent) {
                root = node.left;
                return;
            }

            // 删除的节点在父节点的左边
            if (null != parent.left && parent.left.value == node.value) {
                parent.left = node.left;
            }
            if (null != parent.right && parent.right.value == node.value) {
                parent.right = node.left;
            }
            return;
        }
        // 有右没有左
        if (null != node.right && null == node.left) {
            System.out.println("===> 删除节点有右子树");
            if (null == parent) {
                root = node.right;
                return;
            }
            // 删除的节点在父节点的左边
            if (null != parent.left && parent.left.value == node.value) {
                parent.left = node.right;
            }
            if (null != parent.right && parent.right.value == node.value) {
                parent.right = node.right;
            }
            return;
        }


        // ====================================================
        // 第三种：删除有两颗子树的节点。
        // 找到node右子树中最小的节点 并保存在临时变量 temp 中
        // 删除node右子树中最小的节点
        // 把temp赋值给node

        // 最后处理左右都有子树的情况
        // 找到删除节点的右子树种最小的值
        System.out.println("===> 删除节点有左右子树");
        // 当前代码是从右子树找到最小的替代， 也可以使用左子树最大的去替代。
        BinarySortTreeNode tempParent = node;
        tempNode = node.right;
        while (null != tempNode.left) {
            tempParent = tempNode;
            tempNode = tempNode.left;
        }
        node.value = tempNode.value;
        tempParent.left = null;

    }


    private void infixOrder(BinarySortTreeNode node) {
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
        BinarySortTree sortTree = new BinarySortTree();
        sortTree.add(new BinarySortTreeNode(5));
        sortTree.add(new BinarySortTreeNode(3));
        sortTree.add(new BinarySortTreeNode(7));
        sortTree.add(new BinarySortTreeNode(6));
        sortTree.add(new BinarySortTreeNode(8));
        sortTree.add(new BinarySortTreeNode(1));
        sortTree.add(new BinarySortTreeNode(4));
        sortTree.infixOrder();
        System.out.println("============> remove 19");
        sortTree.remove(19);
        sortTree.infixOrder();
        System.out.println("============> remove 3");
        sortTree.remove(3);
        sortTree.infixOrder();
        System.out.println("============> remove 8");
        sortTree.remove(8);
        sortTree.infixOrder();

        System.out.println("=====> 构建只有根节点的树");
        sortTree = new BinarySortTree();
        sortTree.add(new BinarySortTreeNode(5));
        sortTree.add(new BinarySortTreeNode(1));
        System.out.println("============> remove 5");
        sortTree.remove(5);
        sortTree.infixOrder();
    }
}
